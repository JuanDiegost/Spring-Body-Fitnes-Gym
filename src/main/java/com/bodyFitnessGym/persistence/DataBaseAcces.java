package com.bodyFitnessGym.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseAcces {

	private Connection connection;
	private Statement statement;

	//----------------Patron Singleton----------------------------------------------------------------
	private static DataBaseAcces dataBaseAcces;
	private DataBaseAcces() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://insidebd.cmbvx7mf6nku.us-west-1.rds.amazonaws.com/insidebd?" + "user=insideroot&password=insideroot&serverTimezone=UTC");
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static DataBaseAcces getInstance() {
		if (dataBaseAcces == null) {
			dataBaseAcces = new DataBaseAcces();
		}
		return dataBaseAcces;
	}
	//--------------Fin del patron Singleton----------------------------------------------------------------

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}