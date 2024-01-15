package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.purexua.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class Role extends BaseEntity {
  @TableField("role_name")
  private String roleName;
  @TableField("role_code")
  private String roleCode;
  @TableField("description")
  private String description;
  @TableField("status")
  private Integer status;
}
