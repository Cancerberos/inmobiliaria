package domainapp.modules.simple.dom.cliente;


import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;

@Action(
        semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(position = ActionLayout.Position.PANEL,
        associateWith = "cliente",
        sequence = "1", named = "Borrar Cliente",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public class ClienteRemove {

    private final Cliente cliente;
    public void act() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ cliente.getNombre() , title));
        repositoryService.remove(cliente);
    }
    public static class ActionEvent extends ActionDomainEvent<ClienteRemove> {}

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
