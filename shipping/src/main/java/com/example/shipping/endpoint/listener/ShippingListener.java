package com.example.shipping.endpoint.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.example.order.dto.events.OrderPlannedEvent;
import com.example.shipping.dto.converter.OrderToShipConverter;
import com.example.shipping.service.ShippingService;
import com.example.shipping.streams.ShippingStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ShippingListener {
	@Autowired
	ShippingService shippingService;

	@StreamListener(target=ShippingStreams.ORDERS_OUTPUT, condition = "headers['eventName']=='OrderPlannedEvent'")
	public void handleOrderPlannedEvent(OrderPlannedEvent orderPlannedEvent) { // OrderCreationRequestDTO
																					// orderCreationRequestDTO) {
		log.info("Received OrderPlannedEvent Msg: {}" + ": at :" + new java.util.Date(), orderPlannedEvent);
		long startTime = System.currentTimeMillis();
		try {
			shippingService.createShip(OrderToShipConverter.getShipCreationRequestDTO(orderPlannedEvent));
			long endTime = System.currentTimeMillis();
			log.info("Completed OrderPlannedEvent for : " + orderPlannedEvent + ": at :" + new java.util.Date()
					+ " : total time:" + (endTime - startTime) / 1000.00 + " secs");
		} catch (Exception e) {
			e.printStackTrace();
			long endTime = System.currentTimeMillis();
			log.error("Error Completing OrderPlannedEvent for : " + orderPlannedEvent + ": at :"
					+ new java.util.Date() + " : total time:" + (endTime - startTime) / 1000.00 + " secs", e);
		}
	}
}
