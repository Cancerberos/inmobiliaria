package domainapp.modules.simple.dom.aviso_contacto;


import domainapp.modules.simple.dom.cliente.Cliente;
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
        associateWith = "avisoContacto",
        sequence = "1", named = "Borrar Aviso Contacto",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public class AvisoContactoRemove {

    private final AvisoContacto avisoContacto;
    public void act() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ avisoContacto.getMensaje() , title));
        repositoryService.remove(avisoContacto);
    }
    public static class ActionEvent extends ActionDomainEvent<AvisoContactoRemove> {}

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
