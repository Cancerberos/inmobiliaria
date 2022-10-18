package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.imagen.Imagen;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.localidad.Localidad;
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
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

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


 public  Inmueble(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                  String edificacion, String piso, String departamento, String latitud, String longitud,
                  Localidad  localidad,TipoUnidad tipoUnidad, Cliente cliente){
     this.descripcion=descripcion;
     this.fechaExclusividad=fechaExclusividad;
     this.calle=calle;
     this.altura=altura;
     this.edificacion=edificacion;
     this.piso=piso;
     this.departamento=departamento;
     this.latitud=latitud;
     this.longitud=longitud;
     this.tipoUnidad=tipoUnidad;
     this.localidad=localidad;
     this.cliente=cliente;
 }
    @NotPersistent
    private   Localidad descCp;
    @NotPersistent
    private   Localidad descProv;
    @NotPersistent
    private   Cliente desCli;
    @NotPersistent
    private   TipoUnidad tipoU;
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

     @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "11")
    @Column(allowsNull = "true", name = "Localidadid")
    private Localidad localidad;
    @Transient
    @PropertyLayout(fieldSetId = "name", sequence = "11")
    public String getdescProv() {  return  localidad.getProvincia().getDescripcion(); }
    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "11")
    @Column(allowsNull = "true", name = "TipounidadId")
    private TipoUnidad tipoUnidad;
    @Transient
    @PropertyLayout(fieldSetId = "name", sequence = "10")
    public String gettipoU() {  return    tipoUnidad.getDescripcion(); }


    @Getter @Setter
    @PropertyLayout(fieldSetId = "name", sequence = "11")
    @Column(allowsNull = "true", name = "id")
    private Cliente cliente;

    @Transient
    @PropertyLayout(fieldSetId = "name", sequence = "10")
    public String getdesCli() {  return    cliente.getNombre()+" - "+ cliente.getApellido(); }




    @Persistent(mappedBy="inmueble")
    @Collection
    private InmuebleCaracteristica  inmueblecaracteristica;

    @Persistent(mappedBy="inmueble")
    @Collection
    private Imagen imagen;

    public String title() {
        return titleService.titleOf("Descripcion  "+getDescripcion()) + "-" + getCalle();
    }


    @Action( semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "name", sequence = "1", named = "Modifica Datos Principales")
    public Object UpdateDatosProncipales(String descripcion, LocalDateTime fechaExclusividad, String calle , String altura,
                                         String edificacion, String piso, String departamento, String latitud, String longitud,
                                         Localidad  localidad,TipoUnidad tipoUnidad, Cliente cliente) {

        setDescripcion(descripcion);
        setFechaExclusividad(fechaExclusividad);
        setCalle(calle);
        setAltura(altura);
        setEdificacion(edificacion);
        setPiso(piso);
        setDepartamento(departamento);
        setLatitud(latitud);
        setLongitud(longitud);
        setLocalidad(localidad);
        setTipoUnidad(tipoUnidad);
        setCliente(cliente);
        return this;
    }
    public @NonNull String default0UpdateDatosProncipales() {return getDescripcion(); }
    public LocalDateTime default1UpdateDatosProncipales() {return getFechaExclusividad(); }
    public @NonNull String default2UpdateDatosProncipales() {return getCalle(); }
    public @NonNull String default3UpdateDatosProncipales() {return getAltura(); }
    public @NonNull String default4UpdateDatosProncipales() {return getEdificacion(); }
    public @NonNull String default5UpdateDatosProncipales() {return getPiso(); }
    public @NonNull String default6UpdateDatosProncipales() {return getDepartamento(); }
    public @NonNull String default7UpdateDatosProncipales() {return getLatitud(); }
    public @NonNull String default8UpdateDatosProncipales() {return getLongitud(); }
    public Localidad default9UpdateDatosProncipales() {return getLocalidad(); }
    public List<Localidad> autoComplete10UpdateDatosProncipales(String name) {return repositoryService.allInstances(Localidad.class); }
    public TipoUnidad default10UpdateDatosProncipales() {return getTipoUnidad(); }
    public List<TipoUnidad> autoComplete9UpdateDatosProncipales(String name) {return repositoryService.allInstances(TipoUnidad.class); }
    public Cliente default11UpdateDatosProncipales() {return getCliente(); }
    public List<Cliente> autoComplete11UpdateDatosProncipales(String name) {return repositoryService.allInstances(Cliente.class); }

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