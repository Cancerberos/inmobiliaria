package domainapp.modules.simple.dom.tipo_unidad;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.TipoUnidad"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class TipoUnidadRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public TipoUnidad create(
            final String descripcion) {
        return repositoryService.persist(new TipoUnidad(descripcion));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<TipoUnidad> q = jdoSupportService.newTypesafeQuery(TipoUnidad.class);
        final QTipoUnidad candidate = QTipoUnidad.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
}
