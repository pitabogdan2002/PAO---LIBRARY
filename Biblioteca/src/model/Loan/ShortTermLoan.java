package model.Loan;

import model.Book.Book;
import model.Client.Client;
import model.Date.Date;

import java.util.ArrayList;

public class ShortTermLoan extends Loan {
    private String reasonLoan;

    public ShortTermLoan() {
    }

    public ShortTermLoan(String reasonLoan) {
        this.reasonLoan = reasonLoan;
    }

    public ShortTermLoan(Boolean returned, Client client, Date loanedDate, Date returnDate, int booksNumber, ArrayList<Book> booksList, String reasonLoan) {
        super(returned, client, loanedDate, returnDate,  booksNumber, booksList);
        this.reasonLoan = reasonLoan;
    }

    public String getReasonLoan() {
        return reasonLoan;
    }

    public void setReasonLoan(String reasonLoan) {
        this.reasonLoan = reasonLoan;
    }

    @Override
    public String toString() {
        return "ShortTermLoan{" +
                "reasonLoan='" + reasonLoan + '\'' +
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
