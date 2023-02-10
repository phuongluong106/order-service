package vn.order.domain.model;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer shopId;
    private List<Integer> menuIds;
    private Integer customerId;
}
