package com.example.asssignment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class MarketOrder {
	@Id
	private String marketOrderId;
	private String orderId;
	private String transactionId;
	private String feeId;
	private double bid;
	private double ask;
	private String typeOfExchange;
    private String status="CREATED";
    
    
	public MarketOrder() {
		super();
	}
	
	public MarketOrder(String orderId, String transactionId, String feeId, double bid, double ask,
			String typeOfExchange) {
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.feeId = feeId;
		this.bid = bid;
		this.ask = ask;
		this.typeOfExchange = typeOfExchange;
	}
	public MarketOrder(String marketOrderId, String orderId, String transactionId, String feeId, double bid, double ask,
			String typeOfExchange, String status) {
		super();
		this.marketOrderId = marketOrderId;
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.feeId = feeId;
		this.bid = bid;
		this.ask = ask;
		this.typeOfExchange = typeOfExchange;
		this.status = status;
	}
	public String getMarketOrderId() {
		return marketOrderId;
	}
	public void setMarketOrderId(String marketOrderId) {
		this.marketOrderId = marketOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getFeeId() {
		return feeId;
	}
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public String getTypeOfExchange() {
		return typeOfExchange;
	}
	public void setTypeOfExchange(String typeOfExchange) {
		this.typeOfExchange = typeOfExchange;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
