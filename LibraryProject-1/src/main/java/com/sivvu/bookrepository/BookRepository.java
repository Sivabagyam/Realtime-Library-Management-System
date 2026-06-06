package com.sivvu.bookrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivvu.bookmodel.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	Book findByBookTitleAndBookAuthor(String bookTitle, String bookAuthor);

}
