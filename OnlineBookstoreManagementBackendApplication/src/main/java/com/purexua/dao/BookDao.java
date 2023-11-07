package com.purexua.dao;

import com.github.pagehelper.PageInfo;
import com.purexua.entity.Book;

import java.util.List;

public interface BookDao {
  List<Book> selectBooksByType(String type);

  List<Book> getAllBooks();

  PageInfo<Book> getBookPageHelp(int pageNum, int pageSize);

  PageInfo<Book> getBookPageHelpType(String type, int pageNum, int pageSize);

  int addBook(Book book);

  Book selectBookByTitle(String title);

  Book selectBookById(Integer bookId);

  int updateBook(Book book);

  int deleteBookById(Integer bookId);

}
