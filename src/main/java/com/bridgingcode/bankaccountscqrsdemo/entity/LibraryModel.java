package com.bridgingcode.bankaccountscqrsdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LibraryModel {
    @Id
    private Integer libId;
    private String name;
    @ElementCollection
    private List<String> bookList;
}
