package be.bstorm.demo_springbook_unittest.bll.services.impls;

import be.bstorm.demo_springbook_unittest.bll.exceptions.TitleBookException;
import be.bstorm.demo_springbook_unittest.bll.services.BookService;
import be.bstorm.demo_springbook_unittest.dal.repositories.BookRepository;
import be.bstorm.demo_springbook_unittest.dl.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book add(Book b) {
        if(bookRepository.existsByTitle(b.getTitle())){
            throw new TitleBookException();
        }
        return bookRepository.save(b);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findBookByTitle(title).orElseThrow();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean update(Long id, Book book) {

        Book existingBook;
        try{
            existingBook = findById(id);
            existingBook.setTitle(book.getTitle());
            existingBook.setDescription(book.getDescription());
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
