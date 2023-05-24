package controller;

import model.Book.FictionBook;
import model.autor.Author;
import service.FictionBookService;

import java.util.ArrayList;

public class FictionBookController {


    private static FictionBookController instance;
    private FictionBookService fictionBookService;

    private FictionBookController() {
        this.fictionBookService = new FictionBookService();
    }

    public static FictionBookController getInstance() {
        if (instance == null) {
            synchronized (FictionBookController.class) {
                if (instance == null) {
                    instance = new FictionBookController();
                }
            }
        }
        return instance;
    }


    public FictionBook addBook()
    {
        FictionBook book = fictionBookService.addBook();
        System.out.println("Cartea de tip Fictiune a fost adaugata cu succes");
        return book;
    }

    public FictionBook getBook(int idx)
    {
        FictionBook book = fictionBookService.getBook(idx);
        return book;
    }

    public ArrayList<FictionBook> getAll()
    {
        return fictionBookService.getAll();
    }

    public boolean delete(int idx)
    {
        return fictionBookService.delete(idx);
    }

    public boolean update(FictionBook book, float assruance)
    {
        return fictionBookService.update(book,  assruance);
    }

    public boolean CheckBooksLeft(int idx)
    {
        return fictionBookService.CheckBooksLeft(idx);
    }

    public boolean FantasayAndBestsellerbooks()
    {
        return fictionBookService.FantasayAndBestsellerbooks();
    }

    public boolean OrderGenresBasedOnFrequency()
    {
        return fictionBookService.OrderGenresBasedOnFrequency();
    }

}
