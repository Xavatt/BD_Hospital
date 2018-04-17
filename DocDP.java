import java.util.StringTokenizer;

public class DocDP 
{
   private String clave, nombreDoc, especialidadDoc, clavePac, nombrePac;
    
    public DocDP()
    {
        
        this.clave = "";
        this.nombreDoc = "";
        this.especialidadDoc = "";
        this.clavePac = "";
        this.nombrePac = "";
    }
   
       public DocDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        this.clave = st.nextToken();
        this.nombreDoc = st.nextToken();
        this.especialidadDoc = st.nextToken();
        this.clavePac = st.nextToken();
        this.nombrePac = st.nextToken();
    }

    public String getClaveDoc() {
        return clave;
    }

    public void setClaveDoc(String claveDoc) {
        this.clave = claveDoc;
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
      return this.clave + "_" + this.nombreDoc + "_" + this.especialidadDoc + "_" + this.clavePac + "_" +this.nombrePac;
    }   
   
}
