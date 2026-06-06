package com.sivvu.bookcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookservice.BookService;

@RestController
@RequestMapping("/library")
public class BookController {
	private BookService service;
	public BookController(BookService service) {
		this.service=service;
	}
	
	@GetMapping("/getbooks")
    public List<Book> getbooks(){
		return service.getbooks();
	}
	
	@PostMapping("/addbooks")
	public void addbooks(@RequestBody Book book) {
	 service.addbooks(book);	
	}
}
