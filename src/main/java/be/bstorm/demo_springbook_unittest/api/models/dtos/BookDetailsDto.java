package be.bstorm.demo_springbook_unittest.api.models.dtos;

import be.bstorm.demo_springbook_unittest.dl.entities.Book;

public record BookDetailsDto(
        Long id,
        String title,
        String description
) {
    public static BookDetailsDto fromBook(Book b) {
        return new BookDetailsDto(b.getId(), b.getTitle(), b.getDescription());
    }
}
