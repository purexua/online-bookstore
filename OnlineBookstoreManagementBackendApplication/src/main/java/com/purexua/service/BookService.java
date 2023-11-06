package com.purexua.service;

import com.github.pagehelper.PageInfo;
import com.purexua.entity.Book;
import com.purexua.tool.MyPageInfo;

import java.util.List;

public interface BookService {
  List<Book> selectBooksByType(String type);

  List<Book> getAllBooks();

  public List<Book> bookAfterPageHelp(int pageNum, int pageSize);

  List<Book> bookAfterPageHelpType(String type, int pageNum, int pageSize);

  MyPageInfo pageInfo(int pageNum, int pageSize);

  MyPageInfo pageInfoType(String type, int pageNum, int pageSize);
}
