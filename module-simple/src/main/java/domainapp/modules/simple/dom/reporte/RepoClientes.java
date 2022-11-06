package domainapp.modules.simple.dom.reporte;


@lombok.Getter @lombok.Setter
public class RepoClientes {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String calle;
    public RepoClientes(String nombre, String apellido, String telefono, String email, String calle)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
        this.calle=calle;
         }
    public RepoClientes(){}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCalle() {
        return calle;
    }

}
