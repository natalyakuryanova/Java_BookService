package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    public void testFindBookById() {
        BookRepository mockbrepo = mock(BookRepository.class);

        when(mockbrepo.findById("123")).thenReturn(new Book("123", "Mock Book", "Mock Author"));

        BookService bookService = new BookService(mockbrepo);
        Book result = bookService.findBookById("123");

        assertEquals("Mock Book", result.getTitle());
        assertEquals("Mock Author", result.getAuthor());

        verify(mockbrepo, times(1)).findById("123");

    }

    @Test
    public void testFindAllBooks() {
        BookRepository mockbrepo = mock(BookRepository.class);

        when(mockbrepo.findAll()).thenReturn(List.of(new Book("123", "Mock Book 123", "Mock Author 123"), new Book("321", "Mock Book 321", "Mock Author 321")));

        BookService bookService = new BookService(mockbrepo);
        List<Book> allBooks = bookService.findAllBooks();

        assertEquals("Mock Book 123", (allBooks.get(0)).getTitle());
        assertEquals("Mock Author 321", (allBooks.get(1)).getAuthor());

        verify(mockbrepo, times(1)).findAll();

        assertEquals(2,allBooks.size());
    }
}