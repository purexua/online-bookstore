package com.purexua.controller;

import com.purexua.entity.Book;
import com.purexua.service.BookService;
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

  @GetMapping("/books")
  @ResponseBody
  public List<Book> queryAll() {
    return bookService.queryAll();
  }

  @GetMapping("/book")
  @ResponseBody
  public Book queryById(@RequestParam(value = "id") Integer id) {
    return bookService.queryById(id);
  }

}
