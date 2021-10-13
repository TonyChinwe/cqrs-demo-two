package com.bridgingcode.bankaccountscqrsdemo.command.aggregate;

import com.bridgingcode.bankaccountscqrsdemo.command.command.AddBookCommand;
import com.bridgingcode.bankaccountscqrsdemo.events.BookAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
public class Book {
    private Integer bookId;
    private String name;
    private String isbn;

    public Book() {
    }

//    @CommandHandler
//    public Book(AddBookCommand cmd){
//        AggregateLifecycle.apply(new BookAddedEvent(cmd.getBookId(),cmd.getName(),cmd.getIsbn()));
//
//    }
//
//    @EventSourcingHandler
//    public void on(BookAddedEvent event){
//        log.info("In the book added event ");
//       this.bookId=event.getBookId();
//       this.name=event.getName();
//       this.isbn=event.getIsbn();
//    }
}
