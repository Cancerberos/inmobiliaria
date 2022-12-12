package domainapp.modules.simple.dom.red_social;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.RedesSociales"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class RedSocialRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public RedSocial createRedSocial(
            final String descripcion,
            final String url) {
        return repositoryService.persist(new RedSocial(descripcion, url));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<RedSocial> q = jdoSupportService.newTypesafeQuery(RedSocial.class);
        final QRedSocial candidate = QRedSocial.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
}
