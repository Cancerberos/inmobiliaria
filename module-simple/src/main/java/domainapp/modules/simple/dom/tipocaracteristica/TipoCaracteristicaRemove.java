package domainapp.modules.simple.dom.tipocaracteristica;
import domainapp.modules.simple.dom.localidad.Localidad;
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
        associateWith = "TipoCaracteristicaRemove",
        sequence = "1", named = "Borrar Caracteristica",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public class TipoCaracteristicaRemove {
    private final TipoCaracteristica tipoCaracteristica;
    public void delete() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ this.tipoCaracteristica.getDescripcion() , title));
        repositoryService.remove(tipoCaracteristica);
    }
    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
