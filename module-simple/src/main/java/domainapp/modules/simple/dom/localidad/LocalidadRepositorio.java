package domainapp.modules.simple.dom.localidad;

import domainapp.modules.simple.dom.direccion.QDireccion;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.Name;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.annotation.Priority;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(nature = NatureOfService.REST,logicalTypeName = "simple.LocalidadRepositorio")

public class LocalidadRepositorio {

    public List<Localidad> BuscarPorLocalidad(final String descripcion ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, "findAll")
                        .withParameter("descripcion",descripcion));
    }
    //@Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)


    //@Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
     public List<Localidad> listarocalidades() {
        return repositoryService.allInstances(Localidad.class);
    }

   // @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public List<Localidad> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                      );
    }

    //@Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }


    //@Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
      public void ping() {
       JDOQLTypedQuery<Localidad> q = jdoSupportService.newTypesafeQuery(Localidad.class);
        final QDireccion candidate = QDireccion.candidate();
         q.range(0,2);
         q.orderBy(candidate.calle.asc());
        q.executeList();
       }

    public static class CreateDomainEvent extends ActionDomainEvent<LocalidadRepositorio> {}

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}