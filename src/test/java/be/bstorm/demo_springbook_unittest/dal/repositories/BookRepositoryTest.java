package be.bstorm.demo_springbook_unittest.dal.repositories;

import be.bstorm.demo_springbook_unittest.dl.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void BookRepository_findById_shouldReturnOneBook() {

        Book bookToAdd = new Book("Toto à la pêche","Qu'elle est belle ta canne");

        bookRepository.save(bookToAdd);

        Book actualBook = bookRepository.findById(bookToAdd.getId()).orElse(null);
        assertEquals(bookToAdd, actualBook);
        assertNotNull(actualBook);
    }
}
