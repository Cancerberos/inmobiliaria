package domainapp.modules.simple.dom.tipo_unidad;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.TipoUnidadAdd"
)

public class TipoUnidadAdd {

    public TipoUnidad tipoUnidad;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Agregar Tipos de Unidad" )
    public TipoUnidad AddTipo(final String descripcion) {
        repositoryService.persist(new TipoUnidad( descripcion));
        return tipoUnidad;
    }

    @Inject RepositoryService repositoryService;
}
