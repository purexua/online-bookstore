package com.purexua.service;

import com.purexua.dao.ShoppingCartDao;
import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
  @Autowired
  private ShoppingCartDao shoppingCartDao;

  @Override
  public ShoppingCart getShoppingCartByUserId(int userId) {
    return shoppingCartDao.getShoppingCartByUserId(userId);
  }

  @Override
  public List<ShoppingCartItem> getShoppingCartItemsByCartId(int cartId) {
    return shoppingCartDao.getShoppingCartItemsByCartId(cartId);
  }

  @Override
  public String insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    shoppingCartDao.insertShoppingCartItem(shoppingCartItem);
    return "success";
  }
}
