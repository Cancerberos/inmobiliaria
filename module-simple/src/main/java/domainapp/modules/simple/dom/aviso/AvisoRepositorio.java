package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.AvisoRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class AvisoRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Aviso createAviso(
            final String descripcion,
            final Inmueble inmueble,
            final double valor,
            final TipoOperacion tipoOperacion,
            final DateTime fecInicio,
            final DateTime fecFin,
            final EstadoAviso estadoAviso) {
        return repositoryService.persist(new Aviso(descripcion, inmueble, valor, tipoOperacion, fecInicio, fecFin, estadoAviso));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Aviso> q = jdoSupportService.newTypesafeQuery(Aviso.class);
        final QAviso candidate = QAviso.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
}
