package com.api.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "orderid")
	Integer orderid;
	@Column(nullable = false)
	Integer buyerid;
	@Column(nullable = false)
	Integer amount;
	@Column(nullable = false)
	Date orderdate;
	@Column(nullable = false)
	String address;
	@Column(nullable = false)
	String status;
	
	public Order() {
		super();
	}

	
	public Order(Integer orderid, Integer buyerid, Integer amount, Date orderdate, String address, String status) {
		super();
		this.orderid = orderid;
		this.buyerid = buyerid;
		this.amount = amount;
		this.orderdate = orderdate;
		this.address = address;
		this.status = status;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public Integer getBuyerid() {
		return buyerid;
	}


	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Date getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", buyerid=" + buyerid + ", amount=" + amount + ", orderdate=" + orderdate
				+ ", address=" + address + ", status=" + status + "]";
	}


}
