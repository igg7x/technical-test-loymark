package com.example.loymark_test.section1;

public class AudioBook extends Book {

    private String length;

    public AudioBook(String title, String author, String isbn, String length) {
        super(title, author, isbn);
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    @Override
    public String bookDetails() {
        return "AudioBook{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
