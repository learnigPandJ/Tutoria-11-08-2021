package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;

import javafx.collections.*;

import modelos.Crud;
import modelos.Respuestas;

import javax.swing.JOptionPane;

public class controller_vista_crud {

    private ObservableList<String> itemsSeleccion =  FXCollections.observableArrayList("Materia","Nombre");

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
    private ChoiceBox<String> eleccion_a_borrar;

    @FXML
    private TextField datoa_a_borrar;

    @FXML
    private Button btn_borrar;

    @FXML
    private Button btn_actualizar;

    @FXML
    private TextField act_nombre;

    @FXML
    private Label Nombre;

    @FXML
    private TextField act_genero;

    @FXML
    private TextField act_materia;

    @FXML
    private TextField act_nota;

    @FXML
    private Button btn_buscar_act;

    @FXML
    private TextField id_asistente;

    
    @FXML
    private Button btn_busqueda;

    @FXML
    private TextField nombre_busc;

    @FXML
    private TextField materia_busc;

    @FXML
    private TextArea result_busqueda;

    @FXML
    private void initialize(){
        eleccion_a_borrar.setItems(itemsSeleccion);
    }

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

    @FXML
    void onBorrar(ActionEvent event) {
        Crud crud = new Crud();

        String accionSeleccionada = eleccion_a_borrar.getValue();
        String datoaborrar = datoa_a_borrar.getText();
        System.out.println(accionSeleccionada);
        crud.borrarDatos(datoaborrar,accionSeleccionada);

    }

    @FXML
    void onBuscarAsistente(ActionEvent event) {
        Crud crud = new Crud();

        String id = id_asistente.getText();

        if(!id.equals("")){
        String [] datos =  crud.leerDatosAsistente(Integer.parseInt(id));
        if(datos.length == 4){
        act_nombre.setText(datos[0]);
        act_genero.setText(datos[1]);
        act_materia.setText(datos[2]);
        act_nota.setText(datos[3]);
        }else{
            JOptionPane.showMessageDialog(null, "No hay registros con el id indicado");
        }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un id");
        }
    }
    @FXML
    void onActualizar(ActionEvent event) {
        Crud crud = new Crud();
       String nombre= act_nombre.getText();
        int genero = Integer.parseInt(act_genero.getText());
        String materia = act_materia.getText();
       float nota = Float.parseFloat(act_nota.getText());
       int id = Integer.parseInt(id_asistente.getText());
        crud.actualizarRegistros(nombre,genero,materia,nota,id);
    }


    @FXML
    void onBuscarDato(ActionEvent event) {

        Crud crud =  new Crud();
        String  nombreb = nombre_busc.getText();
        String materiab = materia_busc.getText();

        result_busqueda.setText(crud.busquedadeDatos(nombreb,materiab));

    }

}


