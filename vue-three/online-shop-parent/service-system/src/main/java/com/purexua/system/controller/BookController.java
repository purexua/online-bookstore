package com.purexua.system.controller;

import com.purexua.model.system.Book;
import com.purexua.result.R;
import com.purexua.system.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/book/{category}/{pageNum}")
  public R<List<Book>> getBookByType(@PathVariable String category , @PathVariable Integer pageNum) {
    return R.ok(bookService.getBookByType(category, pageNum));
  }

  @GetMapping("/book/page/{category}/{pageNum}")
  public R getBookPageInfoByType(@PathVariable String category , @PathVariable Integer pageNum) {
    return R.ok(bookService.getPageInfoByType(category, pageNum));
  }

}
