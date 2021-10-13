package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Integer bookId;
    private Integer libId;
    private String name;
    private String isbn;
}
