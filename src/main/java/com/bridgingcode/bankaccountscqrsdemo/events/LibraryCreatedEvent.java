package com.bridgingcode.bankaccountscqrsdemo.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class LibraryCreatedEvent {

    private final Integer libId;
    private final String name;

    public LibraryCreatedEvent(Integer libId, String name) {
        this.libId = libId;
        this.name = name;
    }

    public Integer getLibId() {
        return libId;
    }

    public String getName() {
        return name;
    }
}
