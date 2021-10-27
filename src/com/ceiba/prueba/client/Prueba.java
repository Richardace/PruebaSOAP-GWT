package com.ceiba.prueba.client;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cxf.services.dto.Calculadora;
import com.ceiba.cxf.services.dto.CalculadoraImplService;
import com.ceiba.prueba.shared.Alumno;
import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Prueba implements EntryPoint {
	
	private final CalculadoraImplService BDService = GWT.create(Calculadora.class);

	public void onModuleLoad() {
		//Controls
				Button btnSumar = new Button("Sumar");
				final TextBox num1 = new TextBox();
				final TextBox num2 = new TextBox();
				

			    btnSumar.addClickHandler( new ClickHandler() {
			        public void onClick(ClickEvent event) {
			        	String nombres =num1.getText();
			        	String apellidos =num2.getText();
			        	
			        }
			      });
			    
			   
			  RootPanel.get("txtNum1").add(num1);
				RootPanel.get("txtNum2").add(num2);
				RootPanel.get("ButtonGuardar").add(btnSumar);
			    
	}
	
}
