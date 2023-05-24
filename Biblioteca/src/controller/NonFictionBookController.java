package controller;

import model.Book.NonFictionBook;
import model.autor.Author;
import service.NonFictionBookService;

import java.util.ArrayList;
import java.util.Map;

public class NonFictionBookController {

    private static NonFictionBookController instance;

    private NonFictionBookService nonFictionBookService;

    public NonFictionBookController() {
        this.nonFictionBookService = new NonFictionBookService();
    }

    public static NonFictionBookController getInstance() {
        if (instance == null) {
            synchronized (NonFictionBookController.class) {
                if (instance == null) {
                    instance = new NonFictionBookController();
                }
            }
        }
        return instance;
    }

    public NonFictionBook addBook() {
        NonFictionBook book = nonFictionBookService.addBook();
        System.out.println("Cartea premiata a fost adaugata cu succes");
        return book;
    }

    public NonFictionBook getBook(int idx) {
        NonFictionBook book = nonFictionBookService.getBook(idx);
        return book;
    }

    public Map<Integer,NonFictionBook> getAll() {
        return nonFictionBookService.getAll();
    }

    public boolean delete(int idx) {
        return nonFictionBookService.delete(idx);
    }

    public boolean update(NonFictionBook book, float assurance) {
        return nonFictionBookService.update(book, assurance);
    }

    public boolean ShowAllEditions(int index) {
        return nonFictionBookService.ShowAllEditions(index);
    }

    public boolean CheckBooksLeft(int index) {
        return nonFictionBookService.CheckBooksLeft(index);
    }
}