package hospital;


import java.util.StringTokenizer;

public class AtiendeDP
{
    private String claveDoc, clavePac, fecha, diagnostico, tratamiento;

    public AtiendeDP()
    {
        this.claveDoc = "";
        this.clavePac = "";
        this.fecha = "";
        this.diagnostico = "";
        this.tratamiento = "";
    }

    public AtiendeDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        this.fecha = st.nextToken();
        this.diagnostico = st.nextToken();
        this.tratamiento = st.nextToken();
        this.claveDoc  = st.nextToken();
        this.clavePac = st.nextToken();
    }

    public String getClaveDoc() {
        return claveDoc;
    }

    public void setClaveDoc(String claveDoc) {
        this.claveDoc = claveDoc;
    }

    public String getClavePac() {
        return clavePac;
    }

    public void setClavePac(String clavePac) {
        this.clavePac = clavePac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

     public String toStringSql(){
    	return "'"+this.fecha + "','" + this.diagnostico + "','" + this.tratamiento + "','" + this.claveDoc +"','" +this.clavePac+"'";
    }

    public String toString(){
    	return this.fecha + "_" + this.diagnostico + "_" + this.tratamiento + "_" + this.claveDoc + "_" + this.clavePac;
    }
}
