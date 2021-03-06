package com.mateo9x.shop.controller;

import java.util.List;

import javax.validation.Valid;
import com.mateo9x.shop.dto.OrderDTO;
import com.mateo9x.shop.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.debug("REST request to save Order: {}", orderDTO);
        return orderService.save(orderDTO);
    }

    @PutMapping("/orders")
    public OrderDTO updateOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.debug("REST request to update Order: {}", orderDTO);
        return orderService.save(orderDTO);
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        log.debug("REST request to get all Orders");
        return orderService.findAll();
    }

    @GetMapping("/orders/user/{id}")
    public List<OrderDTO> getAllOrdersForUser() {
        log.debug("REST request to get all Orders for user: {}");
        return orderService.findAllByUserId();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        log.debug("REST request to get Order: {}", id);
        return orderService.findById(id);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
    log.debug("REST request do delete Order: {}", id);
    orderService.deleteOrder(id);
    }

}
