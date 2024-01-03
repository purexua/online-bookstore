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

  @Override
  public int addBook(Book book) {
    return bookMapper.addBook(book);
  }

  @Override
  public Book selectBookById(Integer bookId) {
    return bookMapper.selectBookById(bookId);
  }

  @Override
  public Book selectBookByTitle(String title) {
    return bookMapper.selectBookByTitle(title);
  }

  @Override
  public int updateBook(Book book) {
    return bookMapper.updateBook(book);
  }

  @Override
  public int deleteBookById(Integer bookId) {
    return bookMapper.deleteBookById(bookId);
  }

  @Override
  public List<Book> selectBooksByTitleAuthorIsbnType(String title, String author, String isbn, String type) {
    return bookMapper.selectBooksByTitleAuthorIsbnType(title, author, isbn, type);
  }
  @Override
  public PageInfo<Book> getPageHelpExist(int pageNum, int pageSize, String title, String author, String isbn, String type) {
    PageHelper.startPage(pageNum, pageSize);
    List<Book> books = bookMapper.selectBooksByTitleAuthorIsbnType(title, author, isbn, type);
    return new PageInfo<>(books);
  }

  @Override
  public int updateBookAfterUserPay(Integer bookId, Integer quantity) {
    return bookMapper.updateBookAfterUserPay(bookId, quantity);
  }
}
