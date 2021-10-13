package com.bridgingcode.bankaccountscqrsdemo.command.command;


import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddBookCommand extends BaseCommand<Integer>{



    private final Integer libId;
    private final String name;
    private final String isbn;


    public AddBookCommand(Integer bookId, Integer libId, String name, String isbn) {
        super(bookId);
        this.libId=libId;
        this.name = name;
        this.isbn = isbn;
    }

    public Integer getLibId() {
        return libId;
    }


    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }
}
