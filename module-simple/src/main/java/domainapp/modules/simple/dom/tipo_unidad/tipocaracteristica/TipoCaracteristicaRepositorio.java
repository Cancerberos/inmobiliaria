package domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica;

import domainapp.modules.simple.types.Name;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.TipoCaracteristicaRepositorio"
)

public class TipoCaracteristicaRepositorio {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<TipoCaracteristica> BuscarPorTipoCaracteristica(TipoCaracteristica tipoCaracteristica) {
        return repositoryService.allMatches(
                Query.named(TipoCaracteristica.class, "findAll")
                        .withParameter("descripcion",tipoCaracteristica));
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Buscar Caracteristica  por Nombre")
    public List<TipoCaracteristica> buscarPorCaracteristica(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(TipoCaracteristica.class, TipoCaracteristica.NAMED_QUERY__FIND_BY_NAME_LIKE)
                          );
    }
    @Programmatic
    public TipoCaracteristica buscarPorCaracteristicasExacta(final String name) {
        return repositoryService.firstMatch(
                        Query.named(TipoCaracteristica.class, TipoCaracteristica.NAMED_QUERY__FIND_BY_NAME_LIKE)
                               )
                .orElse(null);
    }
    @PropertyLayout(named = "Detalle  de las Caracteristicas", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    public Object edit(){ return null; }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Caracteristicas")
    public List<TipoCaracteristica> listAll() {
        return repositoryService.allInstances(TipoCaracteristica.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}