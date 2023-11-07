package com.purexua.mapper;

import com.purexua.entity.Book;

import java.util.List;

public interface BookMapper {
  List<Book> selectBooksByType(String type);
  List<Book> getAllBooks();

  int addBook(Book book);

  Book selectBookByTitle(String title);

  int updateBook(Book book);

  Book selectBookById(Integer bookId);

  int deleteBookById(Integer bookId);

  List<Book> selectBooksByTitleAuthorIsbnType(String title, String author, String isbn, String type);
}
