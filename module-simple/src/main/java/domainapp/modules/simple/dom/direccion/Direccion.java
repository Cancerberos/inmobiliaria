package domainapp.modules.simple.dom.direccion;


import domainapp.modules.simple.types.Name;
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
import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;
@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.direccion.Direccion "
                        + "ORDER BY calle ASC")
})
@Unique(
        name = "calle_calle_UNQ", members = {"calle"}
)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="id")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(editing = Editing.DISABLED)
//@DomainObject(logicalTypeName = "simple.Direccion", entityChangePublishing = Publishing.ENABLED)
@HomePage
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class Direccion implements Comparable<Direccion>{


    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "provincia", sequence = "1")
    private String provincia;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "localidad", sequence = "2")
    private String localidad;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "cp", sequence = "3")
    private int cp;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "calle", sequence = "4")
    private String calle;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "numero", sequence = "5")
    private int numero;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "edificacion", sequence = "6")
    private String edificacion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "piso", sequence = "7")
    private String  piso;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "departamento", sequence = "8")
    private String departamento;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "latitud", sequence = "9")
    private String latitud;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "longitud", sequence = "10")
    private String longitud;


    public Direccion(String provincia, String localidad, int cp, int numero, String edificacion, String piso, String departamento, String latitud, String longitud) {
        this.provincia = provincia;
        this.localidad = localidad;
        this.cp = cp;
        this.calle = calle;
        this.numero = numero;
        this.edificacion = edificacion;
        this.piso = piso;
        this.departamento = departamento;
        this.latitud = latitud;
        this.longitud = longitud;

    }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Elimina este objeto del almac??n de datos persistente")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull Direccion o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
