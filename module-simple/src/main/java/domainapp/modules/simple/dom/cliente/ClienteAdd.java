package domainapp.modules.simple.dom.cliente;


import domainapp.modules.simple.dom.direccion.Direccion;
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

@RequiredArgsConstructor
public class ClienteAdd {

    private final Direccion direccion;


    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
     public Cliente act(
            final String nombre,
            final String apellido,
            final Direccion direccion,
            final String telefono,
            final String email) {
        return repositoryService.persist(new Cliente(nombre, apellido, direccion, telefono, email));
    }


    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;
}
