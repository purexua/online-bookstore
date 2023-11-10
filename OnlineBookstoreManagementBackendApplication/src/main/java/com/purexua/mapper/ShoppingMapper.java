package com.purexua.mapper;

import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;

import java.util.List;

public interface ShoppingMapper {
  public ShoppingCart getShoppingCartByUserId(int userId);

  public List<ShoppingCartItem> getShoppingCartItemsByCartId(int cartId);

  public void insertShoppingCartItem(ShoppingCartItem shoppingCartItem);
}
