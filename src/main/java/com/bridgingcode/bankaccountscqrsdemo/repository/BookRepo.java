package com.bridgingcode.bankaccountscqrsdemo.repository;

import com.bridgingcode.bankaccountscqrsdemo.entity.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookModel,Integer> {
}
