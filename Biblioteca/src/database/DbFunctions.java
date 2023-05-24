package database;
import service.AuditService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class DbFunctions {

    private static Connection conn;

    public DbFunctions()
    {

    }

    AuditService auditService = new AuditService();

    public static Connection getInstance(String dbname, String user, String password){
       if(conn == null) {
           try {
               Class.forName("org.postgresql.Driver");
               conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
               if (conn != null) {
                   System.out.println("Connected to the database");
               } else {
                   System.out.println("Failed to connect to the database");
               }
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
        return conn;
    }

    public void CreateTable (Connection conn, String table_name){
        try {
            if(table_name == "ChildrenBook") {
                String sql = "create table " + table_name + " (id serial primary key, title varchar(50), pageNumber int, assurance float, exemplare int, rating float, ageLimit int, illustrator varchar(50), isPopUpBook boolean, id_author int, foreign key (id_author) references Author(id))";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");
            }
            else if (table_name == "FictionBook")
            {
                String sql = "create table " + table_name + " (id serial primary key, title varchar(50), pageNumber int, assurance float, exemplare int, rating float, genre varchar(50), isBestseller boolean, id_author int, foreign key (id_author) references Author(id))";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");
            }
            else if (table_name == "NonFictionBook")
            {
                String sql = "create table " + table_name + " (id serial primary key, title varchar(50), pageNumber int, assurance float, exemplare int, rating float, topic varchar(50), edition int,  acolades varchar(100), id_author int, foreign key (id_author) references Author(id))";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");
            }
            else if (table_name == "Client") {

                String sql = "create table " + table_name + " (id serial primary key, firstName varchar(50), lastName varchar(50), age int, gender varchar(50), monthTaxes int, taxes varchar(200), monthLoans int, loans varchar(200))";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");
            }
            else if (table_name == "ShortTermLoan")
            {
                String sql = "create table " + table_name + " (id serial primary key, id_client int, foreign key (id_client) references Client(id), loanDate date, returnDate date, numberOfBooks int, books varchar(200), isReturned boolean, reason varchar(200))";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");

            }
            else if (table_name == "ExtendedLoan")
            {
                String sql = "create table " + table_name + " (id serial primary key, id_client int, foreign key (id_client) references Client(id), loanDate date, returnDate date, numberOfBooks int, books varchar(200), isReturned boolean, tax int, numberOfDays int)";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");


            }

            else if (table_name == "Author")
            {
                String sql = "create table " + table_name + " (id serial primary key, firstName varchar(50), lastName varchar(50),alive boolean, numberOfBooks int)";
                conn.createStatement().execute(sql);
                System.out.println("Table " + table_name + " created successfully");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Create Table " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
    }

    public void Insert_Row(Connection conn, String table_name, String values){
        try {
            String sql = "insert into " + table_name + " values (" + values + ")";
            conn.createStatement().execute(sql);
            System.out.println("Row inserted successfully into " + table_name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Insert Row into " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
    }

    public void Read_Table(Connection conn, String table_name){
        ResultSet input = null;
        try {
            String sql = "select * from " + table_name;
            input =  conn.createStatement().executeQuery(sql);
            while (input.next()) {
                if(table_name == "Author")
                System.out.println(input.getString(1) + " " + input.getString(2) + " " + input.getString(3) + " " + input.getString(4) + " " + input.getString(5) );
                if(table_name == "FictionBook" || table_name == "Client" || table_name == "ExtendedLoan")
                    System.out.println(input.getString(1) + " " + input.getString(2) + " " + input.getString(3) + " " + input.getString(4) + " " + input.getString(5) + " " + input.getString(6) + " " + input.getString(7) + " " + input.getString(8) + " " + input.getString(9) );
                if(table_name == "ChildrenBook" || table_name == "NonFictionBook" )
                    System.out.println(input.getString(1) + " " + input.getString(2) + " " + input.getString(3) + " " + input.getString(4) + " " + input.getString(5) + " " + input.getString(6) + " " + input.getString(7) + " " + input.getString(8) + " " + input.getString(9) + " " + input.getString(10) );
                if(table_name == "ShortTermLoan")
                    System.out.println(input.getString(1) + " " + input.getString(2) + " " + input.getString(3) + " " + input.getString(4) + " " + input.getString(5) + " " + input.getString(6) + " " + input.getString(7) + " " + input.getString(8) );
            }
            System.out.println("Table " + table_name + " read successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Read from table " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
    }

    public void Update_Single_Row(Connection conn, String table_name, String column, String value, String condition){
        try {
            String sql = "update " + table_name + " set " + column + " = " + value + " where " + condition;
            conn.createStatement().execute(sql);
            System.out.println("Table " + table_name + " updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Update Row in " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }

    }

    public void Update_all_Rows(Connection conn, String table_name, String column, String value){
        try {
            String sql = "update " + table_name + " set " + column + " = " + value;
            conn.createStatement().execute(sql);
            System.out.println("Table " + table_name + " updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Update all Rows in " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
    }

    public void Delete_Row(Connection conn, String table_name, String condition){
        try {
            String sql = "delete from " + table_name + " where " + condition;
            conn.createStatement().execute(sql);
            System.out.println("Row deleted successfully from " + table_name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Delete Row from " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }

    }

    public void Delete_Table(Connection conn, String table_name){
        try {
            String sql = "drop table " + table_name;
            conn.createStatement().execute(sql);
            System.out.println("Table " + table_name + " deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Delete Table " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }

    }

    public void Delete_all_Rows (Connection conn, String table_name){
        try {
            String sql = "delete from " + table_name;
            conn.createStatement().execute(sql);
            System.out.println("All rows deleted successfully from " + table_name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            auditService.addAction("Delete all Rows from " + table_name);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the action: " + e.getMessage());
        }
    }

}
