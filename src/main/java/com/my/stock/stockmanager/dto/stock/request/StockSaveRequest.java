package com.my.stock.stockmanager.dto.stock.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockSaveRequest {
	private Long bankId;
	private String symbol;
	private Double quantity;
	private Double price;
}
