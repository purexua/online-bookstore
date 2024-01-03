package com.purexua.dao;

import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;
import com.purexua.mapper.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

  @Autowired
  private ShoppingMapper shoppingMapper;

  @Override
  public ShoppingCart getShoppingCartByUserId(int userId) {
    return shoppingMapper.getShoppingCartByUserId(userId);
  }

  @Override
  public List<ShoppingCartItem> getShoppingCartItemsByCartId(int cartId) {
    return shoppingMapper.getShoppingCartItemsByCartId(cartId);
  }

  @Override
  public void insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    shoppingMapper.insertShoppingCartItem(shoppingCartItem);
  }

  @Override
  public ShoppingCartItem selectShoppingCartItemByCartIdAndBookId(Integer cartId, Integer bookId) {
    return shoppingMapper.selectShoppingCartItemByCartIdAndBookId(cartId, bookId);
  }

  @Override
  public void updateShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    shoppingMapper.updateShoppingCartItem(shoppingCartItem);
  }

  @Override
  public void deleteShoppingCartItemById(Integer itemId) {
    shoppingMapper.deleteShoppingCartItemById(itemId);
  }
}
