package kr.co.sellerall.sellide.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/order-manage")
public class OrderManageRestController {
	private static final Logger logger = LoggerFactory.getLogger(OrderManageRestController.class);

}
