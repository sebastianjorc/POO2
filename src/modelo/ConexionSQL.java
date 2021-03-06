package modelo;

import java.sql.*;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**Clase encargada de realizar la conexi�n con el servidor.
 */
public class ConexionSQL {
	private Connection con;

	/**Realiza conexi�n con el servidor.
	 */
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
	
	/** Inserta datos al servidor
	 * @param user : usuario a ingresar a la tabla.
	 * @param tipo : tipo de partida a ingresar a la tabla.
	 * @param pts  : pts a ingresar a la tabla.
	 */
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

	/** Cierra la conexi�n con el servidor 
	 */
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
	

	/** Realiza las consultas al servidor, est�s pueden ser por usuario y tipo � solo tipo.
	 * @param user : id del usuario a consultar
	 * @param tipo : id del tipo a consultar
	 * @return devuelve un JTable con los datos recividos de la consulta.
	 */
	public JTable consulta(String user, String tipo){
		JTable tabla = null;	Statement s = null;		ResultSet rs = null;

		try {
			connect();
			s = con.createStatement();	
			if (user==null)
					rs = s.executeQuery ("select * from partida WHERE tipo = '"+tipo+"' ORDER BY pts DESC");
			else	rs = s.executeQuery ("select * from partida WHERE user = '"+user+"' AND tipo = '"+tipo+"' ORDER BY pts DESC");
			DefaultTableModel modelo = new DefaultTableModel();
			tabla = new JTable(modelo);	modelo.addColumn("Fecha");
			modelo.addColumn("User");	modelo.addColumn("Puntos");
			
	    	while (rs.next()){
	    		modelo.addRow(new Object[] { rs.getString(3),rs.getString(2),rs.getInt(4) } );}
	    	
		} catch (Exception e1) {
			System.out.println("Error: "+e1); 
			e1.printStackTrace();
		}
		return tabla;
	}
}