package be.bstorm.demo_springbook_unittest.mocks;

import be.bstorm.demo_springbook_unittest.dal.repositories.BookRepository;
import be.bstorm.demo_springbook_unittest.dl.entities.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class BookRepositoryMock implements BookRepository {

    private static Long bookId = 1L;
    private List<Book> books;

    public BookRepositoryMock() {
        this.books = new ArrayList<>();
        books.add(new Book(bookId++,"Les pierafeux","...."));
        books.add(new Book(bookId++,"L'art de la guerre","..."));
        books.add(new Book(bookId++,"La ligne verte","..."));
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return books.stream().filter(b -> Objects.equals(b.getTitle(), title)).findFirst();
    }

    @Override
    public boolean existsByTitle(String title) {
        return books.stream().anyMatch(b -> Objects.equals(b.getTitle(), title));
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Book> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Book> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Book getOne(Long aLong) {
        return null;
    }

    @Override
    public Book getById(Long aLong) {
        return null;
    }

    @Override
    public Book getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Book> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Book> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Book, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Book> S save(S entity) {
        entity.setId(bookId++);
        books.add(entity);
        return entity;
    }

    @Override
    public <S extends Book> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Book> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public List<Book> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Book> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }
}
