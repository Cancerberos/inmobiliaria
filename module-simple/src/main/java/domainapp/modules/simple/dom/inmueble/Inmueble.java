package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@javax.jdo.annotations.PersistenceCapable(
        schema = "Inmobiliaria",
        identityType= IdentityType.DATASTORE)
@javax.jdo.annotations.Unique(
        name = "inmueble_descripcion_UNQ", members = {"descripcion"}
)
@javax.jdo.annotations.DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column="version")

@DomainObject(logicalTypeName = "simple.Inmueble", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class Inmueble implements Comparable<Inmueble>{


    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "cliente", sequence = "2")
    private Cliente cliente;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "descripcion", sequence = "3")
    private String descripcion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "fechaExclusividad", sequence = "4")
    private Date fechaExclusividad;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "tipoUnidad", sequence = "5")
    private TipoUnidad tipoUnidad;

    @Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "direccion", sequence = "1")
    private Direccion direccion;

    public Inmueble(Cliente cliente,String descripcion, Date fechaExclusividad, TipoUnidad tipoUnidad, Direccion direccion) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fechaExclusividad = fechaExclusividad;
        this.tipoUnidad = tipoUnidad;
        this.direccion = direccion;
    }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull Inmueble o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}