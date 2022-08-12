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
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )

public class ClienteRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Cliente createCliente(
            final String nombre,
            final String apellido,
            final Direccion direccion,
            final String telefono,
            final String email) {
        return repositoryService.persist(new Cliente(nombre, apellido, direccion, telefono, email));
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Cliente> listarCliente() {
        return repositoryService.allInstances(Cliente.class);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Cliente> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Cliente.class, Cliente.NAMED_QUERY__FIND_BY_NAME_LIKE)
                        .withParameter("name", name));
    }


    @Programmatic
    public Cliente findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Cliente.class, Cliente.NAMED_QUERY__FIND_BY_NAME_EXACT)
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


}