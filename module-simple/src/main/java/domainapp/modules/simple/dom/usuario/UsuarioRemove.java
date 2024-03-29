package domainapp.modules.simple.dom.usuario;


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
        associateWith = "UsuarioRemove",
        sequence = "1", named = "Borrar Usuario",
        describedAs = "Elimina este objeto del almacén de datos persistente")
@RequiredArgsConstructor
public class UsuarioRemove {

    private final Usuario usuario;
    public void act() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ usuario.getNombre() , title));
        repositoryService.remove(usuario);
    }
    public static class ActionEvent extends ActionDomainEvent<UsuarioRemove> {}

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
