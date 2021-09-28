package kr.co.sellerall.sellide.component;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import kr.co.sellerall.cmm.exception.RESTException;
import kr.co.sellerall.sellide.config.Constants;

/**
 * @packageName   : kr.co.sellerall.sellide.component
 * @fileName      : RESTUtils.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon     최초생성
 *
 */
@Component
public class RESTUtils {

	private static Logger logger = LoggerFactory.getLogger(RESTUtils.class);

	public static String request(String targetURL) {
		return request(targetURL, (String) null, Constants.HTTP_GET);
	}

	public static String request(String targetURL, String payload) {
		return request(targetURL, payload, Constants.HTTP_GET);
	}


	public static String request(String targetURL, String payload, int httpMethod) {
		return request(targetURL, payload, httpMethod, Constants.CHARSET, true);
	}

	public static String request(String targetURL, String payload, int httpMethod, boolean useSocketTimeout) {
		return request(targetURL, payload, httpMethod, Constants.CHARSET, useSocketTimeout);
	}

	public static String request(String targetURL, String payload, int httpMethod, String charset,
			boolean useSocketTimeout) {
		Integer timeout = 10000;
		if (System.getProperty("ws.enginelist.delay") != null) {
			timeout = Integer.parseInt(System.getProperty("ws.enginelist.delay")) * 1000;
		}
		return request(targetURL, payload, httpMethod, Constants.CHARSET, useSocketTimeout, timeout);
	}

	private static String request(String targetURL, String payload, int httpMethod, String charset,
			boolean useSocketTimeout, int timeout) {
		
		Builder builder = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout);
		if (useSocketTimeout) {
			builder.setSocketTimeout(timeout);
		}
		RequestConfig config = builder.build();
		CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		logger.debug("request url >> {}", targetURL);

		String result = null;
		try {
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					logger.debug("check :"+response.getStatusLine().getStatusCode());
					HttpEntity ent =  response.getEntity();
					logger.debug("check :"+ent.getContentEncoding());
					logger.debug("check :"+ent.getContentType());
					logger.debug("check :"+response.getLocale());
					logger.debug("check :"+charset);
					HttpEntity entity = response.getEntity();
					if ((status >= 200 && status < 300) || status == 400) {
						return entity != null ? EntityUtils.toString(entity, charset) : null;
					} else {
						throw new RESTException(status, EntityUtils.toString(entity, charset));
					}
				}
			};

			String responseBody;
			if (httpMethod == Constants.HTTP_POST) {
				HttpPost http = new HttpPost(targetURL);
				http.setEntity(new StringEntity(payload, charset));
				responseBody = (String) httpclient.execute(http, responseHandler);
			} else if (httpMethod == Constants.HTTP_PUT) {
				HttpPut http = new HttpPut(targetURL);
				http.setHeader("Accept", "application/json");
				http.setHeader("Content-type", "text/plain; charset=" + charset);
				if (payload != null) {
					http.setEntity(new StringEntity(payload, charset));
				}
				responseBody = (String) httpclient.execute(http, responseHandler);
			} else if (httpMethod == Constants.HTTP_DELETE) {
				HttpDelete http = new HttpDelete(targetURL);
				responseBody = (String) httpclient.execute(http, responseHandler);
			} else {
				HttpGet http = new HttpGet(targetURL);
				/*RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(timeout)
						  .setConnectTimeout(timeout)
						  .setConnectionRequestTimeout(timeout)
						  .build();
				http.setConfig(requestConfig);
				http.setHeader("Accept", "application/json");
				http.setHeader("Content-type", "application/json; charset="+ charset);*/
				responseBody = httpclient.execute(http, responseHandler);
				
			}

			logger.trace("response body >> {}", responseBody);
			logger.debug("response body >> {}", responseBody);
			result = responseBody;
		} catch (RESTException e) {
			throw e;
		} catch (ConnectException e) {
			throw new RESTException(-3, e.getMessage());
		} catch (ConnectTimeoutException e) {
			throw new RESTException(-2, e.getMessage());
		} catch (SocketTimeoutException e) {
			throw new RESTException(-2, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RESTException(e.getMessage());
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return result;
	}
}
