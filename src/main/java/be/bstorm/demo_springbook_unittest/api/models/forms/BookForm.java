package be.bstorm.demo_springbook_unittest.api.models.forms;

import be.bstorm.demo_springbook_unittest.dl.entities.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookForm(
        @NotBlank
        @Size(max = 100)
        String title,
        @Size(max = 255)
        String description
) {
        public Book toBook(){
                return new Book(title, description);
        }
}
