package domainapp.modules.simple.dom.reporte;

import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class RepoAvisos {
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
     private String inmueble;
    @Getter @Setter
    private String valor;
    @Getter @Setter
    private String tipoOperacion;
    @Getter @Setter
    private String fechaInicio;
    @Getter @Setter
    private String fechaFin;
    @Getter @Setter
    private String estadoAviso;



    public RepoAvisos(String descripcion, Inmueble inmueble, String valor , TipoOperacion tipoOperacion,
                      Date fechaInicio, Date fechaFin, EstadoAviso estadoAviso){
        this.descripcion=descripcion;
        this.inmueble=inmueble.getDescripcion();
        this.valor=valor.toString();
        this.tipoOperacion=tipoOperacion.getDescripcion();
        this.fechaInicio=fechaInicio.toString();
        this.fechaFin=fechaFin.toString();
        this.estadoAviso=estadoAviso.getDescripcion();
    }
    public RepoAvisos() {}

    public String getDescripcion() {return descripcion; }
    public String getInmueble() { return inmueble;  }
    public String getValor() {return valor; }
    public String getTipoOperacion() { return tipoOperacion; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaFin() { return fechaFin; }
    public String getEstadoAviso() { return estadoAviso;  }
}
