package com.purexua.entity;


import lombok.Data;

@Data
public class OrderItem {
  private Integer orderDetailId;
  private Integer orderId;
  private Integer bookId;
  private Integer quantity;

  private Order order;
  private Book book;
}
