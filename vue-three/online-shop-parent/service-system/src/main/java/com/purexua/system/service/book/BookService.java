package com.purexua.system.service.book;

import com.baomidou.mybatisplus.extension.service.IService;
import com.purexua.model.system.Book;

import java.util.List;

public interface BookService extends IService<Book> {

  List<Book> getBookByType(String category, Integer pageNum);

  Object getPageInfoByType(String category, Integer pageNum);
}
