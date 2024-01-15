package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.purexua.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_order")
public class Order extends BaseEntity {
  @TableField("user_id")
  private Long userId;
  @TableField("book_id")
  private Long bookId;
  @TableField("order_number")
  private String orderNumber;
  @TableField("price")
  private Double price;
  @TableField("status")
  private Integer status;
}
