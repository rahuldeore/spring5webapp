/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepositories;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Rahul on 2019-07-07
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepositories authorRepositories;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepositories = authorRepositories;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric","Evans");
        Publisher harper = new Publisher("Harper Collins","New York", "New York", "NY", "10001");
        Book ddd = new Book("Domain Driven Development",harper,"1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepositories.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod","Jonhson");
        Publisher worx= new Publisher("Worx", "New York", "New York", "NY", "10001");
        Book noejb = new Book("J2EE Developement without EJB", worx,"23445");
        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        authorRepositories.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noejb);

    }
}
