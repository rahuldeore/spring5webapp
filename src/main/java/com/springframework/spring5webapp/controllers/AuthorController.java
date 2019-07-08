package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repositories.AuthorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rahul on 2019-07-07
 */
@Controller
public class AuthorController {

    private AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping(path="/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepositories.findAll());

        return "authors";
    }
}
