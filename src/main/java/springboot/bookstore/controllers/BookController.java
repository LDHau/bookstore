package springboot.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.bookstore.entitys.Books;
import springboot.bookstore.services.MainService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private MainService bookService;

    @GetMapping("/listbook")
    public String getAllBook(Model model) {
        List<Books> booksList = bookService.getAllBook();
        model.addAttribute("books", booksList);
        return "listbook";
    }

    @GetMapping("/book")
    public Books getBookById(@RequestParam int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Books books) {
        bookService.addToBook(books);
    }

//    @PostMapping("/updatebook")
    @PutMapping("/editbook")
    public void updateBook(@RequestParam int id ,@RequestBody Books books) {
        bookService.updateBook(id, books);
    }

    @DeleteMapping("/deletebook")
    public void deleteBook(@RequestParam int id) {
        bookService.deleteBook(id);
    }

}
