package modelos;

public class Respuestas extends PadreRespuestas{

    public void leerDatos(String datos){
        String [] datosDivididos1 = datos.split("\n");
        this.matrizdedatos = new String [datosDivididos1.length][4];

        for(int i=0;i<datosDivididos1.length;i++){
            String [] datosDivididos2 = datosDivididos1[i].split(" ");

            for(int j=0;j<datosDivididos2.length;j++){
                matrizdedatos[i][j] = datosDivididos2[j];
            }
        }
    }
    
}
