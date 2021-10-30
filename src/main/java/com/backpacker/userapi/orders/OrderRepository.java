package com.backpacker.userapi.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findAllByUserId(Integer id);

}
