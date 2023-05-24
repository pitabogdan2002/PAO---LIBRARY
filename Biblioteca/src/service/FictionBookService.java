package service;

import model.autor.Author;
import repository.AuthorRepository;
import repository.FictionBookRepository;
import model.Book.FictionBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import controller.AuthorController;
public class FictionBookService {


    private FictionBookRepository fictionBookRepository;




    public FictionBookService() {
        this.fictionBookRepository = new FictionBookRepository();
    }

    public FictionBook addBook() {

        AuditService auditService = new AuditService();
        AuthorController ac = AuthorController.getInstance();
        Author author = null;
        //AuthorRepository ar = new AuthorRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the book.");
        String title = scanner.nextLine();
        System.out.println("\nInsert option: \"1\": Add new author \"2\": Chooose existing one; ");
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
             author = ac.addAuthor();
        }
        else
        {
            System.out.println("Please enter the index of the author");
            int indx= Integer.parseInt(scanner.nextLine());
            author = ac.getAuthor(indx);
        }
        System.out.println(author);
        System.out.println("Please enter number of pages of the book.");
        int pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter assurance tax of the book.");
        float assurance = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter number of books of this kind.");
        int exemplare = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the rating of the book out of 5.");
        double rating = Double.parseDouble(scanner.nextLine());


        System.out.println("Please enter the genre of the book.");
        String genre = scanner.nextLine();
        System.out.println("Please enter if the book is a best seller or not (true/false).");
        Boolean isBestSeller = Boolean.valueOf(scanner.nextLine());

        FictionBook book = new FictionBook(pageNumber, title, author,  genre,assurance, exemplare, rating, isBestSeller);
        FictionBook result = fictionBookRepository.add(book);

        try {
            auditService.addAction("Add Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        return result;
    }

    public FictionBook getBook(int idx) {
        FictionBook book = fictionBookRepository.get(idx);
        return book;
    }

    public ArrayList<FictionBook> getAll()
    {
        return fictionBookRepository.getAll();
    }
    public boolean update(FictionBook book, float assurance) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Update Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        fictionBookRepository.update(book,assurance);
        return true;
    }

    public boolean delete(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Delete Fiction book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(fictionBookRepository.delete(idx))
            return true;
        return false;
    }

    public boolean CheckBooksLeft(int idx)
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Check if there are books left");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(fictionBookRepository.CheckBooksLeft(idx))
            return true;
        return false;
    }

    public boolean FantasayAndBestsellerbooks()
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Check if there are fantasy and bestseller books");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(fictionBookRepository.FantasayAndBestsellerbooks())
            return true;
        return false;
    }

    public boolean OrderGenresBasedOnFrequency()
    {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Order genres based on frequency");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(fictionBookRepository.OrderGenresBasedOnFrequency())
            return true;
        return false;
    }




}
