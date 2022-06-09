package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.imagen.Imagen;
import domainapp.modules.simple.dom.imagen.QImagen;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

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
            final String telefono,
            final String email) {
        return repositoryService.persist(new Cliente(nombre, apellido, telefono, email));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Cliente> q = jdoSupportService.newTypesafeQuery(Cliente.class);
        final QCliente candidate = QCliente.candidate();
        q.range(0,2);
        q.orderBy(candidate.nombre.asc());
        q.executeList();
    }


}