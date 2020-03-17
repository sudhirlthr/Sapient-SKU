/**
 * 
 */
package com.cdk.shopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import com.cdk.shopping.dto.OrderItemDTO;
import com.cdk.shopping.exception.ResourceNotFoundException;
import com.cdk.shopping.model.Order;
import com.cdk.shopping.model.OrderItems;
import com.cdk.shopping.model.OrderStatus;
import com.cdk.shopping.services.ItemService;
import com.cdk.shopping.services.OrderItemService;
import com.cdk.shopping.services.OrderService;

/**
 * @author sudhirk
 *
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	ItemService itemService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemService orderItemService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody OrderForm orderForm) {
		List<OrderItemDTO> orderItems = orderForm.getOrderItems();
		validateItemsExistence(orderItems);
		Order order = new Order();
		order.setStatus(OrderStatus.PAID.name());
		order = orderService.creatOrder(order);

		List<OrderItems> listOfOrderedItems = new ArrayList<>();
		for (OrderItemDTO dto : orderItems) {
			listOfOrderedItems.add(orderItemService
					.createOrderItems(new OrderItems(order, itemService.save(dto.getItems()), dto.getQuantity())));
		}

		order.setOrderItems(listOfOrderedItems);
		orderService.updateOrder(order);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
				.buildAndExpand(order.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}

	private void validateItemsExistence(List<OrderItemDTO> orderItemDTOs) {
		List<OrderItemDTO> list = orderItemDTOs.stream()
				.filter(op -> Objects.isNull(itemService.getItemById(op.getItems().getId())))
				.collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}

	public static class OrderForm {

		private List<OrderItemDTO> orderItemDTOs;

		public List<OrderItemDTO> getOrderItems() {
			return orderItemDTOs;
		}

		public void setItemOrders(List<OrderItemDTO> orderItemDTOs) {
			this.orderItemDTOs = orderItemDTOs;
			;
		}
	}
}
