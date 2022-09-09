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
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(schema = "Inmobiliaria", identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findDireccion", language = "JDOQL",
                value = "SELECT"
                        + " FROM domainapp.modules.simple.dom.direccion.Direccion"
                         + " ORDER BY calle ASC"),
})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Direccionid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.direccion", entityChangePublishing = Publishing.ENABLED)
@lombok.RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
//@javax.jdo.annotations.Unique(name="Direccion_localidad_calle_UNQ", members = {"calle","localidad"})
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

   // @javax.jdo.annotations.Column(allowsNull = "true", name = "clienteid")
   // @Property(editing = Editing.DISABLED)
  //  @Getter @Setter
  //  Cliente cliente;



    public String title() {
        return getCalle() ;
    }

    public String iconName() { return "Direccion";  }



    @Override
    public int compareTo(@NotNull Direccion o) {
        return 0;
    }

    private final static Comparator<Direccion> comparator =
    Comparator.comparing(Direccion::getCalle).thenComparing(Direccion::getCalle);
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Listar Direcciones")
    public List<Direccion> listAll() {
        return repositoryService.allInstances(Direccion.class);
    }



    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "Datos Direccion", sequence = "1", named = "Modifica Direccion")
    public Object UpdateDireccion(String calle, int numero, String edificacion, String piso, String departamento, String latitud, String longitud,Localidad localidad) {
        setCalle(calle);
        setNumero(numero);
        setEdificacion(edificacion);
        setPiso(piso);
        setDepartamento(departamento);
        setLatitud(latitud);
        setLongitud(longitud);
        setLocalidad(localidad);
        return this;
    }
    public @NonNull String default0UpdateDireccion() {
        return getCalle();
    }
    public @NonNull int default1UpdateDireccion() {
        return getNumero();
    }
    public @NonNull String default2UpdateDireccion() {
        return getEdificacion();
    }
    public @NonNull String default3UpdateDireccion() {
        return getPiso();
    }
    public @NonNull String default4UpdateDireccion() {
        return  getDepartamento();
    }
    public @NonNull String default5UpdateDireccion() {
        return getLatitud();
    }
    public @NonNull String default6UpdateDireccion() {
        return  getLongitud();
    }
    public Localidad default7UpdateDireccion() {
        return getLocalidad();
    }
    public List<Localidad> autoComplete7UpdateDireccion(String name) {
        return repositoryService.allInstances(Localidad.class);
    }
    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
