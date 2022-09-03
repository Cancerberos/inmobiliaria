package domainapp.modules.simple.dom.provincia;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.ProvinciaRepositorio"
)

public class ProvinciaRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Provincia> BuscarPorProvincia(
            final String descripcion
    ) {
        return repositoryService.allMatches(
                Query.named(Provincia.class, "findAll")
                        .withParameter("descripcion",descripcion));
    }
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Agregar Provincia")
     public Provincia createProvincia(
            final String descripcion)
             {
               return repositoryService.persist(new Provincia(descripcion));
    }
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Provincia> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Provincia.class, Provincia.NAMED_QUERY__FIND_BY_NAME_LIKE)
                          );
    }
    @Programmatic
    public Provincia findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Provincia.class, Provincia.NAMED_QUERY__FIND_BY_NAME_LIKE)
                               )
                .orElse(null);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Provincia> listAll() {
        return repositoryService.allInstances(Provincia.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}