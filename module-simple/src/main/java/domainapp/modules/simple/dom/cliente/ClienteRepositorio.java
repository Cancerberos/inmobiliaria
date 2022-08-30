package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.QDireccion;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.ClienteRepositorio"
)


public class ClienteRepositorio {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Cliente> listarCliente() {
        return repositoryService.allInstances(Cliente.class);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Direccion> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Direccion.class, Provincia.NAMED_QUERY__FIND_BY_NAME_LIKE)
        );
    }



    @Programmatic
    public Cliente findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Cliente.class, Cliente.NAMED_QUERY__FIND_BY_NAME_EXACT_CLIENTE)
                                .withParameter("name", name))
                .orElse(null);
    }



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Provincia> listAll() {
        return repositoryService.allInstances(Provincia.class);
    }


    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Provincia> q = jdoSupportService.newTypesafeQuery(Provincia.class);
        final QDireccion candidate = QDireccion.candidate();
        q.range(0,2);
        q.orderBy(candidate.calle.asc());
        q.executeList();
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;

}