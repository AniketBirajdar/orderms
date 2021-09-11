package com.api.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.api.order.composite.SubscribedorderID;

@Entity
@IdClass(SubscribedorderID.class)
public class Productsordered { 
	@Id
	@Column(name = "buyerid", nullable = false)
	Integer buyerid;
	@Id
	@Column(name = "prodid", nullable = false)
	Integer prodid;
	@Column(name = "sellerid", nullable = false)
	Integer sellerid;
	@Column(name = "quantity", nullable = false)
	Integer quantity;

	public Productsordered() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Productsordered(Integer buyerid, Integer prodid, Integer sellerid, Integer quantity) {
		super();
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.sellerid = sellerid;
		this.quantity = quantity;
	}

	public Integer getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductsOrdered [buyerid=" + buyerid + ", prodid=" + prodid + ", sellerid=" + sellerid + ", quantity="
				+ quantity + "]";
	}

}
