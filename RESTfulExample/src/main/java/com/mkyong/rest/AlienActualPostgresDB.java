package com.mkyong.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AlienActualPostgresDB {

	Connection connection = null;
	
	public AlienActualPostgresDB() {
		//get 3 imp variable for DB
		String url 		= "jdbc:postgresql://127.0.0.1:5432/postgres";
		String username = "postgres";
		String password = "1234";
		
		//1. IMPORTANT : driver name ; mysql 
		//2. get connection
		
		try {
			Class.forName("org.postgresql.Driver");//search postgres driver name in google
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection to Postgres SQL server successfully..");
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public List<Alien> getList() {
		String SQL_SELECT = "select * from table1";
		List<Alien> listAliens = new LinkedList<Alien>();
		try {
			Statement st = connection.createStatement();
			
			ResultSet resultset = st.executeQuery(SQL_SELECT);
			
			while(resultset.next()) {
				Alien obj = new Alien();
				obj.setId(resultset.getInt(1));
				obj.setName(resultset.getString(2));
				listAliens.add(obj);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return listAliens;
	}

	public Alien createAlien(Alien a1) {
		
		String insert = "insert into table1 values (?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(insert);
			
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			
			st.executeUpdate();//execute insert : before that set its parameter if  we are using ? ? mark
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a1;
		
		
		
	}

}
