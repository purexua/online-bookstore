package com.purexua.controller;

import com.purexua.entity.ShoppingCart;
import com.purexua.entity.ShoppingCartItem;
import com.purexua.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
  public List<ShoppingCartItem> getShoppingCartItemsByCartId(int cartId) {
    return shoppingCartService.getShoppingCartItemsByCartId(cartId);
  }

  @ResponseBody
  @PostMapping("/shopping/cart/item/add")
  public String insertShoppingCartItem(ShoppingCartItem shoppingCartItem) {
    return shoppingCartService.insertShoppingCartItem(shoppingCartItem);
  }
}
