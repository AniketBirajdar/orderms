package com.api.order.dto;

public class OrderedProducts {
	
	Integer orderid;
	Integer prodid;
	Integer quantity;
	Double price;
	Integer sellerid;
	String status;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
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
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderedProducts [orderid=" + orderid + ", prodid=" + prodid + ", quantity=" + quantity + ", price="
				+ price + ", sellerid=" + sellerid + ", status=" + status + "]";
	}
	
	
	
}
