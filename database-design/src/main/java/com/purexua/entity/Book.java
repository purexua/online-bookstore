package com.purexua.entity;

import lombok.Data;

@Data
public class Book {
  private int bookId;
  private String title;
  private String author;
  private String publisher;
  private String isbn;
  private double price;
  private int stock;
}
