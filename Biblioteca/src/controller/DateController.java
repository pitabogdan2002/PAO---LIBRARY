package controller;

import model.Date.Date;
import model.autor.Author;
import service.AuthorService;
import service.DateService;

public class DateController {

    private DateService dateService;
    public DateController() {
        this.dateService = new DateService();
    }

    public Date addDate()
    {
        Date date = dateService.addDate();
        System.out.println("Data a fost adaugata cu succes");
        return date;
    }

}
