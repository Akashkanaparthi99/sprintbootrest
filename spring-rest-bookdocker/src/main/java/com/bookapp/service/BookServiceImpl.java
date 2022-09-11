package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements IBookService{
    @Override
    public Book getById(int bookId) throws BookNotFoundException {
        return booklist().stream().filter(book -> book.getBookId()==bookId).findFirst().orElseThrow(()-> new BookNotFoundException("Book Not Found"));
    }

    @Override
    public List<Book> getAll() {
        return booklist();
    }

    @Override
    public List<Book> getByAuthor(String author) throws BookNotFoundException {
        List<Book> books = booklist().stream().filter(book -> book.getAuthor().equals(author)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books = booklist().stream().filter(book -> book.getCategory().equals(category)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    @Override
    public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
        List<Book> books = booklist().stream().filter(book -> book.getPrice()<=price).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if (books.isEmpty())
            throw new BookNotFoundException("Book Not Found");
        return books;
    }

    public List<Book> booklist() {
        return Arrays.asList(new Book(10,"JAVA", "SriPriya", "Education",2899),
       new Book(20,"SQL", "SriPriya", "Education",389),
      new Book(30,"Security and Safety", "Naresh", "Education",9960),
        new Book(40,"Human Resources", "Ajay", "Socail",1389));
    }
}
