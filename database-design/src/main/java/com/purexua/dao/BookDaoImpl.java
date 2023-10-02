package com.purexua.dao;

import com.purexua.entity.Book;
import com.purexua.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
  @Autowired
  private BookMapper bookMapper;

  @Override
  public List<Book> queryAll() {
    return bookMapper.queryAll();
  }

  @Override
  public Book queryById(Integer id) {
    return bookMapper.queryById(id);
  }
}
