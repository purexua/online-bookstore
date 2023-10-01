package com.purexua.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
  private Integer orderId;
  private Integer userId;
  private Date orderDate;
  private Integer statusId;

  private User user;
  private OrderStatus orderStatus;
  private List<OrderItem> orderItems;
}
