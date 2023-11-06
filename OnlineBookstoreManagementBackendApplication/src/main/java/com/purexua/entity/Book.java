package com.purexua.entity;

import lombok.Data;

@Data
public class Book {
  private Integer bookId;
  private String title;
  private String author;
  private String publisher;
  private String isbn;
  private Double price;
  private Integer stock;
  private String type;
}
