package com.bridgingcode.bankaccountscqrsdemo.command.controller;

import com.bridgingcode.bankaccountscqrsdemo.command.aggregate.Library;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.BookDto;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.LibraryDto;
import com.bridgingcode.bankaccountscqrsdemo.entity.LibraryModel;
import com.bridgingcode.bankaccountscqrsdemo.query.GetLibraryQuery;
import com.bridgingcode.bankaccountscqrsdemo.service.LibraryService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private QueryGateway queryGateway;



    @PostMapping("/save-lib")
    public ResponseEntity<String> saveLibrary(@RequestBody LibraryDto libraryDto){
     try {
         CompletableFuture<String> response=libraryService.saveLib(libraryDto);
         return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
     }catch (Exception e){
         return new ResponseEntity<>("Error occurred",HttpStatus.INTERNAL_SERVER_ERROR);
     }

    }

    @PostMapping("/save-book")
    public ResponseEntity<String> saveBook(@RequestBody BookDto bookDto){
        try {
            CompletableFuture<String> response=libraryService.saveBook(bookDto);
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/lib")
    public CompletableFuture<List<LibraryModel>> getLibrary(){
        return queryGateway.query(new GetLibraryQuery(),
                ResponseTypes.multipleInstancesOf(LibraryModel.class));


    }
}
