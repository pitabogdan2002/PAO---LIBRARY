package service;

import model.Date.Date;
import model.autor.Author;
import repository.AuthorRepository;
import repository.DateRepository;

import java.util.Scanner;

public class DateService {
    private DateRepository dateRepository;

    public DateService() {
        this.dateRepository = new DateRepository();
    }

    public Date addDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter day.");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter month.");
        int month= Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter year.");
        int year = Integer.parseInt(scanner.nextLine());


        Date date = new Date(day,month,year);
        Date result = dateRepository.add(date);
        return result;
    }
}
