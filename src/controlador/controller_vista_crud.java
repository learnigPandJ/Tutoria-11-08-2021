package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

import modelos.Crud;
import modelos.Respuestas;

public class controller_vista_crud {

    @FXML
    private Button btn_save;

    @FXML
    private TextField nombre;

    @FXML
    private TextField genero;

    @FXML
    private TextField materia;

    @FXML
    private TextField nota;

    
    @FXML
    private Button btn_cargar;

    @FXML
    private TextArea txt_info_leida;

    @FXML
    private Button btn_calcular;

    @FXML
    private Label result1_txtfield;

    @FXML
    private Label result2_txtfield;

    @FXML
    void guardar_registro(ActionEvent event) {
        Crud crud = new Crud();

        String nombre = this.nombre.getText(); 
        int genero =  Integer.parseInt(this.genero.getText());
        String materia =  this.materia.getText();
        float nota =  Float.parseFloat(this.nota.getText());
        crud.insertarDatos(nombre,genero,materia,nota);
    }

    @FXML
    void calcular_resultados(ActionEvent event) {
        Respuestas rsp =  new Respuestas();

        String datos =  txt_info_leida.getText();

        rsp.leerDatos(datos);

        result1_txtfield.setText(rsp.respuesta1());
        result2_txtfield.setText(rsp.respuesta2());


    }


    @FXML
    void leerInformacion(ActionEvent event) {
        Crud crud = new Crud();
        txt_info_leida.setText(crud.leerDatos());
    }

}


