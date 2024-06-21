package kr.co.seoulit.erp.book.controller;

import kr.co.seoulit.erp.book.TO.BookInfo;
import kr.co.seoulit.erp.book.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BookInfoController {

	@Autowired
	private BookInfoService bookInfoService;


	@GetMapping("/bookinfos")
	public String getAllBookInfos(Model model) {
		model.addAttribute("bookInfos", bookInfoService.getAllBookInfos());
		return "bookinfos";
	}

	@PostMapping("/addBookInfo")
	public String addBookInfo(@RequestParam("title") String title,
							  @RequestParam("author") String author,
							  @RequestParam("publicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publicationDate,
							  @RequestParam("price") double price,
							  @RequestParam("description") String description) {
		System.out.println("bookInfo>>>>>>" + publicationDate);
		BookInfo bookInfo = new BookInfo();
		bookInfo.setTitle(title);
		bookInfo.setAuthor(author);
		bookInfo.setDescription(description);
		bookInfo.setPrice(price);
		bookInfo.setPublicationDate(publicationDate);

		bookInfoService.addBookInfo(bookInfo);
		return "redirect:/bookinfos";
	}
}
