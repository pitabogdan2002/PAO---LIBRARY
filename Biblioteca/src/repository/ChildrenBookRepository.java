package repository;

import model.Book.Book;
import model.Book.ChildrenBook;

import java.util.ArrayList;

public class ChildrenBookRepository {

    ArrayList<ChildrenBook> childrenBookList = new ArrayList<ChildrenBook>();

    ShortTermLoanRepository shortTermLoanRepository = new ShortTermLoanRepository();
    ExtendedLoanRepository extendedLoanRepository = new ExtendedLoanRepository();

    public ChildrenBook add(ChildrenBook book) {
        childrenBookList.add(book);
        System.out.println(childrenBookList);
        return book;
    }

    public ChildrenBook get(int index) {
        if (index < childrenBookList.size())
            return childrenBookList.get(index);
        return null;
    }

    public ArrayList<ChildrenBook> getAll() {
        return childrenBookList;
    }

    public boolean update(ChildrenBook book, float assurance) {

        book.setAssurance(assurance);
        return true;
    }

    public boolean delete(int index) {
        if (index < childrenBookList.size()) {
            childrenBookList.remove(index);
            return true;
        }
        return false;
    }

    public boolean numberOfBooks() {
        int contor = 0;
        for (int i = 0; i < childrenBookList.size(); i++)
            if (childrenBookList.get(i).getIsPopUpBook() == true)
                contor++;
        System.out.println(contor);
        return true;
    }


    public boolean CheckBooksLeft(int index) {
        if (index < childrenBookList.size()) {
            ArrayList<Book> lista = new ArrayList<Book>();
            int contor = 0;

            for (int i = 0; i < shortTermLoanRepository.getAll().size(); i++) {
                lista = shortTermLoanRepository.get(i).getBooksList();
                if (lista.contains(childrenBookList.get(index)))
                    contor++;
            }

            for (int i = 0; i < extendedLoanRepository.getAll().size(); i++) {
                lista = extendedLoanRepository.get(i).getBooksList();
                if (lista.contains(childrenBookList.get(index)))
                    contor++;
            }
            if (contor == childrenBookList.get(index).getExemplare())
                System.out.println("All books are borrowed");
            else
                System.out.println("There are " + (childrenBookList.get(index).getExemplare() - contor) + " books available of this type");

            return true;
        }
        return false;
    }

    public boolean determineAverageAgeLimit()
    {
        int sum = 0;
        int contor = 0;
        for(int i = 0; i < childrenBookList.size(); i++)
        {
            sum += childrenBookList.get(i).getAgeLimit();
            contor++;
        }
        System.out.println("The average age limit for children books is: " + sum/contor + " years\n");
        return true;
    }
}

