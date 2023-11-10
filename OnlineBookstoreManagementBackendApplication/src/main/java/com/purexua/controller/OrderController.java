package com.purexua.controller;

import com.purexua.entity.Order;
import com.purexua.entity.OrderItem;
import com.purexua.service.OrderService;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
