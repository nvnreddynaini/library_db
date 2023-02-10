package com.example.librarydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book) throws Exception{

        if(bookRepository.findById(book.getId()).get() != null){
            throw new Exception("Book is already present");
        }
        bookRepository.save(book);
    }

    public Book getBookById(Integer id) throws Exception{
        Book book = bookRepository.findById(id).get();
        return book;
    }

    public void updateBookPages(UpdateBookPage updateBookPage){

        //we need to convert our object (Entry dto) int Entity object.
        int id = updateBookPage.getId();
        Book bookToBeUpdated = bookRepository.findById(id).get();
        bookToBeUpdated.setPages(updateBookPage.getPages());
        bookRepository.save(bookToBeUpdated);
    }
}
