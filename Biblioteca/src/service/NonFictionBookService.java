package service;

import controller.AuthorController;
import model.Book.NonFictionBook;
import model.Book.FictionBook;
import model.autor.Author;
import repository.AuthorRepository;
import repository.NonFictionBookRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class NonFictionBookService {

    private NonFictionBookRepository nonFictionBookRepository;


    public NonFictionBookService() {
        this.nonFictionBookRepository = new NonFictionBookRepository();
    }

    public NonFictionBook addBook() {
        AuditService auditService = new AuditService();

        AuthorController ac = AuthorController.getInstance();
        Author author;
        ArrayList<String> acolades = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the book.");
        String title = scanner.nextLine();

        System.out.println("\nInsert option: \"1\": Add new author \"2\": Chooose existing one; ");
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            author = ac.addAuthor();
        } else {
            System.out.println("Please enter the index of the author");
            int indx = Integer.parseInt(scanner.nextLine());
            author = ac.getAuthor(indx);
        }

        System.out.println("Please enter number of pages of the book.");
        int pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter assurance tax of the book.");
        float assurance = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter number of books of this kind.");
        int exemplare = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the rating of the book out of 5.");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the number of the accolades received by the book ");
        int numberOfAcolades = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfAcolades; i++) {
            System.out.println("Please enter the name of the accolade.");
            String prize = scanner.nextLine();
            acolades.add(prize);
        }
        System.out.println("Please enter the subject of the book.");
        String subject = scanner.nextLine();
        System.out.println("Please enter the edition of the book.");
        int edition = Integer.parseInt(scanner.nextLine());


        NonFictionBook book = new NonFictionBook(pageNumber, title, author, assurance, exemplare, rating, subject, edition, numberOfAcolades, acolades);
        NonFictionBook result = nonFictionBookRepository.add(book);

        try {
            auditService.addAction("Add Non-Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }

        return result;
    }

    public NonFictionBook getBook(int idx) {
        NonFictionBook book = nonFictionBookRepository.get(idx);
        return book;
    }

    public Map<Integer,NonFictionBook> getAll() {
        return nonFictionBookRepository.getAll();
    }

    public boolean update(NonFictionBook book, float assurance) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Update Non-Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        nonFictionBookRepository.update(book, assurance);
        return true;
    }

    public boolean delete(int idx) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Delete Non-Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if (nonFictionBookRepository.delete(idx))
            return true;
        return false;
    }

    public boolean ShowAllEditions(int index) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Show all editions of Non-Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if (nonFictionBookRepository.ShowAllEditions(index))
            return true;
        return false;
    }

    public boolean CheckBooksLeft(int index) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Check books left of Non-Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if (nonFictionBookRepository.CheckBooksLeft(index))
            return true;
        return false;
    }
}
