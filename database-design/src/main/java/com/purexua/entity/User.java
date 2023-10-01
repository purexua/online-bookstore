package com.purexua.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Data
public class User {
  private Integer userId;
  @NotBlank(message = "用户名不能为空")
  private String userName;
  @Length(min = 6, max = 16, message = "密码长度必须在6-16位之间")
  private String password;
  @Email(message = "邮箱格式不正确")
  private String email;
  private String address;
  @Digits(integer = 11, fraction = 0, message = "手机号码格式不正确")
  private String phoneNumber;
  private Date createdAt;
  private Date updatedAt;

  private List<Order> orders;
  private ShoppingCart shoppingCart;
}
