package vn.order.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.order.domain.enums.OrderEnum;
import vn.order.domain.model.Order;
import vn.order.domain.model.OrderQueue;
import vn.order.domain.ports.OrderEventsPort;
import vn.order.infrastructure.entities.OrderEventsEntity;
import vn.order.infrastructure.repository.OrderEventsRepository;
import vn.order.infrastructure.repository.OrderQueueRepository;

import java.time.LocalDateTime;

@Component
public class OrderEventsAdapter implements OrderEventsPort {
    @Autowired
    OrderEventsRepository orderEventsRepository;
    @Autowired
    OrderQueueRepository orderQueueRepository;

    @Override
    public boolean createOrderEvent(Order order, OrderQueue orderQueue) {
            this.orderEventsRepository.save(OrderEventsEntity
                    .builder()
                    .orderQueue(orderQueueRepository.findById(orderQueue.getId()).get())
                    .createdDate(LocalDateTime.now())
                    .customerId(order.getCustomerId())
                    .shopId(order.getShopId())
                    .eventName(OrderEnum.CREATED.name())
                    .status(OrderEnum.CREATED.name())
                    .updatedDate(LocalDateTime.now()).build());
            return true;
    }
}
