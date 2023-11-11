package com.purexua.controller;

import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;
import com.purexua.service.OrderService;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  @ResponseBody
  @GetMapping("/order")
  public List<Order> selectOrdersByUserId(@RequestParam("userId") Integer userId) {
    return orderService.selectOrdersByUserId(userId);
  }

  @ResponseBody
  @GetMapping("/order/page/id")
  public List<Order> OrderAfterPageHelper(@RequestParam("userId") Integer userId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return orderService.OrderAfterPageHelper(userId, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/order/page/info/id")
  public MyPageInfo pageInfoOrderByUserId(@RequestParam("userId") Integer userId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return orderService.pageInfoOrderByUserId(userId, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/order/id")
  public Order selectOrderByUserIdAndOrderId(@RequestParam("userId") Integer userId, @RequestParam("orderId") Integer orderId) {
    return orderService.selectOrderByUserIdAndOrderId(userId, orderId);
  }

  @ResponseBody
  @GetMapping("/order/item/id")
  public List<OrderItem> selectOrderItemsByOrderId(@RequestParam("orderId") Integer orderId) {
    return orderService.selectOrderItemsByOrderId(orderId);
  }

  @ResponseBody
  @PostMapping("/order")
  public int insertOrder( @RequestParam("userId") Integer userId) {
    Order order = new Order();
    order.setUserId(userId);
    order.setOrderDate(new Timestamp(System.currentTimeMillis())); // 使用Timestamp表示当前时间
    System.out.println("order = " + order);
    orderService.insertOrder(order);


    System.out.println("添加 order = " + order+" order.getOrderId() = " + order.getOrderId());
    return order.getOrderId();
  }

  @ResponseBody
  @PostMapping("/order/item")
  public String insertOrderItem(Integer orderId, Integer bookId, Integer quantity) {
    OrderItem orderItem = new OrderItem();
    orderItem.setOrderId(orderId);
    orderItem.setBookId(bookId);
    orderItem.setQuantity(quantity);
    orderService.insertOrderItem(orderItem);
    System.out.println("添加 orderItem = " + orderItem);
    return "success";
  }
}
