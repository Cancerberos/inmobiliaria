package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.types.EmailAddress;
import domainapp.modules.simple.types.LastName;
import domainapp.modules.simple.types.Name;
import domainapp.modules.simple.types.PhoneNumber;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Unique(name = "cliente_id_UNQ", members = {"id"})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.Cliente", entityChangePublishing = Publishing.ENABLED)
@lombok.RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
//@ToString(onlyExplicitlyIncluded = true)
public class Cliente implements Comparable<Cliente>{


    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = null;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT = null;

    @PropertyLayout(fieldSetId = "id", sequence = "1")
    private int id;
    @Getter
    @Setter
    @PropertyLayout(fieldSetId = "nombre", sequence = "1")
    private String nombre;

    @LastName
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "apellido", sequence = "2")
    private String apellido;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "direccion", sequence = "3")
    private Direccion direccion;

    @Column(name = "telefono", length = PhoneNumber.MAX_LEN, nullable = true)
    @Getter @Setter
    @PropertyLayout(fieldSetId = "telefono", sequence = "4")
    private String telefono;

    @EmailAddress
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "email", sequence = "5")
    private String email;



    public Cliente(
            String nombre,
            String apellido,
            Direccion direccion, String telefono, String email

    ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

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

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}