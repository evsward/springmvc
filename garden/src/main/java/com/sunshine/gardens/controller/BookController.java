package com.sunshine.gardens.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.gardens.model.Book;
import com.sunshine.gardens.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	private BookService bookService;

	@RequestMapping(params = "method=add")
	public String add(Book book) {
		System.out.println("bookname:书名" + book.getName());
		System.out.println("author:" + book.getAuthor());
		bookService.add(book);
		return "success";
	}

	@RequestMapping(params = "method=update")
	public String update(Book book) {
		bookService.update(book);
		return "success";
	}

	public BookService getBookService() {
		return bookService;
	}

	@Resource
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}