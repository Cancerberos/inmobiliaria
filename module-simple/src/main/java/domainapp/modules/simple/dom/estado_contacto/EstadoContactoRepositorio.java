package domainapp.modules.simple.dom.estado_contacto;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.EstadoContacto"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class EstadoContactoRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public EstadoContacto createEstadoContacto(
            final String descripcion) {
        return repositoryService.persist(new EstadoContacto(descripcion));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<EstadoContacto> q = jdoSupportService.newTypesafeQuery(EstadoContacto.class);
        final QEstadoContacto candidate = QEstadoContacto.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
}
