package com.bridgingcode.bankaccountscqrsdemo.events;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BookAddedEvent {

    private final Integer bookId;
    private final Integer libId;
    private final String name;
    private final String isbn;


    public BookAddedEvent(Integer bookId,Integer libId, String name, String isbn) {
        this.bookId = bookId;
        this.libId=libId;
        this.name = name;
        this.isbn = isbn;
    }

    public Integer getLibId() {
        return libId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }
}
