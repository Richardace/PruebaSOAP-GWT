package com.ceiba.prueba.client;

import java.util.List;

import com.ceiba.prueba.shared.Alumno;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface BDAsync {
	void getAlumnos (  AsyncCallback<List<Alumno>> callback) throws IllegalArgumentException;
	void eliminarAlumnos (String id,  AsyncCallback<String> callback) ;
	void insertarAlumnos (String  nombres, String apellidos, String seccion, String curso,  AsyncCallback<String> callback) ;
}
