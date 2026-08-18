package com.sivvu.bookservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Book getbook( int id) {
    	  return repo.findByBookId(id);
    }
    public Page<Book> getPagebooks(int page , int size){
    	Pageable pageable =PageRequest.of(page, size);
    	return repo.findAll(pageable);
    }
    public void deletebook(int id) {
    	repo.deleteById(id);
    }
	public void updatebook(int id,Book book) {
		Book searchbook=repo.findByBookId(id);
		searchbook.setBookAuthor(book.getBookAuthor());
		searchbook.setBookCapacity(book.getBookCapacity());
		searchbook.setBookCategory(book.getBookCategory());
		searchbook.setBookDescription(book.getBookDescription());
		searchbook.setBookImage(book.getBookImage());
		searchbook.setBookPrice(book.getBookPrice());
		searchbook.setBookTitle(book.getBookTitle());
		repo.save(searchbook);
	}
}
