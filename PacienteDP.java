package hospital;


import java.util.StringTokenizer;

public class PacienteDP
{
    private String clave, nombre, direccion, telefono;

    public PacienteDP()
    {
        this.clave = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
    }

    public PacienteDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos, "_");
        this.clave = st.nextToken();
        this.nombre = st.nextToken();
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

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String toStringSql()
    {
    	return "'"+this.clave + "','" + this.nombre + "','" + this.direccion + "','" + this.telefono+"'";
    }

    public String toString()
    {
    	return this.clave + "_" + this.nombre + "_" + this.direccion + "_" + this.telefono;
    }
}
