package service;

import model.Book.Book;
import model.Client.Client;
import model.Date.Date;
import model.Loan.ExtendedLoan;
import repository.ChildrenBookRepository;
import repository.ExtendedLoanRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExtendedLoanService {


    private ChildrenBookRepository bookRepository;
    private ExtendedLoanRepository extendedLoanRepository;

    public ExtendedLoanService() {
        this.extendedLoanRepository = new ExtendedLoanRepository();

    }

    public ExtendedLoan addLoan(Client client, Date loanedDate, Date returnedDate, ArrayList<Book> books ) {

        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the tax.");
        int tax = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter number of days of extension. ");
        int numberOfDays = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter if the loan was returned (true/false).");
        Boolean returned = Boolean.valueOf(scanner.nextLine());
        int numberOfBooks = books.size();
        ExtendedLoan loan = new ExtendedLoan(returned,client,loanedDate,returnedDate,numberOfBooks,books,tax,numberOfDays);
        ExtendedLoan result = extendedLoanRepository.add(loan);

        try {
            auditService.addAction("Add Extended Loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }

        return result;



    }

    public ExtendedLoan getLoan(int idx) {
        ExtendedLoan loan = extendedLoanRepository.get(idx);
        return loan;
    }

    public ArrayList<ExtendedLoan> getAll()
    {
        return extendedLoanRepository.getAll();
    }
    public boolean update(ExtendedLoan loan, boolean returned) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Update Extended Loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        extendedLoanRepository.update(loan,returned);
        return true;
    }

    public boolean delete(int idx)
    {
        try{
            AuditService auditService = new AuditService();
            auditService.addAction("Delete Extended Loan");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(extendedLoanRepository.delete(idx))
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
        if(extendedLoanRepository.tipImprumut(idx))
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
        if(extendedLoanRepository.loanAuthors(idx))
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
        if(extendedLoanRepository.longestBook(idx))
            return true;
        return false;
    }


}
