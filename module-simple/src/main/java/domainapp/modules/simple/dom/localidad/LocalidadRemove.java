package domainapp.modules.simple.dom.localidad;


import domainapp.modules.simple.dom.direccion.Direccion;
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
@ActionLayout(associateWith = "localidad", sequence = "1", named = "Borrar Localidad")
@RequiredArgsConstructor
public class LocalidadRemove {

    private final Localidad localidad;

    public void delete() {
        final String title = titleService.titleOf(this.localidad);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this.localidad);
    }

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
