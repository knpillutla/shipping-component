package com.example.shipping.dto.converter;

import com.example.order.dto.events.OrderCreatedEvent;
import com.example.order.dto.responses.OrderDTO;
import com.example.shipping.dto.requests.ShipCreationRequestDTO;

public class OrderToShipConverter {

	public static ShipCreationRequestDTO getShipCreationRequestDTO(OrderCreatedEvent orderCreatedEvent) {
		OrderDTO orderDTO = orderCreatedEvent.getOrderDTO();
		ShipCreationRequestDTO shipCreationRequestDTO = new ShipCreationRequestDTO();
		shipCreationRequestDTO.setFirstName(orderDTO.getDelFirstName());
		shipCreationRequestDTO.setLastName(orderDTO.getDelLastName());
		shipCreationRequestDTO.setAddr1(orderDTO.getDelAddr1());
		shipCreationRequestDTO.setAddr2(orderDTO.getDelAddr2());
		shipCreationRequestDTO.setAddr3(orderDTO.getDelAddr3());
		shipCreationRequestDTO.setCity(orderDTO.getDelCity());
		shipCreationRequestDTO.setState(orderDTO.getDelState());
		shipCreationRequestDTO.setCountry(orderDTO.getDelCountry());
		shipCreationRequestDTO.setZipcode(orderDTO.getDelZipcode());
		shipCreationRequestDTO.setBusName(orderDTO.getBusName());
		shipCreationRequestDTO.setLocnNbr(orderDTO.getLocnNbr());
		shipCreationRequestDTO.setCompany(orderDTO.getCompany());
		shipCreationRequestDTO.setDivision(orderDTO.getDivision());
		shipCreationRequestDTO.setBusUnit(orderDTO.getBusUnit());
		shipCreationRequestDTO.setBatchNbr(orderDTO.getBatchNbr());
		shipCreationRequestDTO.setOrderNbr(orderDTO.getOrderNbr());
		shipCreationRequestDTO.setOrderDttm(orderDTO.getOrderDttm());
		shipCreationRequestDTO.setExpectedDeliveryDttm(orderDTO.getExpectedDeliveryDttm());
		shipCreationRequestDTO.setShipByDttm(orderDTO.getShipByDttm());
		shipCreationRequestDTO.setDeliveryType(orderDTO.getDeliveryType());
		
		return shipCreationRequestDTO;
	}

}
