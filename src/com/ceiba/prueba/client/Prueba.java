package com.ceiba.prueba.client;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.prueba.server.Calculadora;
import com.ceiba.prueba.server.CalculadoraImplService;
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
	private final BDAsync BDService = GWT.create(BD.class);

	public void onModuleLoad() {
		//Controls
				final TextBox SelectField = new TextBox();
				Button btnSeleccionar = new Button("Seleccionar");
				Button btnEliminar = new Button("Eliminar");
				Button btnGuardar = new Button("Guardar");
				Button btnRefrescar = new Button("Refrescar");
				final TextBox txtNombres = new TextBox();
				final TextBox txtApellidos = new TextBox();
				
				//Table
				CellTable<Alumno> CeldaAlumno = CrearCellTable();
				//Selected Table Event
				final SingleSelectionModel<Alumno> Modelo = new SingleSelectionModel<Alumno>();
				CeldaAlumno.setSelectionModel(Modelo);
				Modelo.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {		 
				      public void onSelectionChange(SelectionChangeEvent event) {		 
				        Alumno AlumnoSelecionado = Modelo.getSelectedObject();
				        if (AlumnoSelecionado != null) {	
				        	btnSeleccionar.click();
				        }
				      }
				    });  
				
				
				   //Handlers:
			    btnRefrescar.addClickHandler( new ClickHandler() {
			        public void onClick(ClickEvent event) {
			        	// Call BD
			        	BDService.getAlumnos(new AsyncCallback<List<Alumno>>() {
			    			@Override
			    			public void onFailure(Throwable caught) {				
			    			}
			    			@Override
			    			public void onSuccess(List<Alumno> result) {
			    				CeldaAlumno.setRowCount(result.size(), true);
			    			    CeldaAlumno.setRowData(0, result);				
			    			}
			    			  
			    		  });
			        }
			      });
			    
			    btnSeleccionar.addClickHandler( new ClickHandler() {
			        public void onClick(ClickEvent event) {
			        	SelectField.setText(String.valueOf(Modelo.getSelectedObject().getId()));
			        }
			      });
			    
			    btnEliminar.addClickHandler( new ClickHandler() {
			        public void onClick(ClickEvent event) {
			        	String id =SelectField.getText();
			        	try {
							BDService.eliminarAlumnos(id,new AsyncCallback<String>() {
								@Override
								public void onFailure(Throwable caught) {							
								}
								@Override
								public void onSuccess(String result) {	
									 btnRefrescar.click();
								}					 						  
							  });
						} catch (Exception e) {
							e.printStackTrace();
						}
			        }
			      });
	
			    btnGuardar.addClickHandler( new ClickHandler() {
			        public void onClick(ClickEvent event) {
			        	String nombres =txtNombres.getText();
			        	String apellidos =txtApellidos.getText();
			        	GWT.log("hola");
			        	
			        	
			        	
//			        	CalculadoraImplService prueba = new CalculadoraImplService();
//			        	Calculadora calc = prueba.getCalculadoraImplPort();
			        	
			        	
//			        	Calculadora calc = GWT.create(CalculadoraImplService.class);
//			        	double suma = calc.suma(2, 2);
			        	
			        	try {
							BDService.insertarAlumnos(nombres,apellidos,"agregarSeccion","agregarCurso",new AsyncCallback<String>() {
								@Override
								public void onFailure(Throwable caught) {							
								}
								@Override
								public void onSuccess(String result) {	
									 btnRefrescar.click();
									 txtNombres.setText("");
									 txtApellidos.setText("");
								}					 						  
							  });
						} catch (Exception e) {
							e.printStackTrace();
						}
			        }
			      });
			    
			   
			  //Panel Table
			    VerticalPanel panelTabla = new VerticalPanel();
			    panelTabla.add(CeldaAlumno);
			    panelTabla.setBorderWidth(1);
			    
			    
			    RootPanel.get("SelectField").add(SelectField);	
				RootPanel.get("tabla").add(panelTabla);
				RootPanel.get("ButtonSeleccionar").add(btnSeleccionar);
				
				RootPanel.get("ButtonEliminiar").add(btnEliminar);
				RootPanel.get("ButtonRefrescar").add(btnRefrescar);
				RootPanel.get("txtNombres").add(txtNombres);
				RootPanel.get("txtApellidos").add(txtApellidos);
				RootPanel.get("ButtonGuardar").add(btnGuardar);
				  btnRefrescar.click();
				SelectField.setFocus(true);
				SelectField.selectAll();	
			    
	}
	
	//Create Table 
		public CellTable<Alumno> CrearCellTable(){
			CellTable<Alumno> CeldaAlumno = new CellTable<Alumno>();
			CeldaAlumno.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		    
			 TextColumn<Alumno> ColumId = new TextColumn<Alumno>() {
			      @Override
			      public String getValue(Alumno object) {
			        return  String.valueOf(object.getId());
			      }
			    };
			CeldaAlumno.addColumn(ColumId, "ID");
			
			TextColumn<Alumno> ColumNombre = new TextColumn<Alumno>() {
			      @Override
			      public String getValue(Alumno object) {
			        return object.getNombres();
			      }
			    };
		    CeldaAlumno.addColumn(ColumNombre, "NOMBRES");
		    
		    TextColumn<Alumno> ColumApellido = new TextColumn<Alumno>() {
			      @Override
			      public String getValue(Alumno object) {
			        return object.getApellidos();
			      }
			    };
		    CeldaAlumno.addColumn(ColumApellido, "APELLIDOS"); 
		    return CeldaAlumno;
		}
}
