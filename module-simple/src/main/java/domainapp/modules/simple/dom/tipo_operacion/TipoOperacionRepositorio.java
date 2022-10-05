package domainapp.modules.simple.dom.tipo_operacion;

import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.TipoOperacionRepositorio"
)
public class TipoOperacionRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<TipoOperacion> BuscarPorTipoOperacion(TipoOperacion tipoOperacion) {
        return repositoryService.allMatches(
                Query.named(TipoOperacion.class, "findAll")
                        .withParameter("descripcion",tipoOperacion));
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Detalle de Operaciones Nombre")
    public List<TipoOperacion> buscarPorTipo(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(TipoOperacion.class, TipoOperacion.NAMED_QUERY__FIND_BY_NAME_LIKE)
                          );
    }
    @Programmatic
    public TipoOperacion buscarPorTipoExacto(final String name) {
        return repositoryService.firstMatch(
                        Query.named(TipoOperacion.class, TipoOperacion.NAMED_QUERY__FIND_BY_NAME_LIKE)
                               )
                .orElse(null);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar  Tipo de Unidad")
    public List<TipoOperacion> listarTodasTipoOperacion() {
        return repositoryService.allInstances(TipoOperacion.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}