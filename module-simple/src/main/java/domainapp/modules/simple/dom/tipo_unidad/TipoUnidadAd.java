package domainapp.modules.simple.dom.tipo_unidad;

import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "TipoUnidadAd", sequence = "12",named = "Agrega Tipos de Unidad",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class TipoUnidadAd {

    private final TipoUnidad tipoUnidad;


    public TipoUnidad AddTipo(final String descripcion) {
        repositoryService.persist(new TipoUnidad( descripcion));
        return tipoUnidad;
    }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
