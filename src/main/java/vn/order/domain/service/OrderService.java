package vn.order.domain.service;

import vn.order.domain.model.Order;

public interface OrderService {
    boolean createOrder(Order order);
}
