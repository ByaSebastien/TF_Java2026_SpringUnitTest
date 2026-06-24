package be.bstorm.demo_springbook_unittest.bll.services;

import be.bstorm.demo_springbook_unittest.dl.entities.Book;

import java.util.List;

public interface BookService {

    Book add(Book b);
    Book findById(Long id);
    Book findByTitle(String title);
    List<Book> findAll();
    boolean update(Long id,Book book);
    void delete(Long id);
}
