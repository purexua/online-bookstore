package com.purexua.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;
import com.purexua.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
  @Autowired
  private OrderMapper orderMapper;

  @Override
  public List<Order> selectOrdersByUserId(Integer userId) {
    return orderMapper.selectOrdersByUserId(userId);
  }

  @Override
  public PageInfo<Order> getPageHelpByUserId(Integer userId, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Order> orders = orderMapper.selectOrdersByUserId(userId);
    return new PageInfo<>(orders);
  }

  @Override
  public Order selectOrderByUserIdAndOrderId(Integer userId, Integer orderId) {
    return orderMapper.selectOrderByUserIdAndOrderId(userId, orderId);
  }

  @Override
  public List<OrderItem> selectOrderItemsByOrderId(Integer orderId) {
    return orderMapper.selectOrderItemsByOrderId(orderId);
  }
}
