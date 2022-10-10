package domainapp.modules.simple.dom.usuario;

import domainapp.modules.simple.dom.provincia.Provincia;
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
                name = "OrdenarUsuarioPorNombre", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.usuario.Usuario "
                        + "ORDER BY nombre ASC"),
        @Query(
                name = "OrdenarUsuarioPorUserName", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.usuario.Usuario "
                        + "ORDER BY username ASC"),
})

@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="UsuarioId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.Usuario",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@Unique(name="usuario_UNQ", members = {"nombre"})
public class Usuario implements Comparable<Usuario>{

    public Usuario(String userName, String nombre, String apellido, String telefono,
                   String email, String password, Boolean esAdmin ) {
        this.userName=userName;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
        this.password=password;
        this.esAdmin=esAdmin;

    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_USUARIO = "OrdenarUsuarioPorNombre";
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_USER_NAME = "OrdenarUsuarioPorUserName";


    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "1")
    private String userName;
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "1")
    private String nombre;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "1")
    @Column(allowsNull = "false")
    private String apellido;
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "1" )
    @Column(allowsNull = "false")
    private String telefono;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "1")
    @Column(allowsNull = "true")
    private String email;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "5", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String password;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Usuario", sequence = "6", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private Boolean esAdmin;

    public String title() {
        return getNombre() ;
    }

    @Override
    public int compareTo(@NotNull Usuario o) {
        return 0;
    }

    private final static Comparator<Usuario> comparator =
            Comparator.comparing(Usuario::getNombre).thenComparing(Usuario:: getNombre);

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Listar Usuarios")
    public List<Usuario> ListarTodosLosUsuario() {
        return repositoryService.allInstances(Usuario.class);
    }



    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "name", sequence = "1", named = "Modifica Usuario")
    public Object UpdateUsuario(String userName, String nombre, String apellido, String telefono,
                                String email, String password, Boolean esAdmin
    ) {
        setUserName(userName);
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setTelefono(telefono);
        setPassword(password);
        setEsAdmin(esAdmin);
        return this;
    }
    public @NonNull String default0UpdateUsuario() {return getUserName(); }
    public @NonNull String default1UpdateUsuario() {return getNombre(); }
    public @NonNull String default2UpdateUsuario() {return getApellido(); }
    public @NonNull String default3UpdateUsuario() { return getEmail();  }
    public @NonNull String default4UpdateUsuario() { return getTelefono(); }
    public String default5UpdateUsuario() { return getPassword(); }
    public Boolean default6UpdateUsuario() { return getEsAdmin(); }

        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
       UsuarioRepositorio usuarioRepositorio;


}