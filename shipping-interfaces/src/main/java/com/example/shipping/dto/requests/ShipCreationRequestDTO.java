package com.example.shipping.dto.requests;

import java.util.Date;
import java.util.List;

import com.example.shipping.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ShipCreationRequestDTO extends BaseDTO{
	String busName;
	Integer locnNbr;
	String company;
	String division;
	String busUnit;
	String batchNbr;
	Long orderId;
	String orderNbr;
	Date orderDttm;
	Date shipByDttm;
	Date expectedDeliveryDttm;
	String deliveryType;
    String firstName;
    String lastName;
    String middleName;
    String addr1;
    String addr2;
    String addr3;
    String city;
    String state;
    String country;
    String zipcode;
    String phoneNbr;
	String source;
	String transactionName;
	String refField1;
	String refField2;
	String userId;
	List<ShipLineCreationRequestDTO> shipLines;
}

