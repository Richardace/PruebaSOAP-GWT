package com.ceiba.prueba.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CALCULADORA")
public interface Calculadora extends RemoteService{
	
	double suma(double num1, double num2) throws Exception;

}
