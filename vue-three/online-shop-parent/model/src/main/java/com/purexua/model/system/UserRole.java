package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user_role")
public class UserRole {
  @TableField("user_id")
  private Long userId;
  @TableField("role_id")
  private Long roleId;
}
