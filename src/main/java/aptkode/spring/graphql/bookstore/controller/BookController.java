package aptkode.spring.graphql.bookstore.controller;

import aptkode.spring.graphql.bookstore.model.Book;
import aptkode.spring.graphql.bookstore.model.BookWrapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping()
    public Book getBook(@Argument String isbn) {
        final Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle("first book");
        return book;
    }

    @MutationMapping
    public Book createBook(@Argument("book") BookWrapper wrapper){
        final Book book = new Book();
        book.setTitle(wrapper.getTitle());
        book.setIsbn(wrapper.getIsbn());
        return book;
    }
}
