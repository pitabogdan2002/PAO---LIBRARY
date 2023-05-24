package model.Book;

import model.autor.Author;

public class ChildrenBook extends Book {

    private int ageLimit;
    private String illustrator;
    private boolean isPopUpBook;


    public ChildrenBook() {
    }

    public ChildrenBook(int pageNumber, String title, Author author, float assurance, int exemplare, double rating, int ageLimit, String illustrator, boolean isPopUpBook) {
        super(pageNumber, title, author, assurance, exemplare, rating);
        this.ageLimit = ageLimit;
        this.illustrator = illustrator;
        this.isPopUpBook = isPopUpBook;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public boolean getIsPopUpBook() {
        return isPopUpBook;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public void setIsPopUpBook(boolean isPopUpBook) {
        this.isPopUpBook = isPopUpBook;
    }

    @Override
    public String toString() {
        return "ChildrenBook{" +
                "ageLimit=" + ageLimit +
                ", illustrator='" + illustrator + '\'' +
                ", isPopUpBook=" + isPopUpBook +
                ", pageNumber=" + pageNumber +
                ", title='" + title + '\'' +
                ", bookId=" + bookId +
                ", author=" + author +
                ", assurance=" + assurance +
                ", exemplare=" + exemplare +
                ", rating=" + rating +
                '}';
    }
}
