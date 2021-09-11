package com.api.order.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.order.dto.OrderDTO;
import com.api.order.dto.ProductsorderedDTO;
import com.api.order.entity.Order;
import com.api.order.entity.Productsordered;
import com.api.order.repository.OrderRepository;
import com.api.order.repository.ProductsOrderedRepo;

@Service
@Transactional
public class OrderService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderrepo;
	@Autowired 
	ProductsOrderedRepo productOrderrepo;
	
	
	public OrderDTO getSpecificOrder(Integer orderid) {
		logger.info("Find Order request By Order ID {}", orderid);
		Order order = orderrepo.findByOrderid(orderid);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO=OrderDTO.valueOf(order);
		logger.info("Order request By Order ID {}", order);
		return orderDTO;
	}
	public List<OrderDTO> getAllOrder() {

		List<Order> orders = orderrepo.findAll();
		List<OrderDTO> orderDTOs = new ArrayList<>();

		for (Order order : orders) {
			OrderDTO orderDTO = OrderDTO.valueOf(order);
			orderDTOs.add(orderDTO);
		}

		logger.info("Product Details : {}", orderDTOs);
		return orderDTOs;
	}
	
	public List<ProductsorderedDTO>getAllProductsOrdered(Integer buyerid){
		
		List<Productsordered> productorderd = productOrderrepo.findByBuyerid(buyerid);
		List<ProductsorderedDTO> productOrderDTOs = new ArrayList<ProductsorderedDTO>();
		for (Productsordered  productOrder : productorderd) {
			ProductsorderedDTO productOrderDTO = ProductsorderedDTO.valueOf(productOrder);
			productOrderDTOs.add(productOrderDTO);
		}
		logger.info("Product Ordered Details : {}", productOrderDTOs);
		return productOrderDTOs;
		
	}

	public Integer addOrder(OrderDTO order) throws Exception {
		Order order1 = new Order();
		order1.setAddress(order.getAddress());
		order1.setAmount(order.getAmount());
		order1.setBuyerid(order.getBuyerid());
		order1.setStatus("ORDER_PLACED");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		order1.setOrderdate(date);
		Order ord = orderrepo.save(order1);
		return ord.getOrderid();
	}

}