package com.api.order.composite;

import java.io.Serializable;


public class SubscribedorderID implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer buyerid;
	private Integer prodid;

	// default constructor
	public SubscribedorderID() {
		
	}

	public SubscribedorderID(Integer buyerid, Integer prodid) {
		this.buyerid = buyerid;
		this.prodid = prodid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerid == null) ? 0 : buyerid.hashCode());
		result = prime * result + ((prodid == null) ? 0 : prodid.hashCode());
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
		SubscribedorderID other = (SubscribedorderID) obj;
		if (buyerid == null) {
			if (other.buyerid != null)
				return false;
		} else if (!buyerid.equals(other.buyerid))
			return false;
		if (prodid == null) {
			if (other.prodid != null)
				return false;
		} else if (!prodid.equals(other.prodid))
			return false;
		return true;
	}

	

}