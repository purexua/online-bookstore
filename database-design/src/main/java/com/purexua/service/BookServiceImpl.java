package com.purexua.service;

import com.purexua.dao.BookDao;
import com.purexua.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
  @Autowired
  private BookDao bookDao;


  @Override
  public List<Book> queryAll() {
    return bookDao.queryAll();
  }

  @Override
  public Book queryById(Integer id) {
    return bookDao.queryById(id);
  }
}
