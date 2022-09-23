package domainapp.modules.simple.dom.imagen;


import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristicaRepositorio;
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
        associateWith = "imagen",
        sequence = "1", named = "Eliminar Imagen del inmueble")
@RequiredArgsConstructor
public class ImagenRemove {
   final  private Imagen imagen;
    public void delete() {
        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ imagen.getDescripcion() , title));
        repositoryService.remove(imagen);
          }
    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
    InmuebleRepositorio inmuebleRepositorio;
}
