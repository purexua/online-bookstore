package com.purexua.system.service.book.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.purexua.model.system.Book;
import com.purexua.result.MyPage;
import com.purexua.system.mapper.BookMapper;
import com.purexua.system.service.book.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

  private IPage<Book> getBookPage(String category, Integer pageNum) {
    Page<Book> page = new Page<>(pageNum, MyPage.DEFAULT_PAGE_SIZE);
    LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(Book::getCategory, category);
    return baseMapper.selectPage(page, wrapper);
  }

  @Override
  public List<Book> getBookByType(String category, Integer pageNum) {
    return getBookPage(category, pageNum).getRecords();
  }

  public MyPage getPageInfoByType(String category, Integer pageNum) {
    IPage<Book> bookIPage = getBookPage(category, pageNum);
    MyPage myPage = new MyPage();
    myPage.setTotal(bookIPage.getTotal());
    myPage.setCurrent(bookIPage.getCurrent());
    myPage.setSize(bookIPage.getSize());
    System.out.println(myPage);
    return myPage;
  }
}