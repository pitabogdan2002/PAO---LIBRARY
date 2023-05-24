package model.autor;

public class Author {

    private String firstName;
    private String lastName;

    private Boolean alive;
    private int numberOfBooks;

    private static int nextId = 1;
    private int authorId;

    public Author() {
        this.authorId = nextId;
        nextId++;

    }

    public Author(String firstName, String lastName, Boolean alive, int numberOfBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alive = alive;
        this.numberOfBooks = numberOfBooks;
        this.authorId = nextId;
        nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public static void setNextId(int nextId) {
        Author.nextId = nextId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alive=" + alive +
                ", numberOfBooks=" + numberOfBooks +
                ", authorId=" + authorId +
                '}';
    }
}