package com.sunshine.gardens.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunshine.gardens.model.Book;
import com.sunshine.gardens.service.BookService;

@Controller
public class BookController {
	private final static Log logger = LogFactory.getLog(BookController.class);
	
	private BookService bookService;

	@RequestMapping("hello")
	public String printWelcome(ModelMap model) {
		logger.info("Hello world!");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "show/hello";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Book book) {
		logger.info("adding process...");
		ModelAndView modelAndView = new ModelAndView("show/bookinfo");
		modelAndView.addObject("name", book.getName());
		modelAndView.addObject("author", book.getAuthor());
		return modelAndView;
	}

	@RequestMapping("index/{msgid}")
	public ModelAndView add(@PathVariable String msgid) {
		logger.info("Testing param of uri //...");
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("msgid", msgid);
		return modelAndView;
	}

	@RequestMapping("super")
	@ResponseBody
	public Map<String, Object> validataUser(HttpServletRequest request) {
		logger.info(" validata user : {}" + request.getRemoteAddr());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", true);
		return map;
	}

	public BookService getBookService() {
		return bookService;
	}

	@Resource
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}