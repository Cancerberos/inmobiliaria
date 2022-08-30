package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.types.EmailAddress;
import domainapp.modules.simple.types.LastName;
import domainapp.modules.simple.types.PhoneNumber;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.glassfish.ha.store.criteria.Criteria;
import org.jetbrains.annotations.NotNull;
import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Column;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

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
    public Cliente(Direccion direccion,
            String nombre,
            String apellido,
             String telefono, String email

    ) {
        this.direccion =  direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_CLIENTE = "findClientes";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_CLIENTE = null;
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1")
    private String nombre;

    @javax.jdo.annotations.Column(allowsNull = "false", name = "Direccionid")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private  Direccion direccion;
    @LastName
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "2")
    private String apellido;
    @Column(name = "telefono", length = PhoneNumber.MAX_LEN, nullable = true)
    @Getter @Setter
   @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "3")
    private String telefono;

    @EmailAddress
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "4")
    private String email;


    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void deleteCliente() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull Cliente o) {
        return 0;
    }
    private final static Comparator<Cliente> comparator =
            Comparator.comparing(Cliente::getNombre).thenComparing(Cliente:: getNombre);
    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}