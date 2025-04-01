package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.BookConverter;
import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.repository.AuthorRepository;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(BookRequestDto bookRequestDto){

        Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        //here we have foreign keys authorid and cardid as well

        // using authorid take the whole details of author from authorrepository
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        if(author==null){
            book.setAuthor(null);
        }
        book.setAuthor(author);

        // using cardid take the whole details of card from cardrepository
        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
        if(card==null){
            book.setCard(null);
        }
        book.setCard(card);

        bookRepository.save(book);
        return "Book Saved successfully";
    }
}
