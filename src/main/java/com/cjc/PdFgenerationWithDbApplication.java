package com.cjc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@SpringBootApplication
public class PdFgenerationWithDbApplication {

public static void main(String[] args) throws FileNotFoundException, DocumentException, SQLException 
{
 SpringApplication.run(PdFgenerationWithDbApplication.class, args);
 String filename="D:\\demo.pdf";
  Document document=new Document();
 	PdfWriter.getInstance(document,new FileOutputStream(filename));
	document.open();
	
	DB_connection dc=new DB_connection();
	Connection connection=dc.get_connection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String query="select * from employee";
	ps=connection.prepareStatement(query);
	
	rs=ps.executeQuery();
	while(rs.next()) {
		Paragraph para=new Paragraph("empid"+rs.getByte("empid")+"ename"+rs.getString("ename")+
				   "uname"+rs.getString("uname")+"password"+rs.getString("password"));
	document.add(para);
	document.add(new Paragraph("  "));
	
	}
	document.close();
	System.out.println("hiii");	
	}
}
