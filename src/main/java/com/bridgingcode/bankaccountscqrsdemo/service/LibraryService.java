package com.bridgingcode.bankaccountscqrsdemo.service;

import com.bridgingcode.bankaccountscqrsdemo.command.command.AddBookCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.command.RegisterLibraryCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.BookDto;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.LibraryDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class LibraryService {

    @Autowired
    private CommandGateway commandGateway;

    public CompletableFuture<String> saveLib(LibraryDto libraryDto){
        RegisterLibraryCommand libraryCommand=new RegisterLibraryCommand(
            libraryDto.getLibId(),
            libraryDto.getName()
        );
      return commandGateway.send(libraryCommand);
    }

   public CompletableFuture<String> saveBook(BookDto bookDto){
       AddBookCommand bookCommand=new AddBookCommand(
          bookDto.getBookId(),
          bookDto.getLibId(),
          bookDto.getName(),
          bookDto.getIsbn());
       return commandGateway.send(bookCommand);
   }

}
