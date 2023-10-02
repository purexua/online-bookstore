package com.purexua.dao;

import com.purexua.entity.Book;

import java.util.List;

public interface BookDao {
  public List<Book> queryAll();

  public Book queryById(Integer id);
}
