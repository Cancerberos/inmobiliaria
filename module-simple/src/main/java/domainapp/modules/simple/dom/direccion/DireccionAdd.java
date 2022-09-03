package domainapp.modules.simple.dom.direccion;


import domainapp.modules.simple.dom.localidad.Localidad;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "Datos Direccion", sequence = "1", named = "Agrega Direccion")//
@RequiredArgsConstructor
public class DireccionAdd {

    private final Localidad localidad;

     public Direccion act(
            final String calle,
            final int numero,
            final String edificacion,
            final String piso,
            final String departamento,
            final String latitud,
            final String longitud)
    {
        return repositoryService.persist(new Direccion(calle,numero,edificacion,piso,departamento,latitud,longitud,localidad));
    }

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
}
