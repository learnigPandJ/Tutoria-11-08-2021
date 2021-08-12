package modelos;

public class PadreRespuestas {
    protected String [][] matrizdedatos;

    public String respuesta1(){
        String nombre= matrizdedatos[0][0];

        float notaMayor = Float.parseFloat(matrizdedatos[0][3]);

        for(int i=0;i<matrizdedatos.length;i++){
            if(Float.parseFloat(matrizdedatos[i][3])>notaMayor){
                notaMayor =  Float.parseFloat(matrizdedatos[i][3]);
                nombre = matrizdedatos[i][0];
            }
        }

        return nombre;
    }


    public String respuesta2(){
        int cont= 0;

        for(int i=0;i<matrizdedatos.length;i++){
            if(matrizdedatos[i][2].equals("Biologia")){
                cont += 1;
            }
        }

        return String.valueOf(cont);
    }
}
