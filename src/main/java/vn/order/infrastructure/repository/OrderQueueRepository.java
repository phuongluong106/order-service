package vn.order.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import vn.order.infrastructure.entities.OrderQueueEntity;

import javax.persistence.LockModeType;
import java.util.List;

public interface OrderQueueRepository extends JpaRepository<OrderQueueEntity, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<OrderQueueEntity> findOrderQueueEntitiesByShopId(Integer shopId);
}
