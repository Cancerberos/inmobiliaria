package domainapp.modules.simple.dom.inmueble_caracteristica;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "inmueble", sequence = "12",named = "Agraga Caracteristicas",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class InmuebleCaracteristicaAdd {

    private final Inmueble inmueble;

       public Inmueble AddCaracteristicas(TipoCaracteristica tipoCaracteristica, int cant)
       {
            repositoryService.persist(new InmuebleCaracteristica(tipoCaracteristica, cant, inmueble));
            return  inmueble;
   }

    public List<TipoCaracteristica> autoComplete0AddCaracteristicas(String name) {return repositoryService.allInstances(TipoCaracteristica.class); }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}