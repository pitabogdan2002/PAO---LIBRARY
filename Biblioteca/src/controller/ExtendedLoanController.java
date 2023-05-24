package controller;

import model.Book.Book;
import model.Client.Client;
import model.Date.Date;
import model.Loan.ExtendedLoan;

import service.ExtendedLoanService;

import java.util.ArrayList;

public class ExtendedLoanController {

    private static ExtendedLoanController instance;

    private ExtendedLoanService extendedLoanService;
    public ExtendedLoanController() {
        this.extendedLoanService = new ExtendedLoanService();
    }

    public static ExtendedLoanController getInstance() {
        if (instance == null) {
            synchronized (ExtendedLoanController.class) {
                if (instance == null) {
                    instance = new ExtendedLoanController();
                }
            }
        }
        return instance;
    }

    public ExtendedLoan addLoan(Client client, Date loanedDate, Date returnedDate, ArrayList<Book> books)
    {
        ExtendedLoan loan = extendedLoanService.addLoan(client, loanedDate, returnedDate, books);
        System.out.println("Cartea a fost adaugata cu succes");
        return loan;
    }

    public boolean update(ExtendedLoan loan, boolean returned)
    {
        return extendedLoanService.update(loan, returned);
    }

    public ExtendedLoan getLoan(int idx)
    {
        ExtendedLoan loan = extendedLoanService.getLoan(idx);
        return loan;
    }

    public ArrayList<ExtendedLoan> getAll()
    {
        return extendedLoanService.getAll();
    }

    public boolean delete(int idx)
    {
        return extendedLoanService.delete(idx);
    }


    public boolean tipImprumut(int idx)
    {
        return extendedLoanService.tipImprumut(idx);
    }

    public boolean loanAuthors(int idx)
    {
        return extendedLoanService.loanAuthors(idx);
    }
    public boolean longestBook(int idx)
    {
        return extendedLoanService.longestBook(idx);
    }
}
