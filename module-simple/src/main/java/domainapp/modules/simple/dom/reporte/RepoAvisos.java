package domainapp.modules.simple.dom.reporte;
import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import java.util.Date;

@lombok.Getter @lombok.Setter
public class RepoAvisos {

    private String descripcion;
    private Inmueble inmueble;
    private Double valor;
    private TipoOperacion tipoOperacion;
    private  Date fechaInicio;
    private Date fechaFin;
    private EstadoAviso estadoAviso;
    public RepoAvisos(String descripcion)
    {
        this.descripcion=descripcion;
       // this.inmueble=inmueble;
       // this.valor=valor;
       // this.tipoOperacion=tipoOperacion;
       // this.fechaInicio=fechaInicio;
       // this.fechaFin=fechaFin;
       // this.estadoAviso=estadoAviso;
         }
    public RepoAvisos(){}

    public String getDescripcion() {
        return descripcion;
    }

  // public Inmueble getInmueble() { return inmueble;    }

   // public Double geValor() { return valor; }

  //  public TipoOperacion getTipoOperaciones() {return tipoOperacion;   }

  //public Date getFechaInicio() {return fechaInicio;    }

  //  public Date getFechaFin() {  return fechaFin; }

  // public EstadoAviso getEstadoAviso() { return estadoAviso;    }

}
