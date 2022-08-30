package domainapp.modules.simple.dom.localidad;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.inject.Inject;

import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.services.repository.RepositoryService;
import lombok.RequiredArgsConstructor;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "localidad", sequence = "1", named = "Agregar Localidad")
@RequiredArgsConstructor
public class LocalidadAdd {

    private final Provincia provincia;

    public Localidad act( final String descripcion, final String codigoPostal)
    {
        return repositoryService.persist(new Localidad(provincia,descripcion,codigoPostal));
    }

    @Inject ClockService clockService;
    @Inject RepositoryService repositoryService;

}
