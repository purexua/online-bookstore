package com.purexua.service;

import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;
import com.purexua.tool.MyPageInfo;

import java.util.List;

public interface OrderService {
  List<Order> selectOrdersByUserId(Integer userId);

  List<Order> OrderAfterPageHelper(Integer userId, int pageNum, int pageSize);

  MyPageInfo pageInfoOrderByUserId(Integer userId, int pageNum, int pageSize);

  Order selectOrderByUserIdAndOrderId(Integer userId, Integer orderId);

  List<OrderItem> selectOrderItemsByOrderId(Integer orderId);
}
