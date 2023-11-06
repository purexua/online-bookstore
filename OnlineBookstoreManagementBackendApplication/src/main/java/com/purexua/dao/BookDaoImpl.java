package com.purexua.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
  public List<Book> selectBooksByType(String type) {
    return bookMapper.selectBooksByType(type);
  }

  @Override
  public List<Book> getAllBooks() {
    return bookMapper.getAllBooks();
  }

  @Override
  public PageInfo<Book> getBookPageHelp(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Book> books = bookMapper.getAllBooks();
    return new PageInfo<>(books);
  }

  @Override
  public PageInfo<Book> getBookPageHelpType(String type, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Book> books = bookMapper.selectBooksByType(type);
    return new PageInfo<>(books);
  }
}
