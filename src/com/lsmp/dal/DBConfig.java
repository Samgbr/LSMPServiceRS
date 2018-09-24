package com.lsmp.dal;

/**
 * This class is responsible for the MySql DB Configuration on AWS Cloud model class
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
		username="mpuser1";
		password="db$User1";
		databaseURL="lsmpdb.cq2czhcgvi8n.us-east-2.rds.amazonaws.com:3306";
		databaseName="LSMPServiceRS";
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
