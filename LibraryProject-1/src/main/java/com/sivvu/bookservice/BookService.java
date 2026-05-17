package com.sivvu.bookservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookrepository.BookRepository;

@Service
public class BookService {
	private BookRepository repo;
	public BookService(BookRepository repo) {
		this.repo=repo;
		
	}
	public List<Book> getbooks(){
		return repo.findAll();
		
	}
    public void  addbooks(Book book) {
    	 repo.save(book);
    	
    }
}
