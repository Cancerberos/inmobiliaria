package domainapp.modules.simple.dom.localidad;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.QDireccion;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.LocalidadRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class LocalidadRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Localidad> BuscarPorLocalidad(
            final String descripcion
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, "findAll")
                        .withParameter("descripcion",descripcion));
    }

     final RepositoryService repositoryService ;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Localidad createLocalidad(final Provincia provincia,
            final String descripcion,final int codigoPostal)
             {
               return repositoryService.persist(new Localidad(descripcion,provincia,codigoPostal));
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Localidad> listarocalidades() {
        return repositoryService.allInstances(Localidad.class);
    }



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Localidad> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                      );
    }


    @Programmatic
    public Localidad findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_EXACT)
                                .withParameter("name", name))
                .orElse(null);
    }



   @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }


    @Programmatic
      public void ping() {
       JDOQLTypedQuery<Localidad> q = jdoSupportService.newTypesafeQuery(Localidad.class);
        final QDireccion candidate = QDireccion.candidate();
         q.range(0,2);
         q.orderBy(candidate.calle.asc());
        q.executeList();
       }


}