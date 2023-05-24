package repository;

import model.Book.Book;
import model.Loan.ExtendedLoan;
import model.Loan.Loan;
import model.autor.Author;

import java.util.ArrayList;

public class ExtendedLoanRepository {


    ArrayList<ExtendedLoan> extendedLoansList = new ArrayList <ExtendedLoan>();

    public ExtendedLoan add(ExtendedLoan loan) {
        extendedLoansList.add(loan);
        System.out.println(extendedLoansList);
        return loan;
    }

    public ExtendedLoan get(int index) {
        if(index< extendedLoansList.size())
            return extendedLoansList.get(index);
        return null;
    }

    public  ArrayList <ExtendedLoan> getAll() {
        return extendedLoansList;
    }

    public boolean update(ExtendedLoan loan, boolean returned) {

        loan.setReturned(returned);
        return true;
    }

    public boolean delete(int index) {
        if(index< extendedLoansList.size())
        {
            extendedLoansList.remove(index);
            return true;
        }
        return false;
    }



    public boolean tipImprumut(int index) {
        if(index< extendedLoansList.size())
        {
            Loan l = extendedLoansList.get(index);
            int nr = l.getBooksNumber();
            if(nr>10)
                System.out.println("Imprumut mare");
            else
                System.out.println("Imprumut mic");
            return true;
        }
        return false;
    }

    public boolean loanAuthors(int index) {
        if(index< extendedLoansList.size())
        {
            ArrayList <Author> listaAutori = new ArrayList<Author>();
            Loan l = extendedLoansList.get(index);
            ArrayList <Book> list = l.getBooksList();
            for(int i=0; i<list.size(); i++)
            {
                Book b = list.get(i);
                if(listaAutori.contains(b.getAuthor())==false)
                    listaAutori.add(b.getAuthor());
            }
            System.out.println("Numar de autori: " + listaAutori.size());
            for(int i=0; i<listaAutori.size(); i++)
                System.out.println(listaAutori.get(i));
            return true;
        }
        return false;
    }

    public boolean longestBook(int index) {
        if(index< extendedLoansList.size())
        {
            Book max = new Book();
            Loan l = extendedLoansList.get(index);
            ArrayList <Book> list = l.getBooksList();
            for(int i=0; i<list.size(); i++)
            {
                if(list.get(i).getPageNumber()>max.getPageNumber()) {
                    max = list.get(i);
                }
            }
            System.out.println(max);
            return true;
        }
        return false;
    }

    public boolean getAllBooks(int index) {
        if(index< extendedLoansList.size())
        {
            Loan l = extendedLoansList.get(index);
            ArrayList <Book> list = l.getBooksList();
            for(int i=0; i<list.size(); i++)
                System.out.println(list.get(i));
            return true;
        }
        return false;
    }
}
