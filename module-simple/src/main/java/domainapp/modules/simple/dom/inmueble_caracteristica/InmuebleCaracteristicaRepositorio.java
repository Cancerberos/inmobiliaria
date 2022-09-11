package domainapp.modules.simple.dom.inmueble_caracteristica;

import domainapp.modules.simple.dom.caracteristica.Caracteristica;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.InmuebleCaracteristicaRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class InmuebleCaracteristicaRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public InmuebleCaracteristica createInmuebleCaracteristica(
            final Caracteristica caracteristica,
            final int cantidad,
            final Inmueble inmueble) {
        return repositoryService.persist(new InmuebleCaracteristica(caracteristica, inmueble, cantidad));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<InmuebleCaracteristica> q = jdoSupportService.newTypesafeQuery(InmuebleCaracteristica.class);
        final QInmuebleCaracteristica candidate = QInmuebleCaracteristica.candidate();
        q.range(0,2);
        q.orderBy(candidate.cantidad.asc());
        q.executeList();
    }


}