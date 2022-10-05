package domainapp.modules.simple.dom.estado_aviso;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.EstadoAvisoRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class EstadoAvisoRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<EstadoAviso> BuscarPorEstadoAviso(
            final String descripcion
    ) {
        return repositoryService.allMatches(
                Query.named(EstadoAviso.class, "findAll")
                        .withParameter("descripcion",descripcion));
    }

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public EstadoAviso createEstadoAviso(
            final String descripcion)
             {
               return repositoryService.persist(new EstadoAviso(descripcion));
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<EstadoAviso> listarEstadoAviso() {
        return repositoryService.allInstances(EstadoAviso.class);
    }

}