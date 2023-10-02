package com.purexua.service;

import com.purexua.entity.Book;

import java.util.List;

public interface BookService {
  List<Book> queryAll();

  Book queryById(Integer id);
}
