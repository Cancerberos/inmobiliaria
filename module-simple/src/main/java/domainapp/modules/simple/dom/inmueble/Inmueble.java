package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findInmueble", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.cliente.Cliente "
                        + "ORDER BY nombre ASC"),
})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Inmuebleid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.inmueble",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
//@ToString(onlyExplicitlyIncluded = true)
@Unique(name="Inmueble_UNQ", members = {"descripcion"})
public class Inmueble implements Comparable<Inmueble>{

    public Inmueble(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                    String edificacion, String piso, String departamento, String latitud, String longitud,
                    String superficie, Boolean patio, Boolean parrilla,Boolean piscina,Boolean cochera,
                    Boolean petFriendly,String imgUrl1, String imgUrl2, String imgUrl3, TipoUnidad tipoUnidad,
                    Localidad localidad) {

        this.descripcion=descripcion;
        this.fechaExclusividad=fechaExclusividad;
        this.calle=calle;
        this.altura=altura;
        this.edificacion=edificacion;
        this.piso=piso;
        this.departamento=departamento;
        this.superficie=superficie;
        this.latitud=latitud;
        this.longitud=longitud;
        this.localidad=localidad;
        this.patio=patio;
        this.parrilla=parrilla;
        this.piscina=piscina;
        this.cochera=cochera;
        this.petFriendly=petFriendly;
        this.imgUrl1=imgUrl1;
        this.imgUrl2=imgUrl2;
        this.imgUrl3=imgUrl3;
        this.tipoUnidad=tipoUnidad;

    }
 public  Inmueble(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                  String edificacion, String piso, String departamento, String latitud, String longitud,
                  String superficie, TipoUnidad tipoUnidad, Localidad localidad){
     this.descripcion=descripcion;
     this.fechaExclusividad=fechaExclusividad;
     this.calle=calle;
     this.altura=altura;
     this.edificacion=edificacion;
     this.piso=piso;
     this.departamento=departamento;
     this.superficie=superficie;
     this.latitud=latitud;
     this.longitud=longitud;
     this.tipoUnidad=tipoUnidad;
     this.localidad=localidad;
 }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_INMUEBLE = "findClientes";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_INMUEBLE = null;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String descripcion;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "2")
     private LocalDateTime fechaExclusividad;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "3")
    private String calle;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "4")
    private String altura;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "5")
    private String edificacion;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "6")
    private String piso;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "7")
    private String departamento;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "8")
     private String latitud;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "9")
     private String longitud;


    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "10")
    private TipoUnidad tipoUnidad;

    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "11")
    @Column(allowsNull = "true", name = "Localidadid")
    private Localidad localidad;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "12")
    private String superficie;


    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "1")
     private Boolean patio;

    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "2")
    private Boolean parrilla;

    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "3")
    private Boolean piscina;

    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "4")
    private Boolean cochera;
    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "2")
    private Boolean petFriendly;

    @Column(allowsNull = "true")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "5")
     private TipoCalefaccion tipoCalefaccion;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "6")
    private String imgUrl1;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "7")
    private String imgUrl2;

    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "details", sequence = "8")
    private String imgUrl3;

    @Persistent(mappedBy="inmueble")
    @Collection
    private InmuebleCaracteristica  inmueblecaracteristica;


    public String title() {
        return titleService.titleOf("Descripcion  "+getDescripcion()) + " en calle " + getCalle();
    }
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Listar Inmueble")
    public List<Inmueble> listAll() {
        return repositoryService.allInstances(Inmueble.class);
    }
    @Action( semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "name", sequence = "1", named = "Modifica Datos Proncipales")
    public Object UpdateDatosProncipales(Provincia  provincia, String descripcion , String cp) {

        return this;
    }

    @Action( semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "details", sequence = "1", named = "Modifica Caracteristicas")
    public Object UpdateCaracteristicas(Provincia  provincia, String descripcion , String cp) {

        return this;
    }
    @Override
    public int compareTo(@NotNull Inmueble o) {
        return 0;
    }

    private final static Comparator<Inmueble> comparator =
            Comparator.comparing(Inmueble::getDescripcion).thenComparing(Inmueble:: getDescripcion);


        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
        ClienteRepositorio clienteRepositorio;
        DomainServiceLayout domainServiceLayout;
        InmuebleRepositorio inmuebleRepositorio;


}