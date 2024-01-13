package com.purexua.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.purexua.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_book")
public class Book extends BaseEntity {

  @Serial
  private static final long serialVersionUID = 1L;

  @TableField("book_name")
  private String bookName;

  @TableField("image")
  private String image;

  @TableField("author")
  private String author;

  @TableField("publisher")
  private String publisher;

  @TableField("isbn")
  private String isbn;

  @TableField("price")
  private Double price;

  @TableField("category")
  private String category;

  @TableField("stock")
  private Integer stock;

  @TableField("description")
  private String description;

  @TableField("status")
  private Integer status;
}
