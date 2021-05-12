package com.learn.wangxios.repository;

import com.learn.wangxios.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
