package com.example.loymark_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.loymark_test.section1.AudioBook;
import com.example.loymark_test.section1.Book;
import com.example.loymark_test.section1.Ebook;
import com.example.loymark_test.section1.Library;

@SpringBootApplication
public class LoymarkTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoymarkTestApplication.class, args);
		Book book = new Book("The Alchemist", "Paulo Coelho", "978-0062315007");
		System.out.println(book.bookDetails());

		Ebook ebook = new Ebook("The Alchemist", "Paulo Coelho", "978-0062315007", "2MB");
		System.out.println(ebook.bookDetails());

		AudioBook audioBook = new AudioBook("The Alchemist", "Paulo Coelho", "978-0062315007", "3 hours");
		System.out.println(audioBook.bookDetails());

		Library library = new Library();
		library.addBook(book);
		library.addBook(ebook);
		library.addBook(audioBook);

		library.searchBooksByTitle("The Alchemist");
	}

}
