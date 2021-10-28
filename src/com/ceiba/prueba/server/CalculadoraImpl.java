package com.ceiba.prueba.server;

import com.ceiba.prueba.client.Calc;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class CalculadoraImpl extends RemoteServiceServlet implements Calc{

	@Override
	public double suma(double arg0, double arg1) {
//		CalculadoraImplService calculadoraService = new CalculadoraImplService();
//    	Calculadora consumer = calculadoraService.getCalculadoraImplPort();
		return 0;
	}

}
