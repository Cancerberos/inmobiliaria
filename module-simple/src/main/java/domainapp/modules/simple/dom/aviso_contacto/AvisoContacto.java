package domainapp.modules.simple.dom.aviso_contacto;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import domainapp.modules.simple.dom.usuario.Usuario;
import domainapp.modules.simple.types.EmailAddress;
import lombok.*;
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
@ToString(onlyExplicitlyIncluded = true)
public class AvisoContacto implements Comparable<AvisoContacto>{


 public AvisoContacto( String nombre,String apellido,String  email,Aviso aviso, String mensaje , EstadoContacto estadoContacto){
     this.mombre=nombre;
     this.apellido=apellido;
     this.aviso=aviso;
     this.email=email;
     this.mensaje=mensaje;
     this.estadoContacto=estadoContacto;
 }
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_AVISO_CONTACTO_CLIENTE = "buscarAvidoContacto";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_MENSAJE = null;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String mombre;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String apellido;
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "2")
    @Column(allowsNull = "true", name = "Aviso_Id")
    private Aviso aviso;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String mensaje;


    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String email;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "2")
    @Column(allowsNull = "true", name = "EstadoContactoId")
    private EstadoContacto estadoContacto;

    public String title() {
        return titleService.titleOf("Nombre:  "+ getMombre()) ;
    }

    @ActionLayout( named = "Listar Tipo de Contactos de Avisos" )
    public List<AvisoContacto> listAll() {
        return repositoryService.allInstances(AvisoContacto.class);
    }

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