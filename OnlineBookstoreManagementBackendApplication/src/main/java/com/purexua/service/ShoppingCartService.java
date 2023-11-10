package com.purexua.service;

import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartService {
  public ShoppingCart getShoppingCartByUserId(int userId);

  public List<ShoppingCartItem> getShoppingCartItemsByCartId(int cartId);

  public String insertShoppingCartItem(ShoppingCartItem shoppingCartItem);
}
