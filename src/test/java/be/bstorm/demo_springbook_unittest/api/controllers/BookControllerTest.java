//package be.bstorm.demo_springbook_unittest.api.controllers;
//
//import be.bstorm.demo_springbook_unittest.api.models.dtos.BookDetailsDto;
//import be.bstorm.demo_springbook_unittest.api.models.dtos.BookShortDto;
//import be.bstorm.demo_springbook_unittest.api.models.forms.BookForm;
//import be.bstorm.demo_springbook_unittest.bll.services.impls.BookServiceImpl;
//import be.bstorm.demo_springbook_unittest.dl.entities.Book;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.hamcrest.CoreMatchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//
//@WebMvcTest(BookController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@ExtendWith(MockitoExtension.class)
//public class BookControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private BookServiceImpl bookService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Book book;
//    private BookDetailsDto bookDetailsDto;
//    private BookShortDto bookShortDto;
//    private BookForm bookForm;
//
//    @BeforeEach
//    void init() {
//        book = new Book(42L, "Toto au port", "Qu'elle est belle ta bitte");
//        bookDetailsDto = new BookDetailsDto(42L, "Toto au port", "Qu'elle est belle ta bitte");
//        bookShortDto = new BookShortDto(42L, "Toto au port");
//        bookForm = new BookForm("Toto au port", "Qu'elle est belle ta bitte");
//    }
//
//    @Test
//    void BookController_getBookById_shouldReturnBookDetailsDto() throws Exception {
//        Long bookId = 42L;
//
//        when(bookService.findById(bookId)).thenReturn(book);
//
//        ResultActions response = this.mockMvc.perform(get("/book/" + bookId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(bookDetailsDto)));
//
//        response.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(bookDetailsDto.title())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(bookDetailsDto.description())));
//    }
//}
