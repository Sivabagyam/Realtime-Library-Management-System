package com.sivvu.issuerecordservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookrepository.BookRepository;
import com.sivvu.issuerecordrepository.IssueRecordRepository;

@Service
public class IssueRecordService {
	@Autowired
	private BookRepository repo;
	

	public String issuebook(String bookTitle, String bookAuthor) {
		Book book=repo.findByBookTitleAndBookAuthor(bookTitle,bookAuthor);
		if(book!=null) {
			
			int Capacity=book.getBookCapacity();
			Capacity--;
			book.setBookCapacity(Capacity);
			repo.save(book);
			return "Book is available";
		}
		return "book unavailable";
	}
	public String returnbook(String bookTitle,String bookAuthor) {
		Book book1=repo.findByBookTitleAndBookAuthor(bookTitle,bookAuthor);
		if(book1!=null) {
			int capacity1=book1.getBookCapacity();
			capacity1++;
			book1.setBookCapacity(capacity1);
			repo.save(book1);
			return "Book returned successfully";
		}
		
          return "This is not the book that you got from the library";
	}

}
