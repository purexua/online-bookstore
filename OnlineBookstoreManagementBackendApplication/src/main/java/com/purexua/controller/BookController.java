package com.purexua.controller;

import com.purexua.entity.Book;
import com.purexua.service.BookService;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
  @Autowired
  private BookService bookService;

  @ResponseBody
  @GetMapping("/books")
  List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @ResponseBody
  @GetMapping("/book/search")
  List<Book> selectBooksByType(@RequestParam("type") String type) {
    return bookService.selectBooksByType(type);
  }

  @ResponseBody
  @GetMapping("/book/page")
  List<Book> bookPageHelp(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return bookService.bookAfterPageHelp(pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/book/page/type")
  List<Book> bookPageHelpType(@RequestParam("type") String type, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return bookService.bookAfterPageHelpType(type, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/book/page/info")
  MyPageInfo bookPageHelpTypePages(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return bookService.pageInfo(pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/book/page/type/info")
  MyPageInfo bookPageHelpTypePages(@RequestParam("type") String type, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    return bookService.pageInfoType(type, pageNum, pageSize);
  }
}
