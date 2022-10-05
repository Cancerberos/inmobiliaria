package domainapp.modules.simple.dom.tipo_operacion;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService( nature = NatureOfService.REST, logicalTypeName = "simple.TipoOperacionAdd")

public class TipoOperacionAdd {

    private TipoOperacion tipoOperacion;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL, named = "Agregar Tipo de Operacion" )
    public TipoOperacion AddTipoOperacion(final String descripcion) {
       return repositoryService.persist(new TipoOperacion( descripcion));

    }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
