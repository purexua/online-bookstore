package com.purexua.mapper;

import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
  List<Order> selectOrdersByUserId(Integer userId);

  Order selectOrderByUserIdAndOrderId(Integer userId, Integer orderId);

  List<OrderItem> selectOrderItemsByOrderId(Integer orderId);

  void insertOrder(Order order);

  void insertOrderItem(OrderItem orderItem);
}

