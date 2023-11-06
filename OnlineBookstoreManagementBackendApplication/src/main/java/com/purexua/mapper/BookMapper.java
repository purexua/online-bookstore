package com.purexua.mapper;

import com.purexua.entity.Book;

import java.util.List;

public interface BookMapper {
  List<Book> selectBooksByType(String type);

  List<Book> getAllBooks();
}
