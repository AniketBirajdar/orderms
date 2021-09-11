package com.api.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.order.dto.OrderDTO;
import com.api.order.dto.OrderedProducts;
import com.api.order.dto.ProductsorderedDTO;
import com.api.order.service.OrderService;
//import com.api.product.dto.*;
//import com.api.user.dto.BuyerDTO;
//import com.api.user.dto.CartDTO;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment environment;
	@Autowired
	private OrderService orderservice;
	@Autowired
	RestTemplate template;

	@Value("${cart.uri}")
	String cartUri;

	@Value("${product.uri}")
	String productUri;

	@Value("${buyer.uri}")
	String buyerUri;
//
//	@GetMapping(value = "/api/orders/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public OrderDTO getSpecificOrder(@PathVariable Integer orderid) {
//		logger.info("Get Order request for Specific Order {}", orderid);
//
//		OrderDTO orderDTO = orderservice.getSpecificOrder(orderid);
//		List<ProductsorderedDTO> productsOrderedDTOs = orderservice.getAllProductsOrdered(orderDTO.getBuyerid());
//		logger.info("Get All Product request By Product ID {}", productsOrderedDTOs);
//
//		List<OrderedProducts> orderedProducts = new ArrayList<OrderedProducts>();
//
//		for (ProductsorderedDTO productsOrderedDTO : productsOrderedDTOs) {
//			ProductDTO productDTO = template.getForObject(productUri + productsOrderedDTO.getProdid(),
//					ProductDTO.class);
//			OrderedProducts orderProduct = new OrderedProducts();
//			orderProduct.setPrice(productDTO.getPrice() * productsOrderedDTO.getQuantity());
//			orderProduct.setOrderid(orderDTO.getOrderid());
//			orderProduct.setProdid(productDTO.getProdid());
//			orderProduct.setQuantity(productsOrderedDTO.getQuantity());
//			orderProduct.setSellerid(productsOrderedDTO.getSellerid());
//			orderProduct.setStatus("ORDER_PLACED");
//			orderedProducts.add(orderProduct);
//			orderDTO.setOrderList(orderedProducts);
//		}
//		return orderDTO;
//	}

	@GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getAllOrder() {
		logger.info("Fetching all products");
		return orderservice.getAllOrder();
	}

//	@PostMapping(value = "/api/orders/placedorders", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> addOrder(@RequestBody OrderDTO order) throws Exception {
//
//		Integer amountValue = 0;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		ResponseEntity<CartDTO[]> responseEntity = template.getForEntity(cartUri + order.getBuyerid(), CartDTO[].class);
//		CartDTO[] userArray = responseEntity.getBody();
//		List<Integer> prodIDList = Arrays.stream(userArray).map(CartDTO::getProdid).collect(Collectors.toList());
//		List<Integer> qauntiyList = Arrays.stream(userArray).map(CartDTO::getQuantity).collect(Collectors.toList());
//
//		if (prodIDList.equals(null) && qauntiyList.equals(null)) {
//			String successMessage = environment.getProperty("API.RECORD_NOT_FOUND_IN_CART") + order.getBuyerid();
//			return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
//		}
//		BuyerDTO buyerDTO = template.getForObject(buyerUri + order.getBuyerid(), BuyerDTO.class);
//		Integer buyerReward = buyerDTO.getRewardpoints();
//
//		for (int i = 0; i < prodIDList.size(); i++) {
//			ProductDTO productDTO = template.getForObject(productUri + prodIDList.get(i), ProductDTO.class);
//			amountValue = (int) (amountValue + (productDTO.getPrice() * qauntiyList.get(i)));
//		}
//		amountValue = amountValue - (buyerReward / 4);
//		 Integer updatedRewardPoint= amountValue/100;
//		 buyerDTO.setRewardpoints(updatedRewardPoint);
//		 HttpEntity<BuyerDTO> requestUpdate = new HttpEntity<>(buyerDTO, headers);
//		 template.exchange(buyerUri+order.getBuyerid(), HttpMethod.PUT, requestUpdate, Void.class);
//		 
//		// Reward point Updation
//		order.setAmount(amountValue);
//		Integer oderderid = orderservice.addOrder(order);
//		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + oderderid;
//		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
//	}

	@GetMapping(value = "/api/reorders/{orderid}/{buyerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSpecificOrder(@PathVariable Integer orderid, @PathVariable Integer buyerid)
			throws Exception {
		logger.info("Get Order request for Specific Order {}", orderid);
		OrderDTO orderDTO = orderservice.getSpecificOrder(orderid);
		Integer returnOrderid = orderservice.addOrder(orderDTO);
		String successMessage = environment.getProperty("API.REORDER_SUCCESS") + returnOrderid;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

	}

}
