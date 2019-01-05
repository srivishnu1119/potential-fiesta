package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Question {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Claim Type :");
		String Accident=scan.next();
		String qID=null;
		String answer=null;
		String question=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","venbatch","venbatch");
		switch(Accident) {
		case "earthquake":
			PreparedStatement pS=con.prepareStatement("select question,questionid from question where claim_type='"+Accident+"'");
			ResultSet rs=pS.executeQuery();
			while(rs.next())
			{
				question=rs.getString(1);
				qID=rs.getString(2);
				System.out.println(question);
				System.out.println("1.yes  2.no");
				int num=scan.nextInt();
				switch(num)
				{
				case 1:
					answer="yes";
					break;
				case 2:
					answer="no";
					break;
				}
				PreparedStatement ps=con.prepareStatement("insert into report values(?,?,?)");
				ps.setString(1,qID);
				ps.setString(2,question);
				ps.setString(3,answer);
				ps.executeUpdate();
				qID=null;
				question=null;
				answer=null;
			}
			break;
			
		case "cyclone":
			PreparedStatement pS1=con.prepareStatement("select question,questionid from question where claim_type='"+Accident+"'");
			ResultSet rs1=pS1.executeQuery();
			while(rs1.next())
			{
				question=rs1.getString(1);
				qID=rs1.getString(2);
				System.out.println(question);
				System.out.println("1.yes  2.no");
				int num=scan.nextInt();
				switch(num)
				{
				case 1:
					answer="yes";
					break;
				case 2:
					answer="no";
					break;
				}
				PreparedStatement ps2=con.prepareStatement("insert into report values(?,?,?)");
				ps2.setString(1,qID);
				ps2.setString(2,question);
				ps2.setString(3,answer);
				ps2.executeUpdate();
				qID=null;
				question=null;
				answer=null;
							
			}
			break;
			
		case "fire":
			PreparedStatement pS2=con.prepareStatement("select question,questionid from question where claim_type='"+Accident+"'");
			ResultSet rs2=pS2.executeQuery();
			while(rs2.next())
			{
				question=rs2.getString(1);
				qID=rs2.getString(2);
				System.out.println(question);
				System.out.println("1.yes  2.no");
				int num=scan.nextInt();
				switch(num)
				{
				case 1:
					answer="yes";
					break;
				case 2:
					answer="no";
					break;
				}
				PreparedStatement ps3=con.prepareStatement("insert into report values(?,?,?)");
				ps3.setString(1,qID);
				ps3.setString(2,question);
				ps3.setString(3,answer);
				ps3.executeUpdate();
				qID=null;
				question=null;
				answer=null;
							
			}
			break;
		
		}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}