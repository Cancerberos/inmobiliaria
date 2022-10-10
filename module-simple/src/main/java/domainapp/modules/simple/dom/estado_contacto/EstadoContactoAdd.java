package domainapp.modules.simple.dom.estado_contacto;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService( nature = NatureOfService.REST, logicalTypeName = "simple.EstadoContactoAdd")

public class EstadoContactoAdd {

    private EstadoContacto estadoContacto;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL, named = "Agregar un Estado Contacto" )
    public EstadoContacto AddEstadoContacto(final String descripcion) {
       return repositoryService.persist(new EstadoContacto( descripcion));

    }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
