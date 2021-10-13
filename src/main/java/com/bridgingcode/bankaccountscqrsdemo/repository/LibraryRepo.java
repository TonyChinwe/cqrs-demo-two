package com.bridgingcode.bankaccountscqrsdemo.repository;

import com.bridgingcode.bankaccountscqrsdemo.entity.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<LibraryModel,Integer> {
}
