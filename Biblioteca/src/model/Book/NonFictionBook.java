package model.Book;

import model.autor.Author;

import java.util.ArrayList;

public class NonFictionBook extends Book {
    private String subject;
    private int edition;

    private ArrayList<String> acolades;

    private int numberOfAcolades;


    public NonFictionBook() {
    }

    public NonFictionBook(int pageNumber, String title, Author author, float assurance, int exemplare, double rating, String subject, int edition, int numberOfAcolades, ArrayList<String> acolades) {
        super(pageNumber, title, author, assurance, exemplare, rating);
        this.subject = subject;
        this.edition = edition;
        this.numberOfAcolades = numberOfAcolades;
        this.acolades = acolades;

    }

    public String getSubject() {
        return subject;
    }

    public int getEdition() {
        return edition;
    }

    public ArrayList<String> getAcolades() {
        return acolades;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setAcolades(ArrayList<String> acolades) {
        this.acolades = acolades;
    }

    @Override
    public String toString() {
        return "NonFictionBook{" +
                "subject='" + subject + '\'' +
                ", edition=" + edition +
                ", acolades=" + acolades +
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
