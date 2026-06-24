package be.bstorm.demo_springbook_unittest.api.controllers;

import be.bstorm.demo_springbook_unittest.api.models.dtos.BookDetailsDto;
import be.bstorm.demo_springbook_unittest.api.models.dtos.BookShortDto;
import be.bstorm.demo_springbook_unittest.api.models.forms.BookForm;
import be.bstorm.demo_springbook_unittest.bll.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookShortDto>> getAllBooks() {
        List<BookShortDto> books = bookService.findAll().stream()
                .map(BookShortDto::fromBook)
                .toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsDto> getBookById(@PathVariable long id) {
        BookDetailsDto book = BookDetailsDto.fromBook(bookService.findById(id));
        return ResponseEntity.ok(book);
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<BookDetailsDto> getBookById(@PathVariable String title) {
        BookDetailsDto book = BookDetailsDto.fromBook(bookService.findByTitle(title));
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@Valid @RequestBody BookForm form) {
        bookService.add(form.toBook());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable long id, @Valid @RequestBody BookForm form) {
        bookService.update(id, form.toBook());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
