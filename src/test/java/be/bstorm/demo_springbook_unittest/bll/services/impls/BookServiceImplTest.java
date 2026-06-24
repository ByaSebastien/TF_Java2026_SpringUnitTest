package be.bstorm.demo_springbook_unittest.bll.services.impls;

import be.bstorm.demo_springbook_unittest.bll.exceptions.TitleBookException;
import be.bstorm.demo_springbook_unittest.bll.services.BookService;
import be.bstorm.demo_springbook_unittest.dal.repositories.BookRepository;
import be.bstorm.demo_springbook_unittest.dl.entities.Book;
import be.bstorm.demo_springbook_unittest.mocks.BookRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceImplTest {

    private final BookService bookService = new BookServiceImpl(new BookRepositoryMock());

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceMocked;

    @Test
    void shouldAddBookWithSuccess(){

        // Arrange
        Book bookToAdd = new Book("Toto à la playa","Qu'elle est belle ta plage");

        // Act
        Book insertedBook = bookService.add(bookToAdd);

        // Assert
        assertNotNull(insertedBook);
        assertNotNull(insertedBook.getId());
        assertTrue(insertedBook.getId() > 0);
        assertEquals(insertedBook.getTitle(), bookToAdd.getTitle());
        assertEquals(insertedBook.getDescription(), bookToAdd.getDescription());
    }

    @Test
    void shouldAddBookWithFailure(){

        Book bookToAdd = new Book("Toto au bowling","Qu'elle est belle ta boule");
        Book secondBook = new Book("Toto au bowling","Qu'elle est belle ta boule");

        Book insertedBook = bookService.add(bookToAdd);

        TitleBookException  titleBookException = assertThrows(TitleBookException.class,()-> bookService.add(secondBook));

        assertEquals(titleBookException.getMessage(),"Title already taken");
    }

    @Test
    void shouldGetOneBookWithSuccess(){

        Book book = new Book(42L,"Toto au billard","Quelle est belle ta queue");
        when(bookRepository.findById(42L)).thenReturn(Optional.of(book));

        Book actualBook = bookServiceMocked.findById(42L);

        assertNotNull(actualBook);
        assertEquals(book,actualBook);
    }

    @Test
    void shouldGetOneBookWithFailure(){
        when(bookRepository.findById(42L)).thenReturn(Optional.empty());

//        assertThrows(NoSuchElementException.class,()-> bookServiceMocked.findById(42L));
        assertThrows(NoSuchElementException.class,()-> bookServiceMocked.findById(43L));
    }

}
