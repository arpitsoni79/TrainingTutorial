package com.soprasteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	 @Autowired
	    BookRepository repo;
	    public Iterable<Book> findAll(){
	        return repo.findAll();
	    }

}
