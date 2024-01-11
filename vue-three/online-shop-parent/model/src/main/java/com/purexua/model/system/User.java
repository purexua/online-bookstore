package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.*;
import com.purexua.model.base.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_user")
public class User extends BaseEntity {

  @TableField("avatar")
  private String avatar;

  @TableField("user_name")
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
}
