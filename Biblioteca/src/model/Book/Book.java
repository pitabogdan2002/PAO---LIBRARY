package model.Book;

import model.autor.Author;

public  class Book implements Comparable<Book>{
    protected int pageNumber;

    protected String title;
    protected static int nextId = 1;
    protected int bookId;

    protected Author author;


    protected float assurance;

    protected int exemplare;

    protected double rating;


    public Book() {
        this.bookId = nextId;
        nextId++;
    }

    public Book(int pageNumber, String title, Author author, float assurance, int exemplare, double rating) {
        this.pageNumber = pageNumber;
        this.title = title;
        this.author = author;
        this.assurance = assurance;
        this.exemplare = exemplare;
        this.rating = rating;
        this.bookId = nextId;
        nextId++;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Book.nextId = nextId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public float getAssurance() {
        return assurance;
    }

    public void setAssurance(float assurance) {
        this.assurance = assurance;
    }

    public int getExemplare() {
        return exemplare;
    }

    public void setExemplare(int exemplare) {
        this.exemplare = exemplare;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public  String toString() {
        return "Book{" +
                "pageNumber=" + pageNumber +
                ", title='" + title + '\'' +
                ", bookId=" + bookId +
                ", author=" + author +
                ", assurance=" + assurance +
                ", exemplare=" + exemplare +
                ", rating=" + rating +
                '}';
    }

    public int compareTo(Book o) {
        if(this.rating > o.rating)
            return 1;
        else
            return 0;

    }
}
