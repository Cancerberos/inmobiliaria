package domainapp.modules.simple.dom.tipocaracteristica;

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
@ActionLayout(associateWith = "TipoCaracteristicaAd", sequence = "12",named = "Agrega Caracteristicas",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class TipoCaracteristicaAd {

    private final TipoCaracteristica  tipoCaracteristica;


    public TipoCaracteristica AddCaracteristica(final String descripcion) {
        repositoryService.persist(new TipoCaracteristica( descripcion));
        return tipoCaracteristica;
    }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
