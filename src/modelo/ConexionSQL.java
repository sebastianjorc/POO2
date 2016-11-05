package modelo;

import java.sql.*;
import java.util.Calendar;

public class ConexionSQL {
	private Connection con;

	public void connect(){
		 try
		    {
		    // create a mysql database connection
		    String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/poo2";
		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, "root", "");		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
	}
	
	public void insertar(String user, String tipo, int pts){
		connect();
	      // create a sql date object so we can use it in our INSERT statement
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

	      // the mysql insert statement
	      String query = " insert into partida (user, tipo, fecha, pts)"
	        + " values (?, ?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, user);
	      preparedStmt.setString (2, tipo);
	      preparedStmt.setDate   (3, startDate);
	      preparedStmt.setInt    (4, pts);
	      preparedStmt.execute();
		con.close();
		} catch (SQLException e) {
			System.out.println("Error al incertar");
			System.out.println("Error: "+e);
			e.printStackTrace();
		}
	}

	public void close(){
	    if(con != null){
	        try {
	            con.close();
	        } catch (SQLException e) {
		        System.out.println("no close");
	            e.printStackTrace();
	        }
	    }
	}
	

	public String consulta(String user){
		String srt = null;    	String aux = null;
		Statement s = null;		ResultSet rs = null;
		System.out.print(user);
		try {
			connect();
			s = con.createStatement();	
			if (user==null)
					rs = s.executeQuery ("select * from partida ORDER BY pts DESC");
			else	rs = s.executeQuery ("select * from partida WHERE user = '"+user+"' ORDER BY pts DESC");
	    	while (rs.next()){  
	    		aux=srt;
	    		if(aux!=null)srt=aux+"            \n"+(rs.getString (1) + " " 
	    		+ rs.getString (2)+ " " + rs.getDate(3)+ " " + rs.getInt(4));
	    		else {srt=(rs.getString (1) + " " + rs.getString (2)+ " " + rs.getDate(3)+ " " + rs.getInt(4));}
			}
			con.close();
		} catch (Exception e1) {
			System.out.println("Error: "+e1); 
			e1.printStackTrace();
		}
		return srt;
	}
}