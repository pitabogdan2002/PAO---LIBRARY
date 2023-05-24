package model.Loan;
import model.Client.Client;
import model.Date.Date;
import model.Book.Book;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Loan {
    protected Boolean returned;

    protected Client client;
    protected Date loanedDate;
    protected Date returnDate;
    protected int booksNumber;

    protected ArrayList<Book> booksList;

    protected static int nextId = 1;
    protected int loanId;


    public Loan() {
        this.loanId = nextId;
        nextId++;
    }

    public Loan(Boolean returned, Client client, Date loanedDate, Date returnDate, int booksNumber, ArrayList<Book> booksList) {
        this.returned = returned;
        this.client = client;
        this.loanedDate = loanedDate;
        this.returnDate = returnDate;
        this.booksNumber = booksNumber;
        this.booksList = booksList;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(Date loanedDate) {
        this.loanedDate = loanedDate;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public void setBooksNumber(int booksNumber) {
        this.booksNumber = booksNumber;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Loan.nextId = nextId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "returned=" + returned +
                ", client=" + client +
                ", loanedDate=" + loanedDate +
                ", returnDate=" + returnDate +
                ", booksNumber=" + booksNumber +
                ", booksList=" + booksList +
                ", loanId=" + loanId +
                '}';
    }
}
