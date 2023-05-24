package repository;

import model.Book.Book;
import model.Book.FictionBook;

import java.util.ArrayList;
import java.util.Collections;

public class FictionBookRepository {
    ArrayList<FictionBook> fictionBooksList = new ArrayList <FictionBook>();

    ShortTermLoanRepository shortTermLoanRepository = new ShortTermLoanRepository();
    ExtendedLoanRepository extendedLoanRepository = new ExtendedLoanRepository();

    public FictionBook add(FictionBook book) {
        fictionBooksList.add(book);
        Collections.sort(fictionBooksList);
        System.out.println( fictionBooksList);
        return book;
    }

    public FictionBook get(int index) {
        if(index<  fictionBooksList.size())
            return  fictionBooksList.get(index);
        return null;
    }

    public  ArrayList <FictionBook> getAll() {
        return  fictionBooksList;
    }

    public boolean update(FictionBook book, float assurance) {

        book.setAssurance(assurance);
        return true;
    }

    public boolean delete(int index) {
        if(index<  fictionBooksList.size())
        {
            fictionBooksList.remove(index);
            return true;
        }
        return false;
    }

    public boolean CheckBooksLeft(int index) {
        if (index < fictionBooksList.size()) {
            ArrayList<Book> lista = new ArrayList<Book>();
            int contor = 0;

            for (int i = 0; i < shortTermLoanRepository.getAll().size(); i++) {
                lista = shortTermLoanRepository.get(i).getBooksList();
                if (lista.contains(fictionBooksList.get(index)))
                    contor++;
            }

            for (int i = 0; i < extendedLoanRepository.getAll().size(); i++) {
                lista = extendedLoanRepository.get(i).getBooksList();
                if (lista.contains(fictionBooksList.get(index)))
                    contor++;
            }
            if (contor == fictionBooksList.get(index).getExemplare())
                System.out.println("All books are borrowed");
            else
                System.out.println("There are " + (fictionBooksList.get(index).getExemplare() - contor) + " books available of this type");

            return true;
        }
        return false;
    }

    public boolean FantasayAndBestsellerbooks()
    {
        for(int i=0;i<fictionBooksList.size();i++)
        {
            if(fictionBooksList.get(i).getGenre().equals("fantasy") && fictionBooksList.get(i).getIsBestseller()==true)
                System.out.println(fictionBooksList.get(i));
        }
        return true;
    }

    public boolean OrderGenresBasedOnFrequency()
    {
        ArrayList<String> genres = new ArrayList<String>();
        ArrayList<Integer> frequency = new ArrayList<Integer>();
        for(int i=0;i<fictionBooksList.size();i++)
        {
            if(genres.contains(fictionBooksList.get(i).getGenre()))
            {
                int index = genres.indexOf(fictionBooksList.get(i).getGenre());
                frequency.set(index,frequency.get(index)+1);
            }
            else
            {
                genres.add(fictionBooksList.get(i).getGenre());
                frequency.add(1);
            }
        }
        for(int i=0;i<genres.size();i++)
        {
            for(int j=i+1;j<genres.size();j++)
            {
                if(frequency.get(i)<frequency.get(j))
                {
                    int aux = frequency.get(i);
                    frequency.set(i,frequency.get(j));
                    frequency.set(j,aux);
                    String aux2 = genres.get(i);
                    genres.set(i,genres.get(j));
                    genres.set(j,aux2);
                }
            }
        }
        for(int i=0;i<genres.size();i++)
        {
            System.out.println(genres.get(i)+" "+frequency.get(i));
        }
        return true;
    }
}
