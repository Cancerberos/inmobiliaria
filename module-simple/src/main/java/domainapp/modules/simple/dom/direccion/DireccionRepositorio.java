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
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
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

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Direccion createDireccion(
            final Provincia provincia,
            final Localidad localidad,
            final int cp,
            final int numero,
            final String edificacion,
            final String piso,
            final String departamento,
            final String latitud,
            final String longitud)
             {
               return repositoryService.persist(new Direccion(provincia,localidad,cp,numero,edificacion,piso,departamento,latitud,longitud));
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
                        .withParameter("name", name));
    }

    @Programmatic
    public Direccion findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Direccion.class, Direccion.NAMED_QUERY__FIND_BY_NAME_EXACT)
                                .withParameter("name", name))
                .orElse(null);
    }

}