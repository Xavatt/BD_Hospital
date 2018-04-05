package bd_hospital;

import java.util.StringTokenizer;

public class AnalisisDP
{

    private String tipo, descripcion, fechaAplicacion, fechaEntrega,noPaciente;

    public AnalisisDP()
    {
      this.tipo = "";
      this.descripcion = "";
      this.fechaAplicacion = "";
      this.fechaEntrega = "";
      this.noPaciente = "";
    }

    public AnalisisDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        tipo = st.nextToken();
        descripcion = st.nextToken();
        fechaAplicacion = st.nextToken();
        fechaEntrega = st.nextToken();
        noPaciente = st.nextToken();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNoPaciente() {
        return noPaciente;
    }

    public void setNoPaciente(String noPaciente) {
        this.noPaciente = noPaciente;
    }

    public String toStringSql()
    {
      return "'"+this.tipo + "','" + this.descripcion + "','" + this.fechaAplicacion + "','" + this.fechaEntrega+"','"+this.noPaciente+"'";
    }

    public String toString()
    {
      return this.tipo + "_" + this.descripcion + "_" + this.fechaAplicacion + "_" + this.fechaEntrega + "_" +this.noPaciente;
    }

}
