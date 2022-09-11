package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findClientes", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.cliente.Cliente "
                        + "ORDER BY nombre ASC"),
})

@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Clienteid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.inmueble",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
//@ToString(onlyExplicitlyIncluded = true)
@Unique(name="Inmueble_UNQ", members = {"nombre"})
public class Inmueble implements Comparable<Inmueble>{

  // @NotPersistent
//   private   Localidad descCp;
  // @NotPersistent
//   private   Localidad descProv;

    public Inmueble(String descripcion, Date fechaExclusividad, TipoUnidad tipoUnidad,String calle , String altura,
                    String edificacion, String piso, String departamento, String latitud, String longitud,
                    String superficie,int cantHabientes,int cantHabitaciones,int cantBanios,int cantCocheras,
                    Boolean patio,Boolean parrilla,boolean piscina,
                    Boolean petFriendly,String imgUrl1,String imgUrl2,String imgUrl3,Localidad localidad) {

        this.calle=calle;
        this.altura=altura;
        this.edificacion=edificacion;
        this.piso=piso;
        this.departamento=departamento;
        this.latitud=latitud;
        this.longitud=longitud;
        this.localidad=localidad;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_CLIENTE = "findClientes";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_CLIENTE = null;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1")
    private String descripcion;

    @Column(allowsNull = "false")
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1")
    @Column(allowsNull = "false")
    private Date fechaExclusividad;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "5", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String calle;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "6", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String altura;
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "6", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String edificacion;
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String piso;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String departamento;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String latitud;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String longitud;


    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1")
    @Column(allowsNull = "true")
    private TipoUnidad tipoUnidad;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private String superficie;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
    private int cantHabientes;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
    private int cantHabitaciones;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
    private int cantBanios;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    private int cantCocheras;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
     private Boolean patio;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente")
    private Boolean parrilla;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
    private Boolean piscina;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7", labelPosition=LabelPosition.LEFT, typicalLength=80,cssClass="x-key")
    @Column(allowsNull = "true")
    private Boolean cochera;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "7")
     private int tipoCalefaccion;


   // String superficie,int cantHabientes,int cantHabitaciones,int cantBanios,int cantCocheras,
 // Boolean patio,Boolean parrilla,boolean piscina,tipoCalefaccion tipoCalefaccion,
   // Boolean petFriendly,String imgUrl1,String imgUrl2,String imgUrl3,Localidad localidad)
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "9", labelPosition=LabelPosition.RIGHT, typicalLength=180,cssClass="x-key")
    @Column(allowsNull = "true", name = "Localidadid")
    private Localidad localidad;
    @Transient
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "10",named = "Codigo Postal")
    public String getdescCp() {  return    localidad.getCodigoPostal(); }

    @Transient
   @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "11",named = "Provincia")
    public String getdescProv() {  return  localidad.getProvincia().getDescripcion(); }


   // public String title() {
 //       return getNombre() ;
//    }

    @Override
    public int compareTo(@NotNull Inmueble o) {
        return 0;
    }

   // private final static Comparator<Inmueble> comparator =
    //        Comparator.comparing(Inmueble::getNombre).thenComparing(Inmueble:: getNombre);


        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
        ClienteRepositorio clienteRepositorio;


}