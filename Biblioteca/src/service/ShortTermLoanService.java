package service;
import model.Book.Book;
import model.Client.Client;
import model.Date.Date;
import model.Loan.ShortTermLoan;
import repository.ChildrenBookRepository;
import repository.ShortTermLoanRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortTermLoanService {


    private ChildrenBookRepository bookRepository;
    private ShortTermLoanRepository shortTermLoanRepository;

    public ShortTermLoanService() {
        this.shortTermLoanRepository = new ShortTermLoanRepository();

    }

    public ShortTermLoan addLoan(Client client, Date loanedDate, Date returnedDate, ArrayList<Book> books ) {

        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter if the loan was returned (true/false).");
        Boolean returned = Boolean.valueOf(scanner.nextLine());
        System.out.println("Please enter the reason of the loan .");
        String reason = scanner.nextLine();
        int numberOfBooks = books.size();
        ShortTermLoan loan = new ShortTermLoan(returned,client,loanedDate,returnedDate,numberOfBooks,books, reason);
        ShortTermLoan result = shortTermLoanRepository.add(loan);

        try {
            auditService.addAction("Add short term loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        return result;
    }

    public ShortTermLoan getLoan(int idx) {
        ShortTermLoan loan = shortTermLoanRepository.get(idx);
        return loan;
    }

    public ArrayList<ShortTermLoan> getAll()
    {
        return shortTermLoanRepository.getAll();
    }
    public boolean update(ShortTermLoan loan, boolean returned) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Update short term loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        shortTermLoanRepository.update(loan,returned);
        return true;
    }

    public boolean delete(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Delete short term loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(shortTermLoanRepository.delete(idx))
            return true;
        return false;
    }
    public boolean tipImprumut(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Tip imprumut");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(shortTermLoanRepository.tipImprumut(idx))
            return true;
        return false;
    }
    public boolean loanAuthors(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Loan authors");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(shortTermLoanRepository.loanAuthors(idx))
            return true;
        return false;
    }

    public boolean longestBook(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Longest book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(shortTermLoanRepository.longestBook(idx))
            return true;
        return false;
    }
}
