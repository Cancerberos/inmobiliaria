package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;


import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.AvisoRepositorio")
public class AvisoRepositorio {
    @ActionLayout(named = "Listar todos los Avisos")
    public List<Aviso> findByName() {
        return repositoryService.allMatches(
                Query.named(Aviso.class, Aviso.NAMED_QUERY__FIND_BY_NAME_EXACT_AVISO)
        );
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Consulta Cliente-Localidad-Provincia")
    public List<Cliente> getAllClientes() {
        return repositoryService.allMatches(
                Query.named(Cliente.class, "getAllClientes")
        );
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Avisos Cargados")
    public List<Aviso> listarAvisos() {
        return repositoryService.allInstances(Aviso.class);
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<Localidad> findByProvincia_Localidad(
            final Provincia provincia
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_EXACT)
                        .withParameter("provincia", provincia)

        );
    }

    public static class CreateDomainEvent extends ActionDomainEvent<domainapp.modules.simple.dom.localidad.LocalidadRepositorio> {
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
    AvisoAdd avisoAdd;


}
