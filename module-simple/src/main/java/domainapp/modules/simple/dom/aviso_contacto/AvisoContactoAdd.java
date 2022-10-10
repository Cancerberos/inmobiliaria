package domainapp.modules.simple.dom.aviso_contacto;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import domainapp.modules.simple.dom.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


@DomainService( nature = NatureOfService.REST,logicalTypeName = "simple.AvisoContactoAdd")
public class AvisoContactoAdd {

    private  AvisoContacto avisoContacto;

    @Action(semantics = SemanticsOf.IDEMPOTENT, commandPublishing = Publishing.ENABLED,executionPublishing = Publishing.ENABLED)
    @ActionLayout(associateWith = "name", sequence = "1",named = "Dar de Alta Aviso Contacto",promptStyle = PromptStyle.DIALOG_MODAL)
    public AvisoContacto AddAvisoContacto(Usuario usuario, Aviso aviso, String mensaje , EstadoContacto estadoContacto   ) {
        repositoryService.persist(new AvisoContacto(usuario,aviso,mensaje,estadoContacto ));
        return avisoContacto;
    }
    public List<Usuario> autoComplete0AddAvisoContacto(String name) {return repositoryService.allInstances(Usuario.class); }

    public List<Aviso> autoComplete1AddAvisoContacto(String name) {return repositoryService.allInstances(Aviso.class); }

    public List<EstadoContacto> autoComplete3AddAvisoContacto(String name) {return repositoryService.allInstances(EstadoContacto.class); }

    @Inject
    RepositoryService repositoryService;
    MessageService messageService;
    TitleService titleService;
}
