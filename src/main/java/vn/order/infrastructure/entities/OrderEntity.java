package vn.order.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS"  )
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "SHOP_ID")
    private Integer shopId;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "QUEUE_ID")
    private OrderQueueEntity orderQueue;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "MENU_IDS")
    private String menuIDS;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;


}
