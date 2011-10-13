/**
 * 
 */
package com.doublelife.doublelife.data.asset.stocks;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a stock order used for buying and selling stock.
 * @author Joseph McAleer
 *
 */
@Entity (name = "stock_order")
public class StockOrder {

	/**
	 * Vale representing an order still pending.
	 */
	public static int PENDING_ORDER = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "stockCode")
	private String stockCode;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "atMarket")
	private int atMarket;
	
	@Column(name = "orderPrice")
	private double orderPrice;
	
	//date order is made
	@Column(name = "order_dateTime")
	private Date orderDateTime;
	
	@Column(name = "update_DateTime")
	private Date updateDateTime;
	
	//the date the order is actually processed
	@Column(name = "processed_DateTime")
	private Date processedDateTime;
	
	@Column(name = "completed")
	private int completed;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the stockCode
	 */
	public String getStockCode() {
		return stockCode;
	}

	/**
	 * @param stockCode the stockCode to set
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the atMarket
	 */
	public int getAtMarket() {
		return atMarket;
	}

	/**
	 * @param atMarket the atMarket to set
	 */
	public void setAtMarket(int atMarket) {
		this.atMarket = atMarket;
	}

	/**
	 * @return the orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * @return the orderDateTime
	 */
	public Date getOrderDateTime() {
		return orderDateTime;
	}

	/**
	 * @param orderDateTime the orderDateTime to set
	 */
	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the processedDateTime
	 */
	public Date getProcessedDateTime() {
		return processedDateTime;
	}

	/**
	 * @param processedDateTime the processedDateTime to set
	 */
	public void setProcessedDateTime(Date processedDateTime) {
		this.processedDateTime = processedDateTime;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}

	/**
	 * @return the completed
	 */
	public int getCompleted() {
		return completed;
	}
}
