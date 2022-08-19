package domainapp.modules.simple.dom.direccion;
import javax.ejb.Local;
import javax.inject.Inject;


import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;

import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.DireccionRepositorio"
)
public class DireccionRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Direccion> BuscarPorDireccion(
             final String calle
    ) {
        return repositoryService.allMatches(
                Query.named(Direccion.class, "findAll")
                        .withParameter("calle",calle));
    }


     @Action(semantics = SemanticsOf.SAFE)
     @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
      public List<Direccion> listarDirecciones() {
       return repositoryService.allInstances(Direccion.class);
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Direccion> listAll() {
        return repositoryService.allInstances(Direccion.class);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Direccion> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Direccion.class, Direccion.NAMED_QUERY__FIND_BY_NAME_LIKE)
                       );
    }

    @Programmatic
    public Direccion findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Direccion.class, Direccion.NAMED_QUERY__FIND_BY_NAME_EXACT)
                                )
                .orElse(null);
    }
    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;
}