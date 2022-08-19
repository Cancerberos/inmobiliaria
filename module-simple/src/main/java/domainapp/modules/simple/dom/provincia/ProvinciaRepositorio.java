package domainapp.modules.simple.dom.provincia;

import domainapp.modules.simple.dom.direccion.QDireccion;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import org.springframework.core.annotation.AliasFor;

import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
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
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Provincia createProvincia(
            final String descripcion)
             {
               return repositoryService.persist(new Provincia(descripcion));
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Provincia> listarProvincia() {
        return repositoryService.allInstances(Provincia.class);
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


      @Programmatic
      public void ping() {
        JDOQLTypedQuery<Provincia> q = jdoSupportService.newTypesafeQuery(Provincia.class);
        final QDireccion candidate = QDireccion.candidate();
        q.range(0,2);
        q.orderBy(candidate.calle.asc());
        q.executeList();
      }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}