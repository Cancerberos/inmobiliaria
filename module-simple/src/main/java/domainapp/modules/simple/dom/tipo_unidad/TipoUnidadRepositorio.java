package domainapp.modules.simple.dom.tipo_unidad;

import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.TipoUnidadRepositorio"
)
public class TipoUnidadRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<TipoUnidad> BuscarPorTipoUnidad(TipoUnidad tipoUnidad) {
        return repositoryService.allMatches(
                Query.named(TipoUnidad.class, "findAll")
                        .withParameter("descripcion",tipoUnidad));
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Buscar Tipos  por Nombre")
    public List<TipoUnidad> buscarPorTipo(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(TipoUnidad.class, TipoUnidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                          );
    }
    @Programmatic
    public TipoUnidad buscarPorTipoExacto(final String name) {
        return repositoryService.firstMatch(
                        Query.named(TipoUnidad.class, TipoUnidad.NAMED_QUERY__FIND_BY_NAME_LIKE)
                               )
                .orElse(null);
    }
    @PropertyLayout(named = "Detalle  de Tipo de Unidades", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    public Object edit(){
        return null;
    }
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar  Tipo de Unidad")
    public List<TipoUnidad> listAllTipoUnidad() {
        return repositoryService.allInstances(TipoUnidad.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}