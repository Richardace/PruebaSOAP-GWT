package com.ceiba.prueba.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CALCULADORA")
public interface Calculadora {
	
	double suma(double num1, double num2) throws Exception;

}
