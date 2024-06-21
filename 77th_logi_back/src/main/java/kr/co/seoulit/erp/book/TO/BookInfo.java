package kr.co.seoulit.erp.book.TO;

import lombok.Data;

import java.util.Date;

@Data
public class BookInfo {
    private String title;
    private String author;
    private Date publicationDate;
    private Double price;
    private String description;

}
