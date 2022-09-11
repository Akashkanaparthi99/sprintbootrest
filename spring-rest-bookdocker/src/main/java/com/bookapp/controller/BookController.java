package com.bookapp.controller;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BookController {

    @Autowired
    private IBookService iBookService;

    //  http://localhost:8080/books
    @GetMapping("/books")
    public List<Book> showBooks(){

        return iBookService.getAll();
    }
    //  http://localhost:8080/books/auhtor/Robin
    @GetMapping("/books/{author}")
    public List<Book> showByAuthor(@PathVariable("author")String author) throws BookNotFoundException {

        return iBookService.getByAuthor(author);
    }


    //  http://localhost:8080/books/category?mycategory=tech
    @GetMapping("/books/category")
    public List<Book> showByCategory(@RequestParam("mycategory")String category) throws BookNotFoundException {

        return iBookService.getByCategory(category);
    }

    //  http://localhost:8080/books/price/1000
    @GetMapping("/books/price/{cost}")
    public List<Book> showByPrice(@PathVariable("cost")double price) throws BookNotFoundException {

        return iBookService.getByLesserPrice(price);
    }

    //  http://localhost:8080/books/id/1
    @GetMapping("/books/id/{bookId}")
    public Book showById(@PathVariable("bookId")int bookId) throws BookNotFoundException {

        return iBookService.getById(bookId);
    }
}
