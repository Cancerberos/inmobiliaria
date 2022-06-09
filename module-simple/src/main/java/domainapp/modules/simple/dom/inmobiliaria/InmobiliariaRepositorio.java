package domainapp.modules.simple.dom.inmobiliaria;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.InmobiliariaRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class InmobiliariaRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Inmobiliaria createInmobiliaria(
            final String razonSociall,
            final String cuit,
            final String direccion,
            final String telefono,
            final String logo) {
        return repositoryService.persist(new Inmobiliaria(razonSociall, cuit, direccion, telefono, logo));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Inmobiliaria> q = jdoSupportService.newTypesafeQuery(Inmobiliaria.class);
        final QInmobiliaria candidate = QInmobiliaria.candidate();
        q.range(0,2);
        q.orderBy(candidate.razonSocial.asc());
        q.executeList();
    }


}