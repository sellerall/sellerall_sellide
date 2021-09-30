package kr.co.sellerall.sellide.component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	/** 널이거나 빈 문자열을 원하는 스트링으로 변환한다<br>
	* 단, 좌우 공백이 있는 문자열은 trim 한다 <br>.
	*
	* @param org 입력 문자열
	* @param converted 변환 문자열
	* @return 치환된 문자열
	*/
	public String null2Str(String org, String converted) {
		if (org == null || org.trim().length() == 0) {
			return converted;
		} else {
			return org;
		}
	}
	
	/**
	 * 마진율 설정 
	 * @param price
	 * @param per
	 * @return
	 */
	public static int salePriceSetting(int price,float per) {
		int result = (int) (price * (1.0 + per / 100.0));
		/*return String.valueOf(result);*/
		return result;
	}
	
	public static String encodingString(String string){
		try {
			string=URLEncoder.encode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}
	
	public static String nvl(Object objTemp) {
		return nvl(String.valueOf(objTemp));
	}

	public static String nvl(String strTemp) {
		String rtnValue = "";
		String vTable = strTemp;

		if (vTable == null) {
			return "";
		}
		if (vTable.equals("undefined")) {
			return "";
		}
		if (vTable.equals("null")) {
			return "";
		}
		vTable = vTable.trim();

		if (vTable.equals("")) {
			rtnValue = "";
		} else {
			rtnValue = vTable;
		}

		return rtnValue;
	}
	 
	public static String lpad(String str, int len, String addStr) {
		String result = str;
		int templen   = len - result.length();

		for (int i = 0; i < templen; i++){
			result = addStr + result;
		}
	        
		return result;
	}
	
	public static String rpad(String str, int len, String addStr) {
		String result = str;
		int templen = len - result.length();

		for (int i = 0; i < templen; i++){
			result = result + addStr;
		}
	        
		return result;
	}
	 
	public static String RegTag(String str, String pstr) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(pstr);
		Matcher m = p.matcher(str);
		while( m.find() ) {       
			m.appendReplacement(sb, "");       
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public static String StringReplace(String str){       
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str =str.replaceAll(match, " ");
		return str;
	}
	
	public static HashMap csvRead(InputStream is) throws IOException {
		HashMap hm = new HashMap();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "euc-kr"));
			StringBuffer sbt = new StringBuffer();
			StringBuffer sbb = new StringBuffer();
			int i=0;
			for(String line; (line=br.readLine())!=null;) {
				String[] csvSpliteArray = null;
				String resultStr = "";
				
				String[] src = line.split("[,]"); //콤마( , )기준으로 배열을 만든다.

				int flagCnt = 0;

				String temp = "";

				for(int j=0; j < src.length; j++){
					//데이터 안에 콤마가 있을 경우 더블코테이션( " " )으로 감싸 지기 때문에 더블코테이션을 찾는다. 
					if(src[j].indexOf("\"")==0){
						//더블코테이션( " " )이 시작 부분을 찾는다.
						if(src[j].lastIndexOf("\"")==src[j].length()-1){
							resultStr += src[j].replaceAll("\"", "");
						} else {
							flagCnt++;
							temp += src[j].replaceAll("\"", "");
						}
					} else if(src[j].lastIndexOf("\"")==src[j].length()-1){
						//더블코테이션( " " )이 끝나는 부분을 찾는다.
						if(flagCnt>0){
							resultStr += temp + "," + src[j].replaceAll("\"", "");
							flagCnt = 0;
							temp = "";
						}
					} else {
						if(flagCnt>0){
							temp += "," + src[j].replaceAll("\"", "");
						} else {
							resultStr += src[j];
						}
					}
					
					if(j!=(src.length-1) && flagCnt == 0){resultStr += "@#@";}
				}
				//@#@기준으로 다시 배열을 만들면 데이터 안에 콤마( , )을 유지하면서 출력할 수 있다.
				if(i==0) {
					sbt.append(resultStr);
				} else {
					sbb.append(resultStr);
					sbb.append(System.getProperty("line.separator"));
				}
				i++;
			}
			hm.put("code", "0");
			hm.put("header", sbt);
			hm.put("list", sbb);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			hm.put("code", "-99");
			hm.put("msg", e.getMessage());
		} finally {
			is.close();
		}
		return hm;
	}
	
	public static HashMap csvRead(FileInputStream fis) throws IOException {
		HashMap hm = new HashMap();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "euc-kr"));
			StringBuffer sbt = new StringBuffer();
			StringBuffer sbb = new StringBuffer();
			int i=0;
			for(String line; (line=br.readLine())!=null;) {
				String[] csvSpliteArray = null;
				String resultStr = "";
				
				String[] src = line.split("[,]"); //콤마( , )기준으로 배열을 만든다.

				int flagCnt = 0;

				String temp = "";

				for(int j=0; j < src.length; j++){
					//데이터 안에 콤마가 있을 경우 더블코테이션( " " )으로 감싸 지기 때문에 더블코테이션을 찾는다. 
					if(src[j].indexOf("\"")==0){
						//더블코테이션( " " )이 시작 부분을 찾는다.
						if(src[j].lastIndexOf("\"")==src[j].length()-1){
							resultStr += src[j].replaceAll("\"", "");
						} else {
							flagCnt++;
							temp += src[j].replaceAll("\"", "");
						}
					} else if(src[j].lastIndexOf("\"")==src[j].length()-1){
						//더블코테이션( " " )이 끝나는 부분을 찾는다.
						if(flagCnt>0){
							resultStr += temp + "," + src[j].replaceAll("\"", "");
							flagCnt = 0;
							temp = "";
						}
					} else {
						if(flagCnt>0){
							temp += "," + src[j].replaceAll("\"", "");
						} else {
							resultStr += src[j];
						}
					}
					
					if(j!=(src.length-1) && flagCnt == 0){resultStr += "@#@";}
				}
				//@#@기준으로 다시 배열을 만들면 데이터 안에 콤마( , )을 유지하면서 출력할 수 있다.
				if(i==0) {
					sbt.append(resultStr);
				} else {
					sbb.append(resultStr);
					sbb.append(System.getProperty("line.separator"));
				}
				i++;
			}

			hm.put("code", "0");
			hm.put("header", sbt);
			hm.put("list", sbb);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			hm.put("code", "-99");
			hm.put("msg", e.getMessage());
		} finally {
			fis.close();
		}
		return hm;
	}
	
	public static String encodeURIComponent(String s) {
	    String result = null;
	    try	{
	    	result = URLEncoder.encode(s, "UTF-8")
	                         .replaceAll("\\+", "%20")
	                         .replaceAll("\\%21", "!")
	                         .replaceAll("\\%27", "'")
	                         .replaceAll("\\%28", "(")
	                         .replaceAll("\\%29", ")")
	                         .replaceAll("\\%7E", "~");
	    } catch (UnsupportedEncodingException e) {
	    	result = s;
	    }
	    return result;
	}
	 
	public static String unicodeConvert(String unicode)throws Exception {
        StringBuffer str = new StringBuffer();

        char ch = 0;
        for( int i= unicode.indexOf("\\u"); i > -1; i = unicode.indexOf("\\u") ){
            ch = (char)Integer.parseInt( unicode.substring( i + 2, i + 6 ) ,16);
            str.append( unicode.substring(0, i) );
            str.append( String.valueOf(ch) );
            unicode = unicode.substring(i + 6);
        }
        str.append( unicode );

        return str.toString();
    }
}
