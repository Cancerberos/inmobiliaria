package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.Date;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.AvisoAdd"
)

public class AvisoAdd {


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,
            named = "Agregar Aviso")
    public Aviso AddAviso(String descripcion,
                            Inmueble inmueble ,
                            Double valor,
                            TipoOperacion tipoOperacion,
                            Date fechaInicio,
                            Date fechaFin,
                            EstadoAviso estadoAviso
                               ) {
        return repositoryService.persist(new Aviso(descripcion,inmueble,valor,tipoOperacion,
                fechaInicio,fechaFin,estadoAviso ));
    }

    public List<Inmueble> autoComplete1AddAviso(String name) {return repositoryService.allInstances(Inmueble.class); }
    public List<TipoOperacion> autoComplete3AddAviso(String name) {return repositoryService.allInstances(TipoOperacion.class); }
    public List<EstadoAviso> autoComplete6AddAviso(String name) {return repositoryService.allInstances(EstadoAviso.class); }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    DireccionRepositorio direccionRepositorio;


}