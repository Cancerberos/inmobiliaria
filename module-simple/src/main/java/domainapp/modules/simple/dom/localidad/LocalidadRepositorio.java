package domainapp.modules.simple.dom.localidad;

import domainapp.modules.simple.dom.direccion.QDireccion;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;
import java.util.Optional;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.LocalidadRepositorio")
public class LocalidadRepositorio {

       public List<Localidad> findByName(
            final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                      );
    }
    @PropertyLayout(named ="Listado de  Localidades por codigo postal",  cssClass="x-key")
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }

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