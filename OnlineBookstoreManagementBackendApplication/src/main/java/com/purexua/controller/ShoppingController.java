package com.purexua.controller;

import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;
import com.purexua.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class ShoppingController {
  @Autowired
  private ShoppingCartService shoppingCartService;

  @ResponseBody
  @GetMapping("/shopping/cart")
  public ShoppingCart getShoppingCartByUserId(int userId) {
    return shoppingCartService.getShoppingCartByUserId(userId);
  }

  @ResponseBody
  @GetMapping("/shopping/cart/items")
  public List<ShoppingCartItem> getShoppingCartItemsByCartId(Integer cartId) {
    return shoppingCartService.getShoppingCartItemsByCartId(cartId);
  }

  @ResponseBody
  @PostMapping("/shopping/cart/item/add")
  public String insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    if (Objects.equals(shoppingCartService.updateShoppingCartItem(shoppingCartItem), "insert")) {
      return "insert";
    } else {
      return "update";
    }
  }

  @ResponseBody
  @DeleteMapping("/shopping/cart/item/delete")
  public String deleteShoppingCartItemById(Integer itemId) {
    return shoppingCartService.deleteShoppingCartItemById(itemId);
  }
}
