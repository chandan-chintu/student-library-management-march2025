package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.requestdto.BookRequestDto;
import com.demo.example.student_library_management_system.service.AuthorService;
import com.demo.example.student_library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/apis")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto requestDto){
        String response = bookService.saveBook(requestDto);
        return response;
    }
}
