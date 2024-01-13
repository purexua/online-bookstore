package com.purexua.result;

import lombok.Data;

@Data
public class MyPage {
  public static final Long DEFAULT_PAGE_SIZE = 7l;

  private  Long total;
  private Long current;
  private Long size;
}
