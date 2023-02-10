package vn.order.domain.ports;

import vn.order.domain.model.Order;
import vn.order.domain.model.OrderQueue;

public interface OrderPort {
    void createOrder(Order order, OrderQueue orderQueue);
}
