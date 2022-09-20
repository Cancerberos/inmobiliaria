package domainapp.modules.simple.dom.inmueble_caracteristica;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.InmuebleCaracteristicaRepositorio")
public class InmuebleCaracteristicaRepositorio {

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<InmuebleCaracteristica> BuscarPorInmuebleCaracteristica(
            final Inmueble inmueble
            ) {
        return repositoryService.allMatches(
                Query.named(InmuebleCaracteristica.class, InmuebleCaracteristica.NAMED_QUERY__FIND_BY_NAME_LIKE)
                        .withParameter("inmueble", inmueble)

        );
    }
    @ActionLayout(named = "Listar todas las Caracteristicas")
    public List<InmuebleCaracteristica> listAll() {
        return repositoryService.allInstances(InmuebleCaracteristica.class);
    }
    public static class CreateDomainEvent extends ActionDomainEvent<InmuebleCaracteristicaRepositorio> {}

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}