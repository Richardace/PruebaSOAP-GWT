package com.ceiba.prueba.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("BD")
public interface BD extends RemoteService {
	List<com.ceiba.prueba.shared.Alumno> getAlumnos() throws IllegalArgumentException, Exception;
	String eliminarAlumnos(String id) throws Exception;
	String insertarAlumnos(String nombres, String apellidos, String seccion, String curso ) throws Exception;
}
