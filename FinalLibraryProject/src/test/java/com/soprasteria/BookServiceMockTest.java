package com.soprasteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceMockTest {
	ArrayList<Book> books=null;
	 @Mock
     private BookRepository bookRepo;
     
     @InjectMocks
     private BookService helloService = new BookService();
      
     @BeforeEach
     void setMockOutput() {
         books = new ArrayList<Book>();
         books.add(new Book(1,"Merchant","Ankit",100,"available","Borrowed"));
         books.add(new Book(2,"Merchant of","Ankit j",120,"available","Borrowed"));
         when(helloService.findAll()).thenReturn(books);
     }
    
     @DisplayName("FindAll test")
     @Test
     void testfindAll() {        
         ArrayList<Book> books1 = new ArrayList<Book>();
             books1.add(new Book(1,"Merchant","Ankit",100,"available","Borrowed"));
             books1.add(new Book(2,"Merchant of","Ankit j",120,"available","Borrowed"));
         Iterator<Book> it1 = books1.iterator();
         Iterator<Book> it2 = helloService.findAll().iterator();
         while (it1.hasNext() && it2.hasNext()) {
             assertEquals(it1.next().getId(), it2.next().getId());            
         }
     }



}
