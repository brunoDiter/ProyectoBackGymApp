package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Book;
import com.proyecto.Booking.persistence.entities.LoginDto;
import com.proyecto.Booking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Book book){

        return ResponseEntity.ok(bookService.deleteBook(book));

    }

    @PostMapping("/add")
    public void crear(@RequestBody Book book){

        bookService.guardarBook(book);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Book>>traertodos(){

        return ResponseEntity.ok(bookService.retornarTodosLosBooks());
    }


}
