package vn.order.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ORDER_EVENTS")
public class OrderEventsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Column(name = "SHOP_ID")
    private Integer shopId;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "QUEUE_ID")
    private OrderQueueEntity orderQueue;
    @Column(name = "DATA")
    private String data;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
