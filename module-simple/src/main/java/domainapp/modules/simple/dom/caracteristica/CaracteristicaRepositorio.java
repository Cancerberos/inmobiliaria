package domainapp.modules.simple.dom.caracteristica;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.CaracteristicaRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class CaracteristicaRepositorio {


    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Caracteristica> q = jdoSupportService.newTypesafeQuery(Caracteristica.class);
        final QCaracteristica candidate = QCaracteristica.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }


}
