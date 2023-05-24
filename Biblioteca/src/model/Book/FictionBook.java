package model.Book;

import model.autor.Author;

public class FictionBook extends Book{
    private String genre;
    private boolean isBestseller;

    public FictionBook() {
    }

    public FictionBook(int pageNumber, String title, Author author, String genre, float assurance, int exemplare, double rating, Boolean isBestseller) {
        super(pageNumber, title, author, assurance, exemplare, rating);
        this.genre = genre;
        this.isBestseller = isBestseller;
    }

    public String getGenre() {
        return genre;
    }

public boolean getIsBestseller() {
        return isBestseller;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsBestseller(boolean isBestseller) {
        this.isBestseller = isBestseller;
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                "genre='" + genre + '\'' +
                ", isBestseller=" + isBestseller +
                ", pageNumber=" + pageNumber +
                ", title='" + title + '\'' +
                ", bookId=" + bookId +
                ", author=" + author +
                ", assurance=" + assurance +
                ", exemplare=" + exemplare +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }

}
