package be.bstorm.demo_springbook_unittest.api.models.dtos;

import be.bstorm.demo_springbook_unittest.dl.entities.Book;

public record BookShortDto(
        Long id,
        String title
) {

    public static BookShortDto fromBook(Book b) {
        return new BookShortDto(b.getId(), b.getTitle());
    }
}
