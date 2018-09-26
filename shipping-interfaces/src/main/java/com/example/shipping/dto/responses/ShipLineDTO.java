package com.example.shipping.dto.responses;

import java.io.Serializable;
import java.util.Date;

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
public class ShipLineDTO  extends BaseDTO implements Serializable{
	Long id;
	Integer shipLineNbr;
	String itemBrcd;
	Integer qty;
	double itemWidth;
	double itemHeight;
	double itemLength;
	double itemUnitWt;
	double itemUnitVol;
	String source;
	String transactionName;
	String refField1;
	String refField2;
	Date updatedDttm;
	String updatedBy;
}
