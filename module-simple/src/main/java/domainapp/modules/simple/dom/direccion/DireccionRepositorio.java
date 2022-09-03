package domainapp.modules.simple.dom.direccion;
import javax.ejb.Local;
import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;


import domainapp.modules.simple.dom.cliente.QCliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;

import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.DireccionRepositorio")
public class DireccionRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_MODAL)
    public List<Direccion> findByCalle(
          @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Direccion.class, Direccion.NAMED_QUERY__FIND_BY_NAME_LIKE_DIRECCION)
        );
    }
    @PropertyLayout(named ="Listado de  Direccion por codigo postal",  cssClass="x-key")
    public List<Direccion> listAll() {
        return repositoryService.allInstances(Direccion.class);
    }
    public static class CreateDomainEvent extends ActionDomainEvent<DireccionRepositorio> {}
    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
}