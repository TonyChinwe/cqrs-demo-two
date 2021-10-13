package com.bridgingcode.bankaccountscqrsdemo.command.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RegisterLibraryCommand extends BaseCommand<Integer>{


    private final String name;

    public RegisterLibraryCommand(Integer libId, String name) {
        super(libId);
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
