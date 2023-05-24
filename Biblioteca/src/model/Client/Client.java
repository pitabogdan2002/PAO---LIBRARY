package model.Client;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private String firstName;
    private String lastName;
    private int age;

    private String gender;

    private int monthsTaxes;
    private ArrayList<Float> taxes;

    private int monthsLoans;

    private ArrayList<Integer> loans;

    private static int nextId = 1;
    private int clientId;

    public Client() {

        this.clientId = nextId;
        nextId++;
    }

    public Client(String firstName, String lastName, int age, String gender, int monthsTaxes, ArrayList<Float> taxes, int monthsLoans, ArrayList<Integer> loans) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.monthsTaxes = monthsTaxes;
        this.taxes = taxes;
        this.monthsLoans = monthsLoans;
        this.loans = loans;
        this.clientId = nextId;
        nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMonthsTaxes() {
        return monthsTaxes;
    }

    public void setMonthsTaxes(int monthsTaxes) {
        this.monthsTaxes = monthsTaxes;
    }

    public ArrayList<Float> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<Float> taxes) {
        this.taxes = taxes;
    }

    public int getMonthsLoans() {
        return monthsLoans;
    }

    public void setMonthsLoans(int monthsLoans) {
        this.monthsLoans = monthsLoans;
    }

    public ArrayList<Integer> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Integer> loans) {
        this.loans = loans;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Client.nextId = nextId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String
    toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", monthsTaxes=" + monthsTaxes +
                ", taxes=" + taxes +
                ", monthsLoans=" + monthsLoans +
                ", loans=" + loans +
                ", clientId=" + clientId +
                '}';
    }
}
