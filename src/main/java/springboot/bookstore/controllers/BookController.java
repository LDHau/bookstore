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

    @GetMapping("/showform")
    public String showform(Model model) {
        model.addAttribute("book", new Books());
        return "addbook";
    }

    @PostMapping("/book")
    public String addBook(@ModelAttribute("book") Books book) {
        bookService.addToBook(book);
        return "redirect:/listbook";
    }

    @GetMapping("editbook")
    public String editFormBook(@RequestParam int id, Model model) {
        model.addAttribute("bookbyid", bookService.getBookById(id));
        return "editbook";
    }

    @PostMapping("/editbook")
    public String saveEditBook(@ModelAttribute("bookbyid") Books book, @RequestParam int id) {
        bookService.updateBook(id, book);
        return "redirect:/listbook";
    }

    @GetMapping("/deletebook")
    public String deleteBook(@RequestParam int id) {
        bookService.deleteBook(id);
        return "redirect:/listbook";
    }

}
