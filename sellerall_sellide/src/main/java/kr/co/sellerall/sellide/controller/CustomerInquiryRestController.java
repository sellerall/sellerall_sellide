package kr.co.sellerall.sellide.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/customer-inquiry")
public class CustomerInquiryRestController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerInquiryRestController.class);

}
