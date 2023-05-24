package model.Library;
import model.Client.Client;
import model.Book.Book;
import model.Loan.Loan;
public class Library {

    private String name;
    private String address;

    private int clientsNumber;
    private Client[] clients;

    private int booksNumber;

    private Book[] books;

    private int loansNumber;

    private Loan[] loans;

    private static int nextId = 1;
    private int libraryId;

    public Library() {

        this.libraryId = nextId;
        nextId++;
    }

    public Library(String name, String address, int clientsNumber, Client[] clients, int booksNumber, Book[] books, int loansNumber, Loan[] loans) {
        this.name = name;
        this.address = address;
        this.clientsNumber = clientsNumber;
        this.clients = clients;
        this.booksNumber = booksNumber;
        this.books = books;
        this.loansNumber = loansNumber;
        this.loans = loans;

        this.libraryId = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClientsNumber() {
        return clientsNumber;
    }

    public void setClientsNumber(int clientsNumber) {
        this.clientsNumber = clientsNumber;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public void setBooksNumber(int booksNumber) {
        this.booksNumber = booksNumber;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getLoansNumber() {
        return loansNumber;
    }

    public void setLoansNumber(int loansNumber) {
        this.loansNumber = loansNumber;
    }

    public Loan[] getLoans() {
        return loans;
    }

    public void setLoans(Loan[] loans) {
        this.loans = loans;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Library.nextId = nextId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }
}
