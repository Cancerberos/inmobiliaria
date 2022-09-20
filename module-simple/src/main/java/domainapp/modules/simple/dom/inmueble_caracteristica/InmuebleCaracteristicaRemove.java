package domainapp.modules.simple.dom.inmueble_caracteristica;


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
        associateWith = "inmueblecaracteristica",
        sequence = "1", named = "Eliminar Caracteristica del Inmueble")
@RequiredArgsConstructor
public class InmuebleCaracteristicaRemove {
   final  private InmuebleCaracteristica  inmuebleCaracteristica;
    public void delete() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ inmuebleCaracteristica.getTipoCaracteristica().getDescripcion() , title));
        repositoryService.remove(inmuebleCaracteristica);
    }
    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
