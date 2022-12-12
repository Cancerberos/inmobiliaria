package domainapp.modules.simple.dom.reporte;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.PropertyLayout;

import javax.jdo.annotations.Column;
import java.time.LocalDateTime;

public class RepoInmueble {
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
     private LocalDateTime fechaExclusividad;
    @Getter @Setter
    private String calle;
    @Getter @Setter
    private String altura;
    @Getter @Setter
    private String edificacion;
    @Getter @Setter
    private String piso;
    @Getter @Setter
    private String departamento;
    @Getter @Setter
    private String localidad;
    @Getter @Setter
    private String tipoUnidad;
    @Getter @Setter
    private String cliente;


    public  RepoInmueble(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                     String edificacion, String piso, String departamento,
                     Localidad  localidad, TipoUnidad tipoUnidad, Cliente cliente){
        this.descripcion=descripcion;
        this.fechaExclusividad= LocalDateTime.parse(fechaExclusividad.toString());
        this.calle=calle;
        this.altura=altura;
        this.edificacion=edificacion;
        this.piso=piso;
        this.departamento=departamento;
        this.tipoUnidad=tipoUnidad.getDescripcion();
        this.localidad= localidad.getDescripcion();
        this.cliente=cliente.getApellido();
    }
    public RepoInmueble() {}

    public String getDescripcion() {return descripcion; }

    public LocalDateTime getFechaExclusividad() { return fechaExclusividad;  }

    public String getCalle() {return calle; }

    public String getAltura() {    return altura;    }

    public String getEdificacion() { return edificacion;   }

    public String getPiso() {  return piso; }

    public String getDepartamento() { return departamento;    }

    public String getTipoUnidad() { return tipoUnidad; }

    public String getLocalidad() {  return localidad; }

    public String getCliente() { return cliente;  }
}
