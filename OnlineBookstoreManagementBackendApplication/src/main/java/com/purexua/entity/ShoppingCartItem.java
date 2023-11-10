package com.purexua.entity;

import lombok.Data;

@Data
public class ShoppingCartItem {
  private Integer itemId;
  private Integer cartId;
  private Integer bookId;
  private Integer quantity;
}
