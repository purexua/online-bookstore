package com.purexua.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
  Integer orderId;
  Integer userId;
  Date orderDate;
}
