package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.*;
import com.purexua.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
public class User extends BaseEntity {

  @Serial
  private static final long serialVersionUID = 1L;

  @TableField("avatar")
  private String avatar;

  @TableField("username")
  private String userName;

  @TableField("password")
  private String password;

  @TableField("real_name")
  private String realName;

  @TableField("email")
  private String email;

  @TableField("address")
  private String address;

  @TableField("phone")
  private String phone;

  @TableField("description")
  private String description;

  @TableField("status")
  private Integer status;

  @TableField("wallet")
  private Double wallet;

  @TableField(exist = false)
  List<Order> orders;
  @TableField(exist = false)
  Cart cart;
}
