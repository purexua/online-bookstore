package com.purexua.controller;

import com.purexua.entity.Book;
import com.purexua.service.BookService;
import com.purexua.tool.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

  @ResponseBody
  @PostMapping("/book/add")
  String addBook(Book book) {
    System.out.println("添加图书"+book);
    return bookService.addBook(book);
  }

  @ResponseBody
  @PutMapping("/book/update")
  String updateBook(Book book) {
    System.out.println("更新图书"+book);
    return bookService.updateBook(book);
  }

  @ResponseBody
  @DeleteMapping("/book/delete/{bookId}")
  String deleteBookById(@PathVariable("bookId") Integer bookId) {
    System.out.println("删除图书"+bookId);
    return bookService.deleteBookById(bookId);
  }

  @ResponseBody
  @GetMapping("/book/exist")
  List<Book> exitsBook(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(name = "title" ,required = false) String title, @RequestParam(name = "author" ,required = false) String author, @RequestParam(name = "isbn" ,required = false) String isbn, @RequestParam("type") String type) {
    return bookService.bookAfterPageHelpExist(pageNum, pageSize, title, author, isbn, type);
  }

  @ResponseBody
  @GetMapping("/book/exist/info")
  MyPageInfo exitsBookPages(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(name = "title" ,required = false) String title, @RequestParam(name = "author" ,required = false) String author, @RequestParam(name = "isbn" ,required = false) String isbn, @RequestParam("type") String type) {
    return bookService.pageInfoExist(pageNum, pageSize, title, author, isbn, type);
  }
}
