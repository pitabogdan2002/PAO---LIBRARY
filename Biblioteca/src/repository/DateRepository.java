package repository;

import model.Client.Client;
import model.Date.Date;

import java.util.ArrayList;

public class DateRepository {

    ArrayList<Date> datesList = new ArrayList <Date>();

    public Date add(Date date) {
        datesList.add(date);
        System.out.println(datesList);
        return date;
    }
}
