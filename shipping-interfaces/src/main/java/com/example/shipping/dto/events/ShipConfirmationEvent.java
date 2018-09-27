package com.example.shipping.dto.events;

import java.util.Map;

import com.example.shipping.dto.responses.ShipDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class ShipConfirmationEvent extends BaseEvent {
	private ShipDTO shipDTO;
	private static String EVENT_NAME = "ShipConfirmationEvent";
	public ShipConfirmationEvent(ShipDTO shipDTO) {
		this(shipDTO, null);
	}

	public ShipConfirmationEvent(ShipDTO shipDTO, Map headerMap) {
		super(EVENT_NAME);
		this.shipDTO = shipDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", this.shipDTO.getBusName());
		this.addHeader("locnNbr", this.shipDTO.getLocnNbr());
		this.addHeader("OrderNbr", this.shipDTO.getOrderNbr());
		this.addHeader("company", this.shipDTO.getCompany());
		this.addHeader("division", this.shipDTO.getDivision());
		this.addHeader("busUnit", this.shipDTO.getBusUnit());
	}
}
