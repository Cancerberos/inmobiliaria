package domainapp.modules.simple.dom.estado_aviso;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

@Action(
        semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(position = ActionLayout.Position.PANEL,
        associateWith = "EstadoAvisoRemove",
        sequence = "1", named = "Borrar un Estado de Aviso",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public  class EstadoAvisoRemove {
    private final EstadoAviso estadoAviso;

    public void delete() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ this.estadoAviso.getDescripcion() , title));
        repositoryService.remove(estadoAviso);

    }
    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
