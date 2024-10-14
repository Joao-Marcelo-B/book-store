package com.book.store.bookNet.model.book;

import com.book.store.bookNet.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
