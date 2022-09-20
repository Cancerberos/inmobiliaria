package domainapp.modules.simple.dom.localidad;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService( nature = NatureOfService.REST,     logicalTypeName = "simple.LocalidadAdd")

public class LocalidadAdd {

    public Provincia provincia;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL, named = "Agregar Localidad" )
    public Localidad AddLocalidad( String descripcion, final String codigoPostal,Provincia provincia)
    {
        return repositoryService.persist(new Localidad(descripcion,codigoPostal,provincia));
    }
    public List<Provincia> autoComplete2AddLocalidad(String name) {return repositoryService.allInstances(Provincia.class); }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    DireccionRepositorio direccionRepositorio;


}