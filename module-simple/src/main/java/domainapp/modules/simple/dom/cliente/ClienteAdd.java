package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import jdk.jfr.TransitionFrom;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.ClienteAdd"
)

public class ClienteAdd {


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,
            named = "Agregar Cliente")
    public Cliente AddCliente( String nombre,
                               String apellido,
                               String email,
                               String telefono,
                               String calle,
                               String altura,
                               String edificacion,
                               String piso,
                               String departamento,
                               String latitud,
                               String longitud,
                               Localidad localidad
                               ) {
        return repositoryService.persist(new Cliente(nombre,apellido,email,telefono,calle,altura,edificacion,piso,departamento,latitud,longitud,localidad ));
    }

   public List<Localidad> autoComplete11AddCliente(String name) {return repositoryService.allInstances(Localidad.class); }
    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    DireccionRepositorio direccionRepositorio;


}