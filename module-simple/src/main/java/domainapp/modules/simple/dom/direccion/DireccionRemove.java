package domainapp.modules.simple.dom.direccion;


import domainapp.modules.simple.dom.localidad.Localidad;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@Action(
        semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(position = ActionLayout.Position.PANEL,
        associateWith = "direccion",
        sequence = "1", named = "Borrar Direccion",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public class DireccionRemove {

    private final Direccion direccion;
    public static class ActionEvent extends ActionDomainEvent<DireccionRemove> {}

    public void act() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ direccion.getCalle() , title));
        repositoryService.remove(direccion);
    }

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
