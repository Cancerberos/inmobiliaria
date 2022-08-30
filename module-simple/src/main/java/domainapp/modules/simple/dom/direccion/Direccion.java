package domainapp.modules.simple.dom.direccion;


import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
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
import java.util.SortedSet;
import java.util.TreeSet;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;
@PersistenceCapable(schema = "Inmobiliaria", identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findDireccion", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.direccion.Direccion"
                         + "ORDER BY calle ASC"),
})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Direccionid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.direccion", entityChangePublishing = Publishing.ENABLED)
@lombok.RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@javax.jdo.annotations.Unique(name="Direccion_localidad_calle_UNQ", members = {"localidad","calle"})
public class Direccion implements Comparable<Direccion>{
    public Direccion( String calle, int numero, String edificacion, String piso, String departamento, String latitud, String longitud,Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.edificacion = edificacion;
        this.piso = piso;
        this.departamento = departamento;
        this.latitud = latitud;
        this.longitud = longitud;
        this.localidad = localidad;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_DIRECCION ="findDireccion" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_DIRECCION ="find" ;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Calle")
    private String calle;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Nro")
    private int numero;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Edificio")
    private String edificacion;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Piso")
    private String  piso;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Departamento")
    private String departamento;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Latitud")
    private String latitud;
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos Direccion", sequence = "1",named = "Longitud")
    private String longitud;
        @javax.jdo.annotations.Column(allowsNull = "false", name = "Localidadid")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private Localidad localidad ;
    public String title() {
        return getCalle() ;
    }

    public String iconName() { return "Direccion";  }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Elimina este objeto del almacén de datos persistente")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull Direccion o) {
        return 0;
    }

    private final static Comparator<Direccion> comparator =
    Comparator.comparing(Direccion::getCalle).thenComparing(Direccion::getCalle);

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
