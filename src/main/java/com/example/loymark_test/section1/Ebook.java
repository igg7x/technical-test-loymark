package com.example.loymark_test.section1;

public class Ebook extends Book {

    private String fileSize;

    public Ebook(String title, String author, String isbn, String fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    @Override
    public String bookDetails() {
        return "Ebook{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }

}
