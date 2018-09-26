package com.example.shipping.dto.events;

import com.example.shipping.dto.requests.ShipCreationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class ShipCreationFailedEvent extends ExceptionEvent{
	public ShipCreationRequestDTO shipCreationRequestDTO;
	private static String EVENT_NAME = "ShipCreationFailedEvent";
	
	public ShipCreationFailedEvent(ShipCreationRequestDTO req, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		this.shipCreationRequestDTO = req;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", req.getBusName());
		this.addHeader("locnNbr", req.getLocnNbr());
		this.addHeader("OrderNbr", req.getOrderNbr());
		this.addHeader("company", req.getCompany());
		this.addHeader("division", req.getDivision());
		this.addHeader("busUnit", req.getBusUnit());
	}

}
