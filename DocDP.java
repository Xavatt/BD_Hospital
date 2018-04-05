
package bd_hospital;

import java.util.StringTokenizer;

public class DocDP 
{
   private String claveDoc, nombreDoc, especialidadDoc, clavePac, nombrePac;
   
       public DocDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        claveDoc = st.nextToken();
        nombreDoc = st.nextToken();
        especialidadDoc = st.nextToken();
        clavePac = st.nextToken();
        nombrePac = st.nextToken();
    }

    public String getClaveDoc() {
        return claveDoc;
    }

    public void setClaveDoc(String claveDoc) {
        this.claveDoc = claveDoc;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getEspecialidadDoc() {
        return especialidadDoc;
    }

    public void setEspecialidadDoc(String especialidadDoc) {
        this.especialidadDoc = especialidadDoc;
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
       
    public String toString()
    {
      return this.claveDoc + "_" + this.nombreDoc + "_" + this.especialidadDoc + "_" + this.clavePac + "_" +this.nombrePac;
    }   
   
}
