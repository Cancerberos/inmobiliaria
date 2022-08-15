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
import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(nature = NatureOfService.REST,logicalTypeName = "simple.LocalidadRepositorio")
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@RequiredArgsConstructor()
//@ActionLayout(associateWith = "localidad", sequence = "1")
public class LocalidadRepositorio {

    final RepositoryService repositoryService ;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public List<Localidad> BuscarPorLocalidad(final String descripcion ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, "findAll")
                        .withParameter("descripcion",descripcion));
    }
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public Localidad act(final Provincia provincia,final String descripcion,final int codigoPostal)
             {
               return repositoryService.persist(new Localidad(provincia,descripcion,codigoPostal));
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
     public List<Localidad> listarocalidades() {
        return repositoryService.allInstances(Localidad.class);
    }

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public List<Localidad> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                      );
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public Localidad findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_EXACT)
                                .withParameter("name", name))
                .orElse(null);
    }




    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT,domainEvent = CreateDomainEvent.class)
      public void ping() {
       JDOQLTypedQuery<Localidad> q = jdoSupportService.newTypesafeQuery(Localidad.class);
        final QDireccion candidate = QDireccion.candidate();
         q.range(0,2);
         q.orderBy(candidate.calle.asc());
        q.executeList();
       }

    public static class CreateDomainEvent extends ActionDomainEvent<LocalidadRepositorio> {}



}