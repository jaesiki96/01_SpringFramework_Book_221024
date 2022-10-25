package com.icia.book.controller;

import com.icia.book.dto.BookDTO;
import com.icia.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/save")
    public String saveForm() {
        return "bookSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BookDTO bookDTO) {
        boolean saveResult = bookService.save(bookDTO);
        if (saveResult) {
            return "index";
        } else {
            return "saveFail";
        }
    }
    // 2번 책의 이름 가격 출판사 등 정보를 가져와야 하기 때문에 DTO 를 가져옴
    @GetMapping("/findBook")
    public String findBook(Model model) {
        BookDTO findResult = bookService.findBook();
        model.addAttribute("book", findResult);
        return "findBook";
    }
    // 책의 전체 정보를 가져와야 하기 때문에 List 를 가져옴
    @GetMapping("/books")
    public String findAll(Model model) {
        List<BookDTO> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }
    @GetMapping("/book")
    public String findById(@RequestParam("bookId") long bookId, Model model) {
        BookDTO bookDTO = bookService.findById(bookId);
        model.addAttribute("book", bookDTO);
        return "findBook";
    }
}
