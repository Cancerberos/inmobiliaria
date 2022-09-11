package domainapp.modules.simple.dom.provincia;

import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "provincia", sequence = "12",named = "Agraga Localidad",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class ProvinciaaddLoc {

    private final Provincia provincia;

       public Provincia act(
            final String cp,
            final String descripcion
            ) {
        repositoryService.persist(new Localidad( descripcion,cp,provincia));
        return provincia;
    }

    @Inject RepositoryService repositoryService;
}
