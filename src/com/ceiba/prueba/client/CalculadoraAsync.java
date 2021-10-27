package com.ceiba.prueba.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalculadoraAsync {
	
	double suma(double num1, double num2,  AsyncCallback<Double> callback) throws Exception;

}
