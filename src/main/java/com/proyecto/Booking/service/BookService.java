package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Book;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public boolean deleteBook(Book book){

        try{
            bookRepository.delete(book);
            System.out.println("Libro borrado");
        }
        catch(Exception e){
            return false;
        }

        return true;
    }

    public void guardarBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> retornarTodosLosBooks(){
        return  bookRepository.findAll();
    }

}
