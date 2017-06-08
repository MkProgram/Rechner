package Calc;
import java.sql.*;
public class DbHelper {
	private String url = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String passwort = "";
	Connection con;
	public DbHelper()
	{
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.con = DriverManager.getConnection(this.url, this.user, this.passwort);
			
			Statement stt = con.createStatement();
			
			//Create and select db
			stt.execute("CREATE DATABASE IF NOT EXISTS Rechner");
			stt.execute("USE Rechner");
			
			// Create out Table
			stt.execute("CREATE TABLE IF NOT EXISTS history (" +
					"id BIGINT NOT NULL AUTO_INCREMENT,"+
					"value1 BIGINT NOT NULL,"+
					"value2 BIGINT NOT NULL,"+
					"operator VARCHAR(5) NOT NULL,"+
					"PRIMARY KEY(id)"
					+")" );
			/*stt.execute("INSERT INTO history (value1, value2, operator) VALUES" + 
					"(1, 2, '+'), (3,2,'-')");*/
			//ResultSet res = stt.executeQuery("SELECT * FROM history ORDER BY id LIMIT 5");
			
			/*while(res.next())
			{
				System.out.println(res.getString("value1")+ " "+ res.getString("operator") + " " + res.getString("value2") );
			}*/
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void pushDB(int val1, int val2, char operator)
	{
		try
		{
			Statement stt = this.con.createStatement();
			
			String sVal1 = String.valueOf(val1);
			String sVal2 = String.valueOf(val2);
			String sOperator = String.valueOf(operator);
			
			stt.execute("INSERT INTO history (value1, value2, operator) VALUES" + 
					"("+sVal1+", "+sVal2+", '"+sOperator+"')");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ResultSet getHistory()
	{
		ResultSet res = null;
		try
		{
			Statement stt = this.con.createStatement();
			res = stt.executeQuery("SELECT * FROM history ORDER BY id DESC LIMIT 5");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
