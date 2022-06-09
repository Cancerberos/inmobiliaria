package domainapp.modules.simple.dom.tipo_operacion;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.TipoOperacion"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class TipoOperacionRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public TipoOperacion createTipoOperacion(
            final String descripcion) {
        return repositoryService.persist(new TipoOperacion(descripcion));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<TipoOperacion> q = jdoSupportService.newTypesafeQuery(TipoOperacion.class);
        final QTipoOperacion candidate = QTipoOperacion.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
}
