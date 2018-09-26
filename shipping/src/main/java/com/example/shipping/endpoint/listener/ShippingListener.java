package com.example.shipping.endpoint.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.example.order.dto.events.OrderCreatedEvent;
import com.example.shipping.dto.converter.OrderToShipConverter;
import com.example.shipping.service.ShippingService;
import com.example.shipping.streams.ShippingStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ShippingListener {
	@Autowired
	ShippingService orderService;

	@StreamListener(target=ShippingStreams.ORDERS_OUTPUT, condition = "headers['eventName']=='OrderCreatedEvent'")
	public void handleNewOrder(OrderCreatedEvent orderCreatedEvent) { // OrderCreationRequestDTO
																					// orderCreationRequestDTO) {
		log.info("Received OrderCreatedEvent Msg: {}" + ": at :" + new java.util.Date(), orderCreatedEvent);
		long startTime = System.currentTimeMillis();
		try {
			orderService.createShip(OrderToShipConverter.getShipCreationRequestDTO(orderCreatedEvent));
			long endTime = System.currentTimeMillis();
			log.info("Completed OrderCreatedEvent for : " + orderCreatedEvent + ": at :" + new java.util.Date()
					+ " : total time:" + (endTime - startTime) / 1000.00 + " secs");
		} catch (Exception e) {
			e.printStackTrace();
			long endTime = System.currentTimeMillis();
			log.error("Error Completing OrderCreatedEvent for : " + orderCreatedEvent + ": at :"
					+ new java.util.Date() + " : total time:" + (endTime - startTime) / 1000.00 + " secs", e);
		}
	}
}
