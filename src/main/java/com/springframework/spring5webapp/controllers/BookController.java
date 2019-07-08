package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repositories.AuthorRepositories;
import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rahul on 2019-07-07
 */
@Controller
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepositories authorRepositories;

    public BookController(BookRepository bookRepository, AuthorRepositories authorRepositories) {
        this.bookRepository = bookRepository;
        this.authorRepositories=authorRepositories;
    }

    @RequestMapping(path = "/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
