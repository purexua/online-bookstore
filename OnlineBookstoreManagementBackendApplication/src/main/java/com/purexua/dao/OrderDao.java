package com.purexua.dao;

import com.github.pagehelper.PageInfo;
import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;

import java.util.List;

public interface OrderDao {
  List<Order> selectOrdersByUserId(Integer userId);

  PageInfo<Order> getPageHelpByUserId(Integer userId, int pageNum, int pageSize);

  Order selectOrderByUserIdAndOrderId(Integer userId, Integer orderId);

  List<OrderItem> selectOrderItemsByOrderId(Integer orderId);
}
