package kr.co.seoulit.erp.book.service;


import kr.co.seoulit.erp.book.TO.BookInfo;

import java.util.List;

public interface BookInfoService {
    List<BookInfo> getAllBookInfos();
    void addBookInfo(BookInfo bookInfo);
}
