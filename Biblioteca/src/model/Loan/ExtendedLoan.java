package model.Loan;

import model.Book.Book;
import model.Client.Client;
import model.Date.Date;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtendedLoan extends Loan{
    protected int tax;
    protected int numberOfDays;

    public ExtendedLoan() {
    }

    public ExtendedLoan(Boolean returned, Client client, Date loanedDate, Date returnDate, int booksNumber, ArrayList<Book> booksList, int tax, int numberOfDays) {
        super(returned, client, loanedDate, returnDate, booksNumber, booksList);
        this.tax = tax;
        this.numberOfDays = numberOfDays;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "ExtendedLoan{" +
                "tax=" + tax +
                ", numberOfDays=" + numberOfDays +
                ", returned=" + returned +
                ", client=" + client +
                ", loanedDate=" + loanedDate +
                ", returnDate=" + returnDate +
                ", booksNumber=" + booksNumber +
                ", booksList=" + booksList +
                ", loanId=" + loanId +
                '}';
    }
}
