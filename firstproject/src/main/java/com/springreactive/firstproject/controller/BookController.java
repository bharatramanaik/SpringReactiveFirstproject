package com.springreactive.firstproject.controller;

import com.springreactive.firstproject.entities.Book;
import com.springreactive.firstproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping("/getall")
    public Flux<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/getone/{bid}")
    public Mono<Book> getOneBook(@PathVariable("bid") int bookId) {
        return bookService.get(bookId);
    }

    @PutMapping("/updatebook")
    public Mono<Book> updateBook(@RequestBody Book book) {
        int bid = book.getBookId();
        System.out.println(bid);
        return bookService.update(book, bid);
    }

    @DeleteMapping("/delete/{bid}")
    public Mono<Void> deleteBook(@PathVariable("bid") int bid) {
        return bookService.delete(bid);
    }

}
