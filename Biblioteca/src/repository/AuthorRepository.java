package repository;

import model.Book.Book;
import model.autor.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorRepository {
    ArrayList <Author> authorsList = new ArrayList <Author>();

    public Author add(Author aut) {
        authorsList.add(aut);
        System.out.println(authorsList);
        return aut;
    }

    public Author get(int index) {
        System.out.println(index + " " + authorsList.size());
        if(index< authorsList.size())

            return authorsList.get(index);
        else
            return null;
    }

    public ArrayList<Author> getAll() {
        return authorsList;
    }

    public boolean update(Author author, Boolean alive) {
        author.setAlive(alive);
        return true;
    }

    public boolean delete(int index) {
        if(index< authorsList.size())
        {
            authorsList.remove(index);
            return true;
        }
        return false;
    }
    public boolean consacrat(int index)
    {
        if(index< authorsList.size())
        {
            if(authorsList.get(index).getAlive()== true)
                System.out.println("Autorul este consacrat");
            else
                System.out.println("Autorul este inca in viata");
            return true;
        }
        else
        System.out.println("Nu exista acest index.");
        return false;
    }
}
