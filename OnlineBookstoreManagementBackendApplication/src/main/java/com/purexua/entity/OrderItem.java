package com.purexua.entity;

import lombok.Data;

@Data
public class OrderItem {
  Integer orderItemId;
  Integer orderId;
  Integer bookId;
}
