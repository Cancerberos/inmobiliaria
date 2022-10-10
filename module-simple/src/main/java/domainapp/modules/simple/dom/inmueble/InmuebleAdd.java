package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidadRepositorio;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.InmuebleAdd"
)

public class InmuebleAdd {


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,
            named = "Agregar Inmueble" )
    public Inmueble AddInmueble(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                                String edificacion, String piso, String departamento, String latitud, String longitud,
                                TipoUnidad tipoUnidad, Localidad localidad, Cliente cliente)
    {
       return repositoryService.persist(new Inmueble(descripcion,
                       fechaExclusividad,
                       calle,
                       altura,
                       edificacion,
                       piso,
                       departamento,
                       latitud,
                       longitud,
               localidad,
               tipoUnidad,cliente ))
                ;
    }
    public List<TipoUnidad> autoComplete9AddInmueble(String name) {return repositoryService.allInstances(TipoUnidad.class); }

    public List<Localidad> autoComplete10AddInmueble(String name) {return repositoryService.allInstances(Localidad.class); }

    public List<Cliente> autoComplete11AddInmueble(String name) {return repositoryService.allInstances(Cliente.class); }

    public String validate1AddInmueble(LocalDateTime fechaExclusividad) {
        return clockService.getClock().nowAsLocalDateTime().isBefore(fechaExclusividad)
                ? null
                : "Must be in the future";
    }
    public LocalDateTime default1AddInmueble() {
        return clockService.getClock().nowAsLocalDateTime()
                .toLocalDate()
                .plusDays(1)
                .atTime(LocalTime.of(9, 0));
    }
    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    LocalidadRepositorio localidadRepositorio;
    TipoUnidadRepositorio tipoUnidadRepositorio;
    @Inject
    ClockService clockService;


}