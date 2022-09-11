package domainapp.modules.simple.dom.cliente;

import domainapp.modules.simple.dom.localidad.Localidad;

import domainapp.modules.simple.dom.provincia.Provincia;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.Action;
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

@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="id")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.cliente",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@javax.jdo.annotations.Unique(name="Cliente_UNQ", members = {"nombre"})
public class Cliente implements Comparable<Cliente>{

   @NotPersistent
   private   Localidad descCp;
   @NotPersistent
   private   Localidad descProv;

    public Cliente(String nombre, String apellido, String telefono,
                   String email, String calle , String altura, String edificacion, String piso, String departamento,String latitud,String longitud, Localidad localidad) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
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
    private String nombre;
    @Column(allowsNull = "false")
    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1")
    @Column(allowsNull = "false")
    private String apellido;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1")
    @Column(allowsNull = "true")
    private String email;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "1" )
    @Column(allowsNull = "false")
    private String telefono;

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
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "9", labelPosition=LabelPosition.RIGHT, typicalLength=180,cssClass="x-key")
    @javax.jdo.annotations.Column(allowsNull = "true", name = "Localidadid")
    private Localidad localidad;
    @Transient
    @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "10",named = "Codigo Postal")
    public String getdescCp() {  return    localidad.getCodigoPostal(); }

    @Transient
   @PropertyLayout(fieldSetId = "Datos del Cliente", sequence = "11",named = "Provincia")
    public String getdescProv() {  return  localidad.getProvincia().getDescripcion(); }


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
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Listar Clientes")
    public List<Cliente> listAll() {
        return clienteRepositorio.listarCliente();
    }


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "Datos Localidad", sequence = "1", named = "Modifica Cliente")
    public Object UpdateCliente( String nombre, String apellido,String email,
                                 String telefono, String calle , String altura,String edificacion,String piso, String departamento,
                                 String latitud,String longitud ,Localidad localidad
    ) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setTelefono(telefono);
        setCalle(calle);
        setAltura(altura);
        setEdificacion(edificacion);
        setPiso(piso);
        setDepartamento(departamento);
        setLatitud(latitud);
        setLongitud(longitud);
        setLocalidad(localidad);
        return this;
    }
         public @NonNull String default0UpdateCliente() {return getNombre(); }
         public @NonNull String default1UpdateCliente() {return getApellido(); }
         public @NonNull String default2UpdateCliente() { return getEmail();  }
         public @NonNull String default3UpdateCliente() { return getTelefono(); }
         public @NonNull String default4UpdateCliente() { return getCalle(); }
         public @NonNull String default5UpdateCliente() { return getAltura(); }
         public @NonNull String default6UpdateCliente() { return getEdificacion(); }
         public @NonNull String default7UpdateCliente() { return getPiso(); }
         public @NonNull String default8UpdateCliente() { return getDepartamento();}
         public @NonNull String default9UpdateCliente() { return getLatitud();}
         public @NonNull String default10UpdateCliente() { return getLongitud();}
         public Localidad default11UpdateCliente() { return getLocalidad();}
         public List<Localidad> autoComplete11UpdateCliente (String name){return repositoryService.allInstances(Localidad.class); }

        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
        ClienteRepositorio clienteRepositorio;


}