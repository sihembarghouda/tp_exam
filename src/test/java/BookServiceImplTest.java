import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BookServiceImplTest<book> {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    public BookServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        // Given
        List<com.example.bookapi.model.book> books = Arrays.asList(
                new com.example.bookapi.model.book(),
                new com.example.bookapi.model.book()
        );
        when(bookRepository.findAll()).thenReturn(books);

        // When
        List<book> result = (List<book>) bookService.getAllBooks();

        // Then
        assertEquals(2, result.size());
        assertEquals("123", result.get(0));
    }
}