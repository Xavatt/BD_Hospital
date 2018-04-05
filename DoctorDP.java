package bd_hospital;

import java.util.StringTokenizer;

public class DoctorDP 
{
    private String clave, nombre, especialidad, direccion, telefono;
    
    public DoctorDP()
    {
        this.clave = "";
        this.nombre = "";
        this.especialidad = "";
        this.direccion = "";
        this.telefono = "";
    }
    
    public DoctorDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        this.clave = st.nextToken();
        this.nombre = st.nextToken();
        this.especialidad = st.nextToken();
        this.direccion = st.nextToken();
        this.telefono = st.nextToken();        
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String toStringSql()
    {
        return "'"+this.clave + "','" + this.nombre + "','" + this.especialidad + "','" + this.direccion+"','" +this.telefono+"'";
    }
    
    public String toString()
    {
    	return this.clave + "_" + this.nombre + "_" + this.especialidad + "_" + this.direccion + "_" + this.telefono;
    }
   
}
