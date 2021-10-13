package com.bridgingcode.bankaccountscqrsdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookModel {

    @Id
    private Integer bookId;
    private Integer libId;
    private String name;
    private String isbn;

}
