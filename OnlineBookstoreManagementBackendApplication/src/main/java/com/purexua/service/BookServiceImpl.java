package com.purexua.service;

import com.github.pagehelper.PageInfo;
import com.purexua.dao.BookDao;
import com.purexua.entity.Book;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Override
  public List<Book> selectBooksByType(String type) {
    return bookDao.selectBooksByType(type);
  }

  @Override
  public List<Book> getAllBooks() {
    return bookDao.getAllBooks();
  }

  @Override
  public List<Book> bookAfterPageHelp(int pageNum, int pageSize) {
    PageInfo<Book> bookPageInfo = bookDao.getBookPageHelp(pageNum, pageSize);
    System.out.println(bookPageInfo.getTotal());
    return bookPageInfo.getList();
  }

  @Override
  public List<Book> bookAfterPageHelpType(String type, int pageNum, int pageSize) {
    PageInfo<Book> bookPageInfo = bookDao.getBookPageHelpType(type, pageNum, pageSize);
    System.out.println(bookPageInfo.getTotal());
    return bookPageInfo.getList();
  }

  @Override
  public MyPageInfo pageInfo(int pageNum, int pageSize) {
    PageInfo<Book> bookPageInfo = bookDao.getBookPageHelp(pageNum, pageSize);

    MyPageInfo myPageInfo = new MyPageInfo();
    myPageInfo.setTotalPages(bookPageInfo.getPages());
    myPageInfo.setTotalItems((int) bookPageInfo.getTotal());
    myPageInfo.setPageNum(bookPageInfo.getPageNum());
    myPageInfo.setPageSize(bookPageInfo.getPageSize());
    return myPageInfo;
  }

  @Override
  public MyPageInfo pageInfoType(String type, int pageNum, int pageSize) {
    PageInfo<Book> bookPageInfo = bookDao.getBookPageHelpType(type, pageNum, pageSize);

    MyPageInfo myPageInfo = new MyPageInfo();
    myPageInfo.setTotalPages(bookPageInfo.getPages());
    myPageInfo.setTotalItems((int) bookPageInfo.getTotal());
    myPageInfo.setPageNum(bookPageInfo.getPageNum());
    myPageInfo.setPageSize(bookPageInfo.getPageSize());
    System.out.println(myPageInfo);
    System.out.println(type);
    return myPageInfo;
  }

  @Override
  public String exitsBook(Integer bookId) {
    Book book = bookDao.selectBookById(bookId);
    if (book == null) {
      return "no";
    } else {
      return "yes";
    }
  }

  @Override
  public String addBook(Book book) {
    if (exitsBook(book.getBookId()).equals("yes")) {
      return "添加失败 - 已经存在该书籍";
    } else {
      bookDao.addBook(book);
      return "success";
    }
  }

  @Override
  public String updateBook(Book book) {
    if (exitsBook(book.getBookId()).equals("yes")) {
      bookDao.updateBook(book);
      return "success";
    } else {
      return "更新失败 - 不存在该书籍";
    }
  }

  @Override
  public String deleteBookById(Integer bookId) {
    if (exitsBook(bookId).equals("yes")) {
      bookDao.deleteBookById(bookId);
      return "success";
    } else {
      return "删除失败 - 不存在该书籍";
    }
  }
}
