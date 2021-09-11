package com.api.order.dto;

import com.api.order.entity.Productsordered;

public class ProductsorderedDTO {

	Integer buyerid;
	Integer prodid;
	Integer sellerid;
	Integer quantity;

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

	// Converts Entity into DTO
	public static ProductsorderedDTO valueOf(Productsordered productOrdered) {
		ProductsorderedDTO productOrderDTO = new ProductsorderedDTO();
		productOrderDTO.setBuyerid(productOrdered.getBuyerid());
		productOrderDTO.setProdid(productOrdered.getProdid());
		productOrderDTO.setQuantity(productOrdered.getQuantity());
		productOrderDTO.setSellerid(productOrdered.getSellerid());
		return productOrderDTO;
	}

	@Override
	public String toString() {
		return "ProductsOrderedDTO [buyerid=" + buyerid + ", prodid=" + prodid + ", sellerid=" + sellerid
				+ ", quantity=" + quantity + "]";
	}

}
