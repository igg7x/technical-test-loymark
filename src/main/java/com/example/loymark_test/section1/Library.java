package com.example.loymark_test.section1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchBooksByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println(book.bookDetails());
            }
        }
    }

}
