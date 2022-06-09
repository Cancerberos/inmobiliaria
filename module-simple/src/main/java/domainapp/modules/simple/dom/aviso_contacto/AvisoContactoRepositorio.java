package domainapp.modules.simple.dom.aviso_contacto;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.usuario.Usuario;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.AvisoContactoRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class AvisoContactoRepositorio {
    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public AvisoContacto createAvisoContacto(
            final Usuario usuario,
            final Aviso aviso,
            final String mensaje,
            final EstadoContacto estadoContacto) {
        return repositoryService.persist(new AvisoContacto(usuario, aviso, mensaje, estadoContacto));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<AvisoContacto> q = jdoSupportService.newTypesafeQuery(AvisoContacto.class);
        final QAvisoContacto candidate = QAvisoContacto.candidate();
        q.range(0,2);
        q.orderBy(candidate.mensaje.asc());
        q.executeList();
    }
}
