package com.bridgingcode.bankaccountscqrsdemo.service;

import com.bridgingcode.bankaccountscqrsdemo.entity.BookModel;
import com.bridgingcode.bankaccountscqrsdemo.entity.LibraryModel;
import com.bridgingcode.bankaccountscqrsdemo.events.BookAddedEvent;
import com.bridgingcode.bankaccountscqrsdemo.events.LibraryCreatedEvent;
import com.bridgingcode.bankaccountscqrsdemo.query.GetLibraryQuery;
import com.bridgingcode.bankaccountscqrsdemo.repository.BookRepo;
import com.bridgingcode.bankaccountscqrsdemo.repository.LibraryRepo;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LibraryService2 {

    @Autowired
    private LibraryRepo libraryRepo;

    @Autowired
    private BookRepo bookRepo;

    @EventHandler
    public void on(LibraryCreatedEvent event){
        log.info("Creating library in the repo...");
        LibraryModel model=new LibraryModel();
        model.setLibId(event.getLibId());
        model.setName(event.getName());
        model.setBookList(new ArrayList<>());
        libraryRepo.save(model);
    }

    @EventHandler
    public void on(BookAddedEvent event){
        BookModel model=new BookModel();
        model.setBookId(event.getBookId());
        model.setLibId(event.getLibId());
        model.setIsbn(event.getIsbn());
        model.setName(event.getName());
        LibraryModel libraryModel=libraryRepo.findById(event.getLibId()).orElse(null);
        if(libraryModel !=null){
            libraryModel.getBookList().add(model.getIsbn());
            libraryRepo.save(libraryModel);
        }
        bookRepo.save(model);
    }

    @QueryHandler
    public List<LibraryModel> on(GetLibraryQuery query){
        return libraryRepo.findAll();
    }


}
