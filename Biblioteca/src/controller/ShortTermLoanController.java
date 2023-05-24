package controller;

import model.Book.Book;
import model.Client.Client;
import model.Date.Date;
import model.Loan.ShortTermLoan;
import service.ShortTermLoanService;

import java.util.ArrayList;

public class ShortTermLoanController {


    private static ShortTermLoanController instance;
    private ShortTermLoanService shortTermLoanService;
    public ShortTermLoanController() {
        this.shortTermLoanService = new ShortTermLoanService();
    }

    public static ShortTermLoanController getInstance() {
        if (instance == null) {
            synchronized (ShortTermLoanController.class) {
                if (instance == null) {
                    instance = new ShortTermLoanController();
                }
            }
        }
        return instance;
    }

    public ShortTermLoan addLoan(Client client, Date loanedDate, Date returnedDate, ArrayList<Book> books)
    {
        ShortTermLoan loan = shortTermLoanService.addLoan(client, loanedDate, returnedDate, books);
        System.out.println("Cartea a fost adaugata cu succes");
        return loan;
    }

    public boolean update(ShortTermLoan loan, boolean returned)
    {
        return shortTermLoanService.update(loan,returned);
    }

    public ShortTermLoan getLoan(int idx)
    {
        ShortTermLoan loan = shortTermLoanService.getLoan(idx);
        return loan;
    }

    public ArrayList<ShortTermLoan> getAll()
    {
        return shortTermLoanService.getAll();
    }

    public boolean delete(int idx)
    {
        return shortTermLoanService.delete(idx);
    }

    public boolean tipImprumut(int idx)
    {
        return shortTermLoanService.tipImprumut(idx);
    }

    public boolean loanAuthors(int idx)
    {
        return shortTermLoanService.loanAuthors(idx);
    }
    public boolean longestBook(int idx)
    {
        return shortTermLoanService.longestBook(idx);
    }
}
