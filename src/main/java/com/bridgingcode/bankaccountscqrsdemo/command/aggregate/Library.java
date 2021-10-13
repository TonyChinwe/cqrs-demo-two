package com.bridgingcode.bankaccountscqrsdemo.command.aggregate;

import com.bridgingcode.bankaccountscqrsdemo.command.command.AddBookCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.command.RegisterLibraryCommand;
import com.bridgingcode.bankaccountscqrsdemo.events.BookAddedEvent;
import com.bridgingcode.bankaccountscqrsdemo.events.LibraryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@Slf4j
public class Library {
    @AggregateIdentifier
    private Integer libId;
    private String name;
    private List<String> bookList;


    public Library() {

    }

    @CommandHandler
    public Library(RegisterLibraryCommand cmd){
        log.info("creating library");
        AggregateLifecycle.apply(new LibraryCreatedEvent(cmd.getId(),cmd.getName()));
    }

    @EventSourcingHandler
    public void on(LibraryCreatedEvent event){
        log.info("creating library event "+event.getLibId());
        this.libId=event.getLibId();
        this.name=event.getName();
        this.bookList=new ArrayList<>();
    }

    @CommandHandler
    public void on(AddBookCommand cmd){
        log.info("creating book");
        AggregateLifecycle.apply(new BookAddedEvent(cmd.getId(),cmd.getLibId(),cmd.getName(),cmd.getIsbn()));
    }

    @EventSourcingHandler
    public void on(BookAddedEvent event){
        boolean fg=event.getLibId().equals(libId);
        log.info("creating book event "+fg);
        if(event.getLibId().equals(libId)) {
            bookList.add(event.getIsbn());
        }
    }


}
