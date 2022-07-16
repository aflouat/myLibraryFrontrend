/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.front.controller;

import co.myLibrary.front.model.Book;
import co.myLibrary.front.service.BookService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author itpm
 */
@Controller
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    /* @GetMapping("/listing-books")
    public Iterable<Book> Books(){
        
        return new Book();
        
    }*/
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Book> listBook = bookService.getBooks();
        for (Book book : listBook) {
            log.info("Books : " + book.getTitle());
        }
        model.addAttribute("books", listBook);

        return "home";
    }

    @GetMapping("/deleteBook/{id}")
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/createBook")
    public ModelAndView createBook(@ModelAttribute  @Valid Book book) {
        bookService.createBook(book);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/createBookForm")
    public String createBookForm(Model model) {
        Book b = new Book();
        model.addAttribute("book", b);

        return "form_new_book";
    }

}
