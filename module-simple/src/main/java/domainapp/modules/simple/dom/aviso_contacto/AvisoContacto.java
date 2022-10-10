package domainapp.modules.simple.dom.aviso_contacto;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import domainapp.modules.simple.dom.usuario.Usuario;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Comparator;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "buscarAvidoContacto", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.aviso_contacto.AvisoContacto"
                        + " ORDER BY mensaje ASC"),
})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="AvisoContactoId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.avisocontacto",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
//@ToString(onlyExplicitlyIncluded = true)
//@Unique(name="Inmueble_UNQ", members = {"descripcion"})
public class AvisoContacto implements Comparable<AvisoContacto>{


 public AvisoContacto(Usuario usuario, Aviso aviso, String mensaje , EstadoContacto estadoContacto){
     this.usuario=usuario;
     this.aviso=aviso;
     this.mensaje=mensaje;
     this.estadoContacto=estadoContacto;

 }
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_AVISO_CONTACTO_CLIENTE = "buscarAvidoContacto";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_MENSAJE = null;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    @Column(allowsNull = "true", name = "UsuarioId")
    private Usuario usuario;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "2")
    @Column(allowsNull = "true", name = "AvisoId")
    private Aviso aviso;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String mensaje;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "2")
    @Column(allowsNull = "true", name = "EstadoContactoId")
    private EstadoContacto estadoContacto;

    public String title() {
        return titleService.titleOf("Descripcion  "+ getMensaje()) ;
    }

    @ActionLayout( named = "Listar Tipo de Unidad" )
    public List<AvisoContacto> listAll() {
        return repositoryService.allInstances(AvisoContacto.class);
    }


    @Action( semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "name", sequence = "1", named = "Modifica Datos Principales")
    public Object UpdateAvisoContacto(Usuario usuario, Aviso aviso, String mensaje , EstadoContacto estadoContacto)
     {
    setUsuario(usuario);
    setAviso(aviso);
    setMensaje(mensaje);
    setEstadoContacto(estadoContacto);
     return this;
    }
    public Usuario default0UpdateAvisoContacto() {return getUsuario(); }
    public Aviso default1UpdateAvisoContacto() {return getAviso(); }
    public @NonNull String default2UpdateAvisoContacto() {return getMensaje(); }
    public EstadoContacto default3UpdateAvisoContacto() {return getEstadoContacto(); }

    public List<Usuario> autoComplete0UpdateAvisoContacto(String name) {return repositoryService.allInstances(Usuario.class); }

    public List<Aviso> autoComplete1UpdateAvisoContacto(String name) {return repositoryService.allInstances(Aviso.class); }

    public List<EstadoContacto> autoComplete3UpdateAvisoContacto(String name) {return repositoryService.allInstances(EstadoContacto.class); }

    @Override
    public int compareTo(@NotNull AvisoContacto o) {
        return 0;
    }

    private final static Comparator<AvisoContacto> comparator =
            Comparator.comparing(AvisoContacto::getMensaje).thenComparing(AvisoContacto:: getMensaje);


        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
        DomainServiceLayout domainServiceLayout;
        AvisoContactoRepositorio avisoContactoRepositorio;



}