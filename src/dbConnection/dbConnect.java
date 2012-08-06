/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vm
 */
public class dbConnect {

	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String url = "jdbc:odbc:/home/vm/Desktop/locaties.mdb";
	String username = "";
	String password = "";
	String query = "SELECT * FROM Locatiegegevens";

	public void executeQuery() {

			try {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, "","");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				System.out.println(rs);
			} catch (Exception ex) {
				Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("\nError: " + ex.toString() + ex.getMessage());
				
			}
		}

	

	}

