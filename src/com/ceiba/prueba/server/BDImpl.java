package com.ceiba.prueba.server;

import com.ceiba.prueba.client.BD;
import com.ceiba.prueba.shared.Alumno;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class BDImpl extends RemoteServiceServlet implements BD {
    
	public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("FALLO RARO");
            return null;
        }
    }

	
	public List<Alumno> getAlumnos() throws  Exception {
    	List<Alumno>  listadoAlumnos = new  ArrayList<Alumno>() ;
    	 
        ResultSet Resultado = null;
        try {
            String Consulta = "SELECT id, nombres, apellidos, seccion, curso  FROM alumno";
            PreparedStatement ps = getConnection().prepareStatement(Consulta);
            Resultado = ps.executeQuery();
      
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
        
        if (Resultado !=null)
        {
        	while(Resultado.next())
        	{
        		Alumno objAlumno;
        		objAlumno= new Alumno(Integer.parseInt( Resultado.getString("id")),
        							Resultado.getString("nombres"),
        							Resultado.getString("apellidos"),
        							Resultado.getString("seccion"),
        							Resultado.getString("curso")
        							);
        		
        		listadoAlumnos.add(objAlumno);
        	}
        	
        }
        return listadoAlumnos;
    }

	public String eliminarAlumnos(String id) throws  Exception {
	 
	        try {
	            String Consulta = "DELETE FROM alumno WHERE id=?";
	            PreparedStatement ps = getConnection().prepareStatement(Consulta);
	            ps.setString(1, id);
	            ps.executeUpdate();
	      
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        } finally {
	            if (getConnection() != null) {
	                getConnection().close();
	            }
	        }
			return "1";
	}
	public String insertarAlumnos(String nombres, String apellidos,String seccion, String curso) throws  Exception {
		 
        try {
            String Consulta = "INSERT INTO alumno (nombres,apellidos,seccion,curso) VALUES (?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(Consulta);
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, seccion);
            ps.setString(4, curso);
            ps.executeUpdate();
      
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
		return "1";
}
}
