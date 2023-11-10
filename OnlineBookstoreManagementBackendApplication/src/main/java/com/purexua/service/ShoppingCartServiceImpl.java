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
  public String updateShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    ShoppingCartItem shoppingCartItem1 = shoppingCartDao.selectShoppingCartItemByCartIdAndBookId(shoppingCartItem.getCartId(), shoppingCartItem.getBookId());
    if (shoppingCartItem1 == null) {
      shoppingCartDao.insertShoppingCartItem(shoppingCartItem);
      System.out.println("insert " + shoppingCartItem);
      return "insert";
    } else {
      shoppingCartItem1.setQuantity(shoppingCartItem1.getQuantity() + shoppingCartItem.getQuantity());
      shoppingCartDao.updateShoppingCartItem(shoppingCartItem1);
      System.out.println("update " + shoppingCartItem1);
      return "update";
    }
  }

  @Override
  public String deleteShoppingCartItemById(Integer itemId) {
    shoppingCartDao.deleteShoppingCartItemById(itemId);
    return "delete";
  }
}
