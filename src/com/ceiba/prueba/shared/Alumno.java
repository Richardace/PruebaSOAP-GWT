package com.ceiba.prueba.shared;

import java.io.Serializable;



public class Alumno   implements Serializable   {
	private int Id;
	private String Nombres;
	private String Apellidos;
	private String Seccion;
	private String Curso;
	
	public Alumno(){
		
	}
	
	public Alumno (int id, String nombres, String apellidos, String seccion, String curso)
	{
		Id=id;
		Nombres=nombres;
		Apellidos=apellidos;
		Seccion = seccion;
		Curso = curso;
	}
	  public int getId() {
	        return Id;
	    }

	    public void setId(int Id) {
	        this.Id = Id;
	    }

	    public String getNombres() {
	        return Nombres;
	    }

	    public void setNombres(String Nombres) {
	        this.Nombres = Nombres;
	    }

	    public String getApellidos() {
	        return Apellidos;
	    }

	    public void setApellidos(String Apellidos) {
	        this.Apellidos = Apellidos;
	    }

	    public String getSeccion() {
	        return Seccion;
	    }

	    public void setSeccion(String Seccion) {
	        this.Seccion = Seccion;
	    }

	    public String getCurso() {
	        return Curso;
	    }

	    public void setCurso(String curso) {
	        this.Curso = curso;
	    }

}
