package service;

import controller.AuthorController;
import model.Book.ChildrenBook;
import model.autor.Author;
import repository.AuthorRepository;
import repository.ChildrenBookRepository;
import model.Book.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChildrenBooksService {
    private ChildrenBookRepository childrenBookRepository;
    private AuthorRepository authorRepository;

    public ChildrenBooksService() {
        this.childrenBookRepository= new ChildrenBookRepository();
        this.authorRepository = new AuthorRepository();
    }

    public ChildrenBook addBook() {

        AuditService auditService = new AuditService();

        AuthorController ac = AuthorController.getInstance();
        Author author;
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

        System.out.println("Please enter number of pages of the book.");
        int pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter assurance tax of the book.");
        float assurance = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter number of books of this kind.");
        int exemplare = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the rating of the book out of 5.");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter if the book is pop up or not (true/false).");
        Boolean popUp= Boolean.valueOf(scanner.nextLine());
        System.out.println("Please enter the age limit of the book.");
        int ageLimit = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the name of the illustrator.");
        String illustrator= scanner.nextLine();

        ChildrenBook book = new ChildrenBook(pageNumber, title, author, assurance, exemplare, rating, ageLimit, illustrator, popUp);
        ChildrenBook result = childrenBookRepository.add(book);
        try {
            auditService.addAction("Add Children book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        return result;
    }

    public ChildrenBook getBook(int idx) {
        ChildrenBook book = childrenBookRepository.get(idx);
        return book;
    }

    public ArrayList<ChildrenBook> getAll()
    {
        return childrenBookRepository.getAll();
    }
    public boolean update(ChildrenBook book, float assurance) {
        try {
            AuditService auditService = new AuditService();
            auditService.addAction("Update Children book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        childrenBookRepository.update(book,assurance);
        return true;
    }

    public boolean delete(int idx)
    {

        try{
            AuditService auditService = new AuditService();
            auditService.addAction("Delete Children book");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(childrenBookRepository.delete(idx))
            return true;
        return false;
    }
    public boolean numberOfBooks()
    {
        try{
            AuditService auditService = new AuditService();
            auditService.addAction("Number of Children books");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(childrenBookRepository.numberOfBooks())
            return true;
        return false;
    }

    public boolean CheckBooksLeft(int index)
    {
        try{
            AuditService auditService = new AuditService();
            auditService.addAction("Check Children books left");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(childrenBookRepository.CheckBooksLeft(index))
            return true;
        return false;
    }
    public boolean determineAverageAgeLimit()
    {
        try{
            AuditService auditService = new AuditService();
            auditService.addAction("Determine average age limit");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
        if(childrenBookRepository.determineAverageAgeLimit())
            return true;
        return false;
    }

}
