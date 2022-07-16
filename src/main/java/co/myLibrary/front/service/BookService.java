/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.front.service;

import co.myLibrary.front.model.Book;
import co.myLibrary.front.repository.BookProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author itpm
 */
@Service
@Data

public class BookService {

    @Autowired
    private BookProxy bookProxy;

    public Book getBook(Long id) {
        return bookProxy.getBook(id);
    }

    public Iterable<Book> getBooks() {
        return bookProxy.getBooks();
    }

    public Book createBook(Book book) {

        return bookProxy.createBook(book);

    }

    public Book updateBook(Book book) {

        return bookProxy.updateBook(book, book.getId());

    }

    public void deleteBook(Long id) {
        bookProxy.deleteBook(id);
    }

}
