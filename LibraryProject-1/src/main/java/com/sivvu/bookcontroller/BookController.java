package com.sivvu.bookcontroller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookservice.BookService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins="http://localhost:5173")
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
	@GetMapping("/getbooks/{id}")
	public Book getbook(@PathVariable int id) {
		return service.getbook(id);
	}
	@GetMapping("/getpagebooks")
	public Page<Book> getPagebooks(@RequestParam int page,@RequestParam int size){
		return service.getPagebooks(page, size);
	}
	@DeleteMapping("/deletebooks/{id}")
	public void deletebook(@PathVariable int id) {
		service.deletebook(id);
	}
	@PutMapping("/updatebook/{id}")
	public void updatebook(@PathVariable int id,@RequestBody Book book) {
	    service.updatebook(id ,book);
	}
	
}
