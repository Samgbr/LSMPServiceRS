package com.lsmp.dal;

/**
 * This class is responsible for the MySql DB Configuration on AWS Cloud model class
 * Used stack-overflow knowledge base link 
 * "https://stackoverflow.com/questions/8146793/no-suitable-driver-found-for-jdbcmysql-localhost3306-mysql" for URL
 * and for setting the class path:
 * "https://stackoverflow.com/questions/8946088/set-default-classpath-to-use-in-java-command-in-command-prompt"
 * @author samzi
 *
 */

public class DBConfig {

	//Credentials will be created as instances
	private String username;
	private String password;
	private String databaseURL;
	private String databaseName;
	
	public DBConfig(){
		username="User1";
		password="dbUser1";
		databaseURL="jdbc:mysql://localhost:3306";
		databaseName="lsmpservicers";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseURL() {
		return databaseURL+"/"+getDatabaseName();
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
}
