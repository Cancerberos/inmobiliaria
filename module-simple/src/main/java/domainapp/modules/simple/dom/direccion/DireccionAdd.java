package domainapp.modules.simple.dom.direccion;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.DireccionAdd"
)

public class DireccionAdd {


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,
            named = "Agregar Direccion" )
    public Direccion AddDireccion( Cliente cliente,
            final String calle,
            final int numero,
            final String edificacion,
            final String piso,
            final String departamento,
            final String latitud,
            final String longitud,
            final Localidad localidad) {
        return repositoryService.persist(new Direccion(calle, numero, edificacion, piso, departamento, latitud, longitud, localidad));
    }
    public List<Localidad> autoComplete7AddDireccion(String name) {return repositoryService.allInstances(Localidad.class); }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    DireccionRepositorio direccionRepositorio;



}