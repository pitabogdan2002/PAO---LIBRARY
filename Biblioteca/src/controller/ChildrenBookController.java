package controller;

import model.Book.Book;
import model.Book.ChildrenBook;
import model.autor.Author;
import service.ChildrenBooksService;

import java.util.ArrayList;

public class ChildrenBookController {

    private static ChildrenBookController instance;
    private ChildrenBooksService childrenBooksService;

    public ChildrenBookController() {
        this.childrenBooksService = new ChildrenBooksService();
    }

    public static ChildrenBookController getInstance() {
        if (instance == null) {
            synchronized (ChildrenBookController.class) {
                if (instance == null) {
                    instance = new ChildrenBookController();
                }
            }
        }
        return instance;
    }

    public ChildrenBook addBook()
    {
        ChildrenBook book = childrenBooksService.addBook();
        System.out.println("Cartea a fost adaugata cu succes");
        return book;
    }

    public ChildrenBook getBook(int idx)
    {
        ChildrenBook book = childrenBooksService.getBook(idx);
        return book;
    }

    public ArrayList<ChildrenBook> getAll()
    {
        return childrenBooksService.getAll();
    }

    public boolean update(ChildrenBook book, float assurance)
    {
        return childrenBooksService.update(book,assurance);
    }

    public boolean delete(int idx)
    {
        return childrenBooksService.delete(idx);
    }
    public boolean numberOfBooks()
    {
        return  childrenBooksService.numberOfBooks();
    }

    public boolean CheckBooksLeft(int index)
    {
        return childrenBooksService.CheckBooksLeft(index);
    }

    public boolean determineAverageAgeLimit()
    {
        return childrenBooksService.determineAverageAgeLimit();
    }
}
