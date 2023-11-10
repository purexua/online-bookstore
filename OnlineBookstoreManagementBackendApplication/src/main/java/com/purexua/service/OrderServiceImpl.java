package com.purexua.service;

import com.github.pagehelper.PageInfo;
import com.purexua.dao.OrderDao;
import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderDao orderDao;

  @Override
  public List<Order> selectOrdersByUserId(Integer userId) {
    System.out.println("userId = " + userId + " 查询订单信息");
    return orderDao.selectOrdersByUserId(userId);
  }

  @Override
  public List<Order> OrderAfterPageHelper(Integer userId, int pageNum, int pageSize) {
    PageInfo<Order> orderPageInfo = orderDao.getPageHelpByUserId(userId, pageNum, pageSize);
    System.out.println(orderPageInfo.getTotal());
    return orderPageInfo.getList();
  }

  @Override
  public MyPageInfo pageInfoOrderByUserId(Integer userId, int pageNum, int pageSize) {
    PageInfo<Order> orderPageInfo = orderDao.getPageHelpByUserId(userId, pageNum, pageSize);
    MyPageInfo myPageInfo = new MyPageInfo();
    myPageInfo.setTotalPages(orderPageInfo.getPages());
    myPageInfo.setTotalItems((int) orderPageInfo.getTotal());
    myPageInfo.setPageNum(orderPageInfo.getPageNum());
    myPageInfo.setPageSize(orderPageInfo.getPageSize());
    return myPageInfo;
  }

  @Override
  public Order selectOrderByUserIdAndOrderId(Integer userId, Integer orderId) {
    System.out.println("userId = " + userId + " 查询 " + orderId + " 号订单信息");
    return orderDao.selectOrderByUserIdAndOrderId(userId, orderId);
  }

  @Override
  public List<OrderItem> selectOrderItemsByOrderId(Integer orderId) {
    System.out.println("查询 " + orderId + " 号订单的订单项信息");
    return orderDao.selectOrderItemsByOrderId(orderId);
  }
}
