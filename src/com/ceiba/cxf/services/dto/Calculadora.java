package com.ceiba.cxf.services.dto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-10-25T12:04:18.052-05:00
 * Generated source version: 3.4.4
 *
 */

@WebService(targetNamespace = "http://service.ceiba.com/", name = "Calculadora")
@XmlSeeAlso({ObjectFactory.class})
public interface Calculadora {

    @WebMethod
    @RequestWrapper(localName = "suma", targetNamespace = "http://service.ceiba.com/", className = "com.ceiba.service.Suma")
    @ResponseWrapper(localName = "sumaResponse", targetNamespace = "http://service.ceiba.com/", className = "com.ceiba.service.SumaResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double suma(

        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1
    );
}
