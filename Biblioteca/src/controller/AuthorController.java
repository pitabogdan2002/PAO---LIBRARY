package controller;

import model.autor.Author;
import service.AuthorService;

import java.util.ArrayList;

public class AuthorController {

    private static AuthorController instance;
    private AuthorService authorService;
    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public static AuthorController getInstance() {
        if (instance == null) {
            synchronized (AuthorController.class) {
                if (instance == null) {
                    instance = new AuthorController();
                }
            }
        }
        return instance;
    }

    public Author addAuthor()
    {
        Author author = authorService.addAuthor();
        System.out.println("Autorul a fost adaugat cu succes");
        return author;
    }

    public Author getAuthor(int idx)
    {
        Author author = authorService.getAuthor(idx);
        return author;
    }

    public ArrayList<Author> getAll()
    {
        return authorService.getAll();
    }
    public boolean update(Author author, Boolean alive) {
        authorService.update(author,alive);
        return true;
    }

    public boolean delete(int idx)
    {
        return authorService.delete(idx);
    }
    public boolean consacrat(int idx)
    {
        return authorService.consacrat(idx);
    }
}
