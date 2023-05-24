import controller.*;
import database.DbFunctions;
import model.Book.Book;
import model.Book.FictionBook;
import model.Book.NonFictionBook;
import model.Book.ChildrenBook;
import model.Client.Client;
import model.Date.Date;
import model.Loan.ExtendedLoan;
import model.Loan.Loan;
import model.Loan.ShortTermLoan;
import model.autor.Author;
import service.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DbFunctions dbFunctions = new DbFunctions();

        Connection con = dbFunctions.getInstance("biblioteca","postgres","summerday,12");

        //dbFunctions.CreateTable(con, "Author");
        //dbFunctions.CreateTable(con, "ChildrenBook");
        //dbFunctions.CreateTable(con, "FictionBook");
        //dbFunctions.CreateTable(con, "NonFictionBook");
        //dbFunctions.CreateTable(con, "Client");
        //dbFunctions.CreateTable(con, "ShortTermLoan");
        //dbFunctions.CreateTable(con, "ExtendedLoan");


        ChildrenBookController cbc = ChildrenBookController.getInstance();
        AuthorController ac = AuthorController.getInstance();
        ClientController cc = ClientController.getInstance();
        ShortTermLoanController lc = ShortTermLoanController.getInstance();
        DateController dc = new DateController();
        FictionBookController fbc = FictionBookController.getInstance();
        NonFictionBookController nfbc = NonFictionBookController.getInstance();
        AuditService auditService = new AuditService();
        ExtendedLoanController elc = ExtendedLoanController.getInstance();
        ShortTermLoanController stlc = ShortTermLoanController.getInstance();


        System.out.println("Library");
        Scanner sc = new Scanner(System.in);
        String option;

        do {
            System.out.println("\nInsert option: \"1\": Actions for books; \"2\": Actions for authors; " +
                    "  \"3\": Actions for Clients;  \"4\": Actions for Loans;  \"5\": Data Base Actions; \n" );
            option = sc.nextLine();
            System.out.println("You inserted: " + option);


            if (Integer.parseInt(option) == 1) {

                System.out.println("\nInsert option: \"1\": Fiction book; \"2\": Non-fiction book; \"3\": Children book; ");

                option = sc.nextLine();
                System.out.println("You inserted: " + option);
                if (Integer.parseInt(option) == 1) {
                    System.out.println("\nInsert option: \"1\": Add book; \"2\": Update book; \"3\": Delete book; \"4\" Check books left; " +
                            "\"5\": Fantasy and bestseller books; \"6\": Order genres based on frequency; ");

                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (Integer.parseInt(option) == 1) {

                        FictionBook book = fbc.addBook();
                        System.out.println(book);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the book to be updated.");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println("Please enter the new assurance value.");
                        float assurance = Float.parseFloat(sc.nextLine());
                        FictionBook book = fbc.getBook(index);
                        fbc.update(book, assurance);
                        System.out.println(book);

                    } else if (Integer.parseInt(option) == 3) {

                        System.out.println("Please enter the index of the book to be deleted.");
                        int index = Integer.parseInt(sc.nextLine());
                        fbc.delete(index);

                    } else if (Integer.parseInt(option) == 4) {
                        System.out.println("Please enter the index of the book.");
                        int index = Integer.parseInt(sc.nextLine());
                        fbc.CheckBooksLeft(index);

                    } else if (Integer.parseInt(option) == 5) {
                        fbc.FantasayAndBestsellerbooks();

                    } else if (Integer.parseInt(option) == 6) {
                        fbc.OrderGenresBasedOnFrequency();

                    }

                } else if (Integer.parseInt(option) == 2) {

                    System.out.println("\nInsert option: \"1\": Add book; \"2\": Update book; \"3\": Delete book;  \"4\" Check books left;  \"5\"Show all editions; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (Integer.parseInt(option) == 1) {
                        NonFictionBook book = nfbc.addBook();
                        System.out.println(book);

                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the book to be updated.");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println("Please enter the new assurance value.");
                        float assurance = Float.parseFloat(sc.nextLine());
                        NonFictionBook book = nfbc.getBook(index);
                        nfbc.update(book, assurance);
                        System.out.println(book);

                    } else if (Integer.parseInt(option) == 3) {

                        System.out.println("Please enter the index of the book to be deleted.");
                        int index = Integer.parseInt(sc.nextLine());
                        nfbc.delete(index);

                    } else if (Integer.parseInt(option) == 4) {
                        System.out.println("Please enter the index of the book.");
                        int index = Integer.parseInt(sc.nextLine());
                        nfbc.CheckBooksLeft(index);
                    } else if (Integer.parseInt(option) == 5) {
                        System.out.println("Please enter the index of the book.");
                        int index = Integer.parseInt(sc.nextLine());

                        nfbc.ShowAllEditions(index);
                    }


                } else if (Integer.parseInt(option) == 3) {
                    System.out.println("\nInsert option: \"1\": Add book; \"2\": Update book; \"3\": Delete book;  \"4\" Check books left;  \"5\" Number of pop up books  \"6\" Average age limit; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (Integer.parseInt(option) == 1) {
                        ChildrenBook book = cbc.addBook();
                        System.out.println(book);

                    }
                    else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the book to be updated.");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println("Please enter the new assurance value.");
                        float assurance = Float.parseFloat(sc.nextLine());
                        ChildrenBook book = cbc.getBook(index);
                        cbc.update(book, assurance);
                        System.out.println(book);

                    } else if (Integer.parseInt(option) == 3) {

                        System.out.println("Please enter the index of the book to be deleted.");
                        int index = Integer.parseInt(sc.nextLine());
                        cbc.delete(index);

                    } else if (Integer.parseInt(option) == 4) {
                        System.out.println("Please enter the index of the book.");
                        int index = Integer.parseInt(sc.nextLine());
                        cbc.CheckBooksLeft(index);
                    } else if (Integer.parseInt(option) == 5) {
                        cbc.numberOfBooks();
                    } else if (Integer.parseInt(option) == 6) {
                        cbc.determineAverageAgeLimit();
                    }
                }
            }


             else if (Integer.parseInt(option) == 2) {
                System.out.println("\nInsert option: \"1\": Add author; \"2\": Update author; \"3\": Delete author; \"4\": Check type of author; ");

                option = sc.nextLine();
                System.out.println("You inserted: " + option);
                if (Integer.parseInt(option) == 1) {
                    Author aut = ac.addAuthor();
                    System.out.println(aut);
                }
                else if (Integer.parseInt(option) == 2) {
                    System.out.println("Please enter the index of the author to be updated.");
                    int index = Integer.parseInt(sc.nextLine());
                    Author aut = ac.getAuthor(index);
                    ac.update(aut, false);
                    System.out.println(aut);

            }
                else if (Integer.parseInt(option) == 3) {

                    System.out.println("Please enter the index of the author to be deleted.");
                    int index = Integer.parseInt(sc.nextLine());
                    ac.delete(index);

                }

                else if (Integer.parseInt(option) == 4) {
                    System.out.println("Please enter the index of the author.");
                    int index = Integer.parseInt(sc.nextLine());
                    ac.consacrat(index);

            }

            } else if (Integer.parseInt(option) == 3) {
                System.out.println("\nInsert option: \"1\": Add client; \"2\": " +
                        "Update client; \"3\": Delete client; \"4\": Check if client is retired;" +
                        " \"5\": Show sum of all taxes paid by a client; ");

                option = sc.nextLine();
                System.out.println("You inserted: " + option);
                if (Integer.parseInt(option) == 1) {
                    Client cl = cc.addClient();
                    System.out.println(cl);
                }
                else if (Integer.parseInt(option) == 2) {
                    System.out.println("Please enter the index of the client to be updated.");
                    int index = Integer.parseInt(sc.nextLine());
                    System.out.println("Please enter the new age.");
                    int age = Integer.parseInt(sc.nextLine());
                    Client cl = cc.getClient(index);
                    cc.update(cl, age);
                    System.out.println(cl);

                }
                else if (Integer.parseInt(option) == 3) {

                    System.out.println("Please enter the index of the client to be deleted.");
                    int index = Integer.parseInt(sc.nextLine());
                    cc.delete(index);

                }

                else if (Integer.parseInt(option) == 4) {
                    System.out.println("Please enter the index of the client.");
                    int index = Integer.parseInt(sc.nextLine());
                    cc.checkRetired(index);

                }
                else if (Integer.parseInt(option) == 5) {
                    System.out.println("Please enter the index of the client.");

                    int index = Integer.parseInt(sc.nextLine());
                    cc.sumaTotalaPlatita(index);


            }



            } else if (Integer.parseInt(option) == 4)
            {

                System.out.println("\nInsert option: \"1\": Add Loan; \"2\": Update Loan; \"3\": Delete Loan; \"4\":Type of Loan by number of books" +
                        " \"5\": Longest book in the loan; \"6\" All authors in a Loan");

                option = sc.nextLine();
                System.out.println("You inserted: " + option);
                if (Integer.parseInt(option) == 1) {

                    System.out.println("Please enter the index of the client.");
                    Client c = cc.getClient(Integer.parseInt(sc.nextLine()));
                    Date d1 = dc.addDate();
                    Date d2 = dc.addDate();
                    ArrayList<Book> list = new ArrayList<Book>();
                    System.out.println("Please enter the number of children books.");
                    int nrChildrenBooks = Integer.parseInt(sc.nextLine());
                    System.out.println("Please enter the number of fiction books.");
                    int nrFictionBooks = Integer.parseInt(sc.nextLine());
                    System.out.println("Please enter the number of non-fiction books.");
                    int nrNonFictionBooks = Integer.parseInt(sc.nextLine());
                    for (int i = 1; i <= nrChildrenBooks; i++) {
                        System.out.println("Please enter the index of children book .");
                        int index = Integer.parseInt(sc.nextLine());
                        list.add(cbc.getBook(index));
                    }
                    for (int i = 1; i <= nrFictionBooks; i++) {
                        System.out.println("Please enter the index of fiction book.");
                        int index = Integer.parseInt(sc.nextLine());
                        list.add(fbc.getBook(index));
                    }
                    for (int i = 1; i <= nrNonFictionBooks; i++) {
                        System.out.println("Please enter the index of non-fiction book.");
                        int index = Integer.parseInt(sc.nextLine());
                        list.add(nfbc.getBook(index));
                    }
                    System.out.println("\nInsert option: \"1\": Add Extended Loan; \"2\": Add Short Term Loan; ");

                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (Integer.parseInt(option) == 1) {
                        ExtendedLoan loan = elc.addLoan(c, d1, d2, list);
                        System.out.println(loan);
                    } else if (Integer.parseInt(option) == 2) {
                        ShortTermLoan loan = stlc.addLoan(c, d1, d2, list);
                        System.out.println(loan);
                    }
                } else if (Integer.parseInt(option) == 2) {
                    System.out.println("please select the type of loan you want to update");
                    System.out.println("\nInsert option: \"1\": Update Extended Loan; \"2\": Update Short Term Loan; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (Integer.parseInt(option) == 1) {
                        System.out.println("Please enter the index of the loan to be updated.");
                        int index = Integer.parseInt(sc.nextLine());
                        ExtendedLoan loan = elc.getLoan(index);
                        elc.update(loan,true);
                        System.out.println(loan);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the loan to be updated.");
                        int index = Integer.parseInt(sc.nextLine());
                        ShortTermLoan loan = stlc.getLoan(index);
                        lc.update(loan,true);
                        System.out.println(loan);
                    }


                } else if (Integer.parseInt(option) == 3) {
                    System.out.println("please select the type of loan you want to delete");
                    System.out.println("\nInsert option: \"1\": Delete Extended Loan; \"2\": Delete Short Term Loan; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);

                    if (Integer.parseInt(option) == 1) {
                        System.out.println("Please enter the index of the loan to be deleted.");
                        int index = Integer.parseInt(sc.nextLine());
                        elc.delete(index);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the loan to be deleted.");
                        int index = Integer.parseInt(sc.nextLine());
                        stlc.delete(index);
                    }

                } else if (Integer.parseInt(option) == 4) {

                    System.out.println("Please select the type of loan you want to use ");
                    System.out.println("\nInsert option: \"1\": Extended Loan; \"2\": Short Term Loan; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);

                    if (Integer.parseInt(option) == 1) {
                        System.out.println("Please enter the index of the loan ");
                        int index = Integer.parseInt(sc.nextLine());
                        elc.tipImprumut(index);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the loan ");
                        int index = Integer.parseInt(sc.nextLine());
                        stlc.tipImprumut(index);
                    }
                }
                else if (Integer.parseInt(option) == 5)
                {
                    System.out.println("Please select the type of loan you want to use ");
                    System.out.println("\nInsert option: \"1\": Extended Loan; \"2\": Short Term Loan; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);

                    if (Integer.parseInt(option) == 1) {
                        System.out.println("Please enter the index of the loan ");
                        int index = Integer.parseInt(sc.nextLine());
                        elc.longestBook(index);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the loan .");
                        int index = Integer.parseInt(sc.nextLine());
                        stlc.longestBook(index);
                    }
                }
                else if (Integer.parseInt(option) == 6)
                {
                    System.out.println("Please select the type of loan you want to use ");
                    System.out.println("\nInsert option: \"1\": Extended Loan; \"2\": Short Term Loan; ");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);

                    if (Integer.parseInt(option) == 1) {
                        System.out.println("Please enter the index of the loan ");
                        int index = Integer.parseInt(sc.nextLine());
                        elc.loanAuthors(index);
                    } else if (Integer.parseInt(option) == 2) {
                        System.out.println("Please enter the index of the loan ");
                        int index = Integer.parseInt(sc.nextLine());
                        stlc.loanAuthors(index);
                    }
                }



            }

            else if (Integer.parseInt(option) == 5) {

                System.out.println("Enter the name of the table you want to use: ");
                String tableName = sc.nextLine();
                System.out.println("Enter the name of the action you want to perform: ");
                String actionName = sc.nextLine();
                System.out.println(actionName);
                if(actionName == "CreateTable")
                    dbFunctions.CreateTable(con, tableName);
                else if(actionName.equals("Insert_Row") )
                {
                    System.out.println("Enter the string of values you want to insert separated by comma: ");
                    String values = sc.nextLine();
                    dbFunctions.Insert_Row(con, tableName, values);
                }
                else if(actionName == "Read_Table") {
                    dbFunctions.Read_Table(con, tableName);
                }
                else if(actionName == "Update_Single_Row"){
                    System.out.println("Enter the column name you want to update: ");
                    String columnName = sc.nextLine();
                    System.out.println("Enter the new value: ");
                    String newValue = sc.nextLine();
                    System.out.println("Enter the condtition for the row you want to update: ");
                    String condition = sc.nextLine();
                    dbFunctions.Update_Single_Row(con, tableName, columnName, newValue, condition);


                }
                else if(actionName == "Update_all_Rows") {
                    System.out.println("Enter the column name you want to update: ");
                    String columnName = sc.nextLine();
                    System.out.println("Enter the new value: ");
                    String newValue = sc.nextLine();
                    dbFunctions.Update_all_Rows(con, tableName, columnName, newValue);
                }
                else if (actionName == "Delete_Row")
                {
                    System.out.println("Enter the condtition for the row you want to delete: ");
                    String condition = sc.nextLine();
                    dbFunctions.Delete_Row(con, tableName, condition);
                }
                else if (actionName == "Delete_all_Rows")
                {
                    System.out.println("Are you sure you want to delete all rows from the table? (yes/no)");
                    String answer = sc.nextLine();
                    if(answer == "yes")
                        dbFunctions.Delete_all_Rows(con, tableName);
                    else
                        System.out.println("The rows were not deleted.");
                }
                else if (actionName == "Delete_Table")
                {
                    System.out.println("Are you sure you want to delete the table? (yes/no)");
                    String answer = sc.nextLine();
                    if(answer == "yes")
                        dbFunctions.Delete_Table(con, tableName);
                    else
                        System.out.println("The table was not deleted.");
                }


            }




        } while (!option.equals("stop"));
        sc.close();
    }
}