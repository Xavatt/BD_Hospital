package hospital;

import java.util.StringTokenizer;

public class PacDP 
{
    private String clavePac, nombrePac, tipo;
    
      public PacDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        clavePac = st.nextToken();
        nombrePac = st.nextToken();
        tipo = st.nextToken();
    }

    public String getClavePac() {
        return clavePac;
    }

    public void setClavePac(String clavePac) {
        this.clavePac = clavePac;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
      
     public String toString()
    {
      return this.clavePac + "_" + this.nombrePac + "_" + this.tipo;
    }   
   

}
