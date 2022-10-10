package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "Aviso", sequence = "12",named = "Publicar nuevo Aviso",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class AvisoAdd {

    private final Aviso aviso;


    public Aviso AddAviso(String descripcion,
                          Inmueble inmueble ,
                          Double valor,
                          TipoOperacion tipoOperacion,
                          Date fechaInicio,
                          Date fechaFin,
                          EstadoAviso estadoAviso
    ) {
        repositoryService.persist(new Aviso(descripcion,inmueble,valor,tipoOperacion,
                fechaInicio,fechaFin,estadoAviso ));
        return aviso;
    }
    public List<Inmueble> autoComplete1AddAviso(String name) {return repositoryService.allInstances(Inmueble.class); }
    public List<TipoOperacion> autoComplete3AddAviso(String name) {return repositoryService.allInstances(TipoOperacion.class); }
    public List<EstadoAviso> autoComplete6AddAviso(String name) {return repositoryService.allInstances(EstadoAviso.class); }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
