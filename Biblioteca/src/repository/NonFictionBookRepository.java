package repository;

import model.Book.Book;
import model.Book.NonFictionBook;
import model.Book.FictionBook;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class NonFictionBookRepository {

    Map<Integer,NonFictionBook> nonFictionBooksList = new HashMap<>() ;

    ExtendedLoanRepository extendedLoanRepository = new ExtendedLoanRepository();
    ShortTermLoanRepository shortTermLoanRepository = new ShortTermLoanRepository();

    public NonFictionBook add(NonFictionBook book) {
        nonFictionBooksList.put(book.getBookId(),book);
        System.out.println(nonFictionBooksList);
        return book;
    }

    public NonFictionBook get(int index) {
        if(index<=  nonFictionBooksList.size())
            return  nonFictionBooksList.get(index);
        return null;
    }

    public  Map<Integer,NonFictionBook> getAll() {
        return  nonFictionBooksList;
    }

    public boolean update(NonFictionBook book, float assurance) {

        book.setAssurance(assurance);
        return true;
    }

    public boolean delete(int index) {
        if(index<= nonFictionBooksList.size())
        {
            nonFictionBooksList.remove(index);
            return true;
        }
        return false;
    }

    public boolean CheckBooksLeft(int index) {
        if (index <= nonFictionBooksList.size()) {
            ArrayList<Book> lista = new ArrayList<Book>();
            int contor = 0;

            for (int i = 0; i < shortTermLoanRepository.getAll().size(); i++) {
                lista = shortTermLoanRepository.get(i).getBooksList();
                if (lista.contains(nonFictionBooksList.get(index)))
                    contor++;
            }

            for (int i = 0; i < extendedLoanRepository.getAll().size(); i++) {
                lista = extendedLoanRepository.get(i).getBooksList();
                if (lista.contains(nonFictionBooksList.get(index)))
                    contor++;
            }
            System.out.println(contor);
            if (contor == nonFictionBooksList.get(index).getExemplare())
                System.out.println("All books are borrowed");
            else
                System.out.println("There are " + (nonFictionBooksList.get(index).getExemplare() - contor) + " books available of this type");

            return true;
        }
        return false;
    }

    public boolean ShowAllEditions(int index)
    {

        if(index<=  nonFictionBooksList.size())
        {
            HashSet <Integer> editions = new HashSet<Integer>();
            String Title = nonFictionBooksList.get(index).getTitle();
            for(int i=0; i< nonFictionBooksList.size(); i++)
            {
                if(Title.equals(nonFictionBooksList.get(i+1).getTitle()))
                {
                    editions.add(nonFictionBooksList.get(i+1).getEdition());
                }

            }
            if(editions.size()>=1)
                for(int i=0; i< editions.size(); i++)
                {
                    System.out.println(editions);
                }
            return true;
        }
        return false;
    }
}
