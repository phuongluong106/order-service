package vn.order.infrastructure.adapter;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.order.domain.enums.OrderEnum;
import vn.order.domain.model.Order;
import vn.order.domain.model.OrderQueue;
import vn.order.domain.ports.OrderPort;
import vn.order.infrastructure.entities.OrderEntity;
import vn.order.infrastructure.entities.OrderQueueEntity;
import vn.order.infrastructure.repository.OrderQueueRepository;
import vn.order.infrastructure.repository.OrderRepository;

import java.time.LocalDateTime;

@Component
public class OrderAdapter implements OrderPort {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderQueueRepository orderQueueRepository;
    @Override
    public void createOrder(Order order, OrderQueue orderQueue) {
        OrderEntity orderEntity = OrderEntity.builder()
                .customerId(order.getCustomerId())
                .menuIDS(new Gson().toJson(order.getMenuIds()))
                .status(OrderEnum.CREATED.name())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .orderQueue(orderQueueRepository.findById(orderQueue.getId()).get())
                .shopId(order.getShopId()).build();
        this.orderRepository.save(orderEntity);
    }
}
