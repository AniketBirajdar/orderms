package com.api.order.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.order.entity.Order;

public class OrderDTO {

	Integer orderid;
	Integer buyerid;
	Integer amount;
	Date orderdate;
	String address;
	String status;
	List<OrderedProducts>orderList=new ArrayList<OrderedProducts>();

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
	

	public List<OrderedProducts> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderedProducts> orderList) {
		this.orderList = orderList;
	}

	// Converts Entity into DTO
	public static OrderDTO valueOf(Order orders) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderid(orders.getOrderid());
		orderDTO.setBuyerid(orders.getBuyerid());
		orderDTO.setAmount(orders.getAmount());
		orderDTO.setAddress(orders.getAddress());
		orderDTO.setOrderdate(orders.getOrderdate());
		orderDTO.setStatus(orders.getStatus());
		return orderDTO;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderid=" + orderid + ", buyerid=" + buyerid + ", amount=" + amount + ", orderdate="
				+ orderdate + ", address=" + address + ", status=" + status + "]";
	}
}
