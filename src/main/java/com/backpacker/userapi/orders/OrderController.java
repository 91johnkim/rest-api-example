package com.backpacker.userapi.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/orders", produces = MediaTypes.HAL_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{id}")
    public ResponseEntity getOrders(@PathVariable("id") Integer id){
        List<Order> orderList = orderService.getOrderByUserId(id);
        if(orderList.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(orderList);
    }


}
