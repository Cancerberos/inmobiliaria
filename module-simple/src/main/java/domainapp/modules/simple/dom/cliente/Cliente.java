package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.direccion.Direccion;
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
import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findClientes", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.cliente.Cliente "
                        + "ORDER BY nombre ASC"),
})

@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="clienteid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.cliente",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@javax.jdo.annotations.Unique(name="Cliente_direccion_UNQ", members = {"direccion","nombre"})
public class Cliente implements Comparable<Cliente>{
    public Cliente(Direccion direccion,String nombre,String apellido,String telefono, String email) {
        this.direccion =  direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_CLIENTE = "findClientes";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_CLIENTE = null;
    @javax.jdo.annotations.Column(allowsNull = "false", name = "Direccionid")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private Direccion direccion ;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Cliente", sequence = "1")
    private String nombre;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Cliente", sequence = "2")
    private String apellido;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "Datos Cliente", sequence = "3")
    private String telefono;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Cliente", sequence = "4")
    private String email;


    public String title() {
        return getNombre() ;
    }

    @Override
    public int compareTo(@NotNull Cliente o) {
        return 0;
    }
    private final static Comparator<Cliente> comparator =
            Comparator.comparing(Cliente::getNombre).thenComparing(Cliente:: getNombre);

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "Datos Localidad", sequence = "1", named = "Modifica Cliente")
    public Object UpdateCliente(Direccion direccion, String nombre , String apellido,String telefono,String email) {
        setDireccion(direccion);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        return this;
    }
    public Direccion default0UpdateCliente() {
        return getDireccion();
    }
    public List<Direccion> autoComplete0UpdateCliente(String name) {return repositoryService.allInstances(Direccion.class); }
    public @NonNull String default1UpdateCliente() {
        return getNombre();
    }
    public @NonNull String default2UpdateCliente() {
        return getApellido();
    }
    public @NonNull String default3UpdateCliente() { return getTelefono(); }
    public @NonNull String default4UpdateCliente() { return getEmail();  }
    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}