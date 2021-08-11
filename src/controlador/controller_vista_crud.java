package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import modelos.Crud;

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
    void guardar_registro(ActionEvent event) {
        Crud crud = new Crud();

        String nombre = this.nombre.getText(); 
        int genero =  Integer.parseInt(this.genero.getText());
        String materia =  this.materia.getText();
        float nota =  Float.parseFloat(this.nota.getText());
        crud.insertarDatos(nombre,genero,materia,nota);
    }

}


