package kr.co.seoulit.erp.book.dao;


import kr.co.seoulit.erp.book.TO.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BookInfoDAO {

    public List<BookInfo> getAllBookInfos();

    public void addBookInfo (BookInfo bookInfo);

}
