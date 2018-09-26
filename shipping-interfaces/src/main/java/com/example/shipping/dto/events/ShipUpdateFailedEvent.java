package com.example.shipping.dto.events;

import com.example.shipping.dto.requests.ShipUpdateRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class ShipUpdateFailedEvent extends ExceptionEvent{
	public ShipUpdateRequestDTO shipUpdateReq;
	private static String EVENT_NAME = "ShipUpdateFailedEvent";
	public ShipUpdateFailedEvent(ShipUpdateRequestDTO req, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		this.shipUpdateReq = req;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", req.getBusName());
		this.addHeader("locnNbr", req.getLocnNbr());
		this.addHeader("OrderNbr", req.getOrderNbr());
		this.addHeader("company", req.getCompany());
		this.addHeader("division", req.getDivision());
		this.addHeader("busUnit", req.getBusUnit());
	}

}
