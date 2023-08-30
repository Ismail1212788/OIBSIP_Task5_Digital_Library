/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kali-i
 */
public class db {
    
    boolean flag=false;

    public db(){
       try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","root")) {
                
                Statement stmt=con.createStatement();
                flag=true;    
    
    }
catch(Exception e){ 
    flag=false;
    JOptionPane.showMessageDialog(null,"Database not Connected","Error",1);
}  
    }  
    
public boolean check(){
    return flag;
}    

public void addReader(String a,String b,String c) throws SQLException{
    String query="INSERT INTO readers (ID, Name, Pass) VALUES ('"+a+"', '"+b+"', '"+c+"');";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
                
                Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Reader added successfully","Done",1);
    
    }
catch(Exception e){ JOptionPane.showMessageDialog(null,"Already user found","Error",1);

}  

    }  

public void addManager(String a,String b,String c) throws SQLException{
    String query="INSERT INTO Manager (ID, Name, Pass) VALUES ('"+a+"', '"+b+"', '"+c+"');";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
                Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                                JOptionPane.showMessageDialog(null,"Manager added successfully","Done",1);
    
    }
catch(Exception e){ 
JOptionPane.showMessageDialog(null,"Already Manager found","Error",1);}  

    }  

public void addBook(String a,String b,String c) throws SQLException{
    String query="INSERT INTO Books (ID, Name, author) VALUES ('"+a+"', '"+b+"', '"+c+"');";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                                JOptionPane.showMessageDialog(null,"Book added successfully","Done",1);
    
    }
catch(Exception e){ 
JOptionPane.showMessageDialog(null,"Already Book found","Error",1);
}  

    }  

public Reader_obj searchReader(String id){
 Reader_obj obj=new Reader_obj();
      String query="select * from readers where ID like '"+id+"';";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                 ResultSet rs = stmt.executeQuery(query);
                 
                 while(rs.next()){
         
            obj.ID=rs.getString("ID");
            obj.Pass=rs.getString("Pass");
            obj.name=rs.getString("Name");
         
                 }
    }
catch(Exception e){ 
System.out.println(e);    
JOptionPane.showMessageDialog(null,"Reader not found","Error",1);
}
return obj;
}

public Book_obj searchBook(String id){
    Book_obj obj=new Book_obj();
      String query="select * from Books where ID like '"+id+"';";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                 ResultSet rs = stmt.executeQuery(query);
                 
                 while(rs.next()){
         
            obj.ID=rs.getString("ID");
            obj.name=rs.getString("Name");
            obj.author=rs.getString("author");  
          
                 }
    }
catch(Exception e){ 
System.out.println(e);    

}
  return obj;
}

public Manager_obj searchManager(String id){
 Manager_obj obj=new Manager_obj();
      String query="select * from Manager where ID like '"+id+"';";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                 ResultSet rs = stmt.executeQuery(query);
                 
                 while(rs.next()){
         
            obj.ID=rs.getString("ID");
            obj.Pass=rs.getString("Pass");
            obj.name=rs.getString("Name");
         
                 }
    }
catch(Exception e){ 
System.out.println(e);    
}
return obj;
}

public void deleteReader(String id){
     
      String sql="delete from readers where ID like '"+id+"';";
    System.out.println(sql);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                                  stmt.executeUpdate(sql);
    }
catch(Exception e){ 
System.out.println(e);    
}
}

public void deleteBook(String id){
     
      String sql="delete from Books where ID like '"+id+"';";
    System.out.println(sql);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                                  stmt.executeUpdate(sql);
    }
catch(Exception e){ 
System.out.println(e);    
}
}

public void deleteManager(String id){
     
      String sql="delete from Manager where ID like '"+id+"';";
    System.out.println(sql);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                                  stmt.executeUpdate(sql);
    }
catch(Exception e){ 
System.out.println(e);    
}
}

public void borrowBook(String a,String b,String c){
 
       String query="INSERT INTO Borrow (bID, BookName, BorrowerName) VALUES ('"+a+"', '"+c+"', '"+b+"');";
    System.out.println(query);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                                JOptionPane.showMessageDialog(null,"Book borrowed successfully","Done",1);
    
    }
catch(Exception e){ 

}  
    
    
    
}


public void returnBook(String id){
     
      String sql="delete from Borrow where bID like '"+id+"';";
    System.out.println(sql);
    try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library","root","PASSWORD")) {
 
                Statement stmt=con.createStatement(); 
                                  stmt.executeUpdate(sql);
    }
catch(Exception e){ 
JOptionPane.showMessageDialog(null,"Borrow ID not found","Error",1);
}
}


} 



    
    

