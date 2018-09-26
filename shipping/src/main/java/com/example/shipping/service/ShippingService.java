package com.example.shipping.service;

import com.example.shipping.dto.requests.ShipCreationRequestDTO;
import com.example.shipping.dto.requests.ShipLineStatusUpdateRequestDTO;
import com.example.shipping.dto.requests.ShipUpdateRequestDTO;
import com.example.shipping.dto.responses.ShipDTO;

public interface ShippingService {
	public ShipDTO findById(String busName, Integer locnNbr, Long id) throws Exception;
	public ShipDTO createShip(ShipCreationRequestDTO shipCreationReq) throws Exception;
	public ShipDTO updateShip(ShipUpdateRequestDTO shipUpdRequest) throws Exception;
}