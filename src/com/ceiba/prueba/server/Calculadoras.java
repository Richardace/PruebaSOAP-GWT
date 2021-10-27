package com.ceiba.prueba.server;

import com.ceiba.cxf.services.dto.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class Calculadoras extends RemoteServiceServlet implements com.ceiba.cxf.services.dto.Calculadora{

	@Override
	public double suma(double arg0, double arg1) {
		CalculadoraImplService calculadoraService = new CalculadoraImplService();
    	Calculadora consumer = calculadoraService.getCalculadoraImplPort();
		return 0;
	}

}
