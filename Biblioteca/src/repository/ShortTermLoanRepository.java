package repository;

import model.Book.Book;
import model.Loan.Loan;
import model.autor.Author;
import model.Loan.ShortTermLoan;
import java.util.ArrayList;

public class ShortTermLoanRepository {

    ArrayList<ShortTermLoan> shortTermLoanList = new ArrayList <ShortTermLoan>();

    public ShortTermLoan add(ShortTermLoan loan) {
        shortTermLoanList.add(loan);
        System.out.println(shortTermLoanList);
        return loan;
    }

    public ShortTermLoan get(int index) {
        if(index< shortTermLoanList.size())
            return shortTermLoanList.get(index);
        return null;
    }

    public  ArrayList <ShortTermLoan> getAll() {
        return shortTermLoanList;
    }

    public boolean update(ShortTermLoan loan, boolean returned) {

        loan.setReturned(returned);
        return true;
    }

    public boolean delete(int index) {
        if(index< shortTermLoanList.size())
        {
            shortTermLoanList.remove(index);
            return true;
        }
        return false;
    }
    public boolean tipImprumut(int index) {
        if(index< shortTermLoanList.size())
        {
            Loan l = shortTermLoanList.get(index);
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
        if(index< shortTermLoanList.size())
        {
            ArrayList <Author> listaAutori = new ArrayList<Author>();
            Loan l = shortTermLoanList.get(index);
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
        if(index< shortTermLoanList.size())
        {
            Book max = new Book();
            Loan l = shortTermLoanList.get(index);
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
        if(index< shortTermLoanList.size())
        {
            Loan l = shortTermLoanList.get(index);
            ArrayList <Book> list = l.getBooksList();
            for(int i=0; i<list.size(); i++)
                System.out.println(list.get(i));
            return true;
        }
        return false;
    }
}
