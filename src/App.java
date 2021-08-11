import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage escenario)throws IOException{
        FXMLLoader vista =  new FXMLLoader(getClass().getResource("/vistas/vista_crud.fxml"));

        Parent root= vista.load();
        Scene escena =  new Scene(root);


        escenario.setScene(escena);
        escenario.setTitle("CRUD");
        escenario.show();

    }
}
