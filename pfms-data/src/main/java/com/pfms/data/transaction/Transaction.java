package com.pfms.data.transaction;

import java.util.Date;

public class Transaction {
	private Integer id;
	private TransactionType type;
	private Integer quantity;
	private Double price;
	private String clientId;
	private Date executionDate;
	private Date settlementDate;

	public Transaction() {
	}

	/**
	 * @param id
	 * @param type
	 * @param quantity
	 * @param price
	 * @param clientId
	 * @param executionDate
	 * @param settlementDate
	 */
	public Transaction(Integer id, TransactionType type, Integer quantity, Double price, String clientId,
			Date executionDate, Date settlementDate) {
		super();
		this.id = id;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.clientId = clientId;
		this.executionDate = executionDate;
		this.settlementDate = settlementDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
}
