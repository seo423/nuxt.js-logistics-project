package kr.co.seoulit.erp.book.service;

import kr.co.seoulit.erp.book.TO.BookInfo;
import kr.co.seoulit.erp.book.dao.BookInfoDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    BookInfoDAO bookInfoDAO;

    @Override
    public List<BookInfo> getAllBookInfos() {
        List<BookInfo> bookInfos = bookInfoDAO.getAllBookInfos();
        return bookInfos;
    }

    @Override
    public void addBookInfo(BookInfo bookInfo) {
        bookInfoDAO.addBookInfo(bookInfo);
    }
}

