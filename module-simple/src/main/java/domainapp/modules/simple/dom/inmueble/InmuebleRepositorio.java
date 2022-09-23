package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.InmuebleRepositorio")
public class InmuebleRepositorio {
    @ActionLayout(named = "Buscar Inmueble por Nombre")
       public List<Inmueble> BuscarPorNombreInmueble(
            final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Inmueble.class, Inmueble.NAMED_QUERY__FIND_BY_NAME_LIKE_INMUEBLE)
                      );
    }
    @ActionLayout(named = "Listar Inmueble")
    public List<Inmueble> listAllInmuebles() {
        return repositoryService.allInstances(Inmueble.class);
    }

    @ActionLayout(named = "Listar  Inmuebles")
    public List<Inmueble> listAll() {
        return repositoryService.allInstances(Inmueble.class);
    }
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<Inmueble> BuscarPorInmueble(
             final Inmueble inmueble
    ) {
        return repositoryService.allMatches(
                Query.named(Inmueble.class, Inmueble.NAMED_QUERY__FIND_BY_NAME_LIKE_INMUEBLE)
                        .withParameter("inmueble", inmueble)

        );
    }
    public static class CreateDomainEvent extends ActionDomainEvent<InmuebleRepositorio> {}

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}