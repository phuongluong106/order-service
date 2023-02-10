package vn.order.application.controller;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.order.application.request.CreateOrderRequest;
import vn.order.application.response.OrderResponse;
import vn.order.application.response.OnlineResponse;
import vn.order.domain.model.Order;
import vn.order.domain.service.OrderService;


@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(value = "/createOrder")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "System Error")
    })
    @Transactional
    public ResponseEntity<OnlineResponse<String>> createOrder(@RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        Boolean isInQueue = orderService.createOrder(Order.builder()
                .shopId(createOrderRequest.getShopId())
                .menuIds(createOrderRequest.getMenuIds())
                .customerId(createOrderRequest.getCustomerId()).build());
        if(isInQueue == true) {
            return ResponseEntity.ok(new OnlineResponse<>("", HttpStatus.OK.value(), "OrderInQueue", null));
        }
        else{
            return ResponseEntity.ok(new OnlineResponse<>("", HttpStatus.OK.value(), "OrderWaitingInsertToQueue", null));
        }

    }

}
