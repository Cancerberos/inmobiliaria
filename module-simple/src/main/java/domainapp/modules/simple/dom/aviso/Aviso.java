package domainapp.modules.simple.dom.aviso;
import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.imagen.Imagen;
import domainapp.modules.simple.dom.imagen.ImagenRepositorio;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.intellij.lang.annotations.JdkConstants;
import org.jetbrains.annotations.NotNull;
import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(schema = "Inmobiliaria",identityType= IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "buscarAviso", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.aviso.Aviso "
                        + " ORDER BY descripcion ASC"),
        @Query(
                name = "listAll", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.aviso.Aviso "
                        + ""),
        @Query(
                name = "findLocalidad_Provincia", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.aviso.Aviso "
                        + " WHERE cliente == :cliente"
                        + " ORDER BY descripcion ASC"),
})

@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="AvisoId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.aviso",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@Unique(name="Aviso_UNQ", members = {"descripcion"})
public class Aviso  implements Comparable<Aviso> {



    public Aviso(String descripcion, Inmueble inmueble, Double valor,TipoOperacion tipoOperacion,
                 Date fechaInicio, Date fechaFin, EstadoAviso estadoAviso) {
        this.descripcion=descripcion;
        this.inmueble=inmueble;
        this.valor=valor;
        this.tipoOperacion=tipoOperacion;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.estadoAviso=estadoAviso;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_AVISO_DES = "buscarAviso";
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT_AVISO = "listAll";

    @Getter@Setter
    @Column(allowsNull = "false")
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Aviso", sequence = "1")
    private String descripcion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Aviso", sequence = "2", labelPosition=LabelPosition.RIGHT, typicalLength=180,cssClass="x-key")
    @Column(allowsNull = "true", name = "Inmuebleid")
    private Inmueble inmueble;

    @Getter@Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Aviso", sequence = "3")
    @Column(allowsNull = "false")
    private Double valor;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Aviso", sequence = "4", labelPosition=LabelPosition.RIGHT, typicalLength=180,cssClass="x-key")
    @Column(allowsNull = "true", name = "TipoOperacionId")
    private TipoOperacion tipoOperacion;

    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "Aviso", sequence = "5  ")
    @JdkConstants.CalendarMonth
    private Date fechaInicio;

    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "Aviso", sequence = "6  ")
    private Date fechaFin;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "Aviso", sequence = "7", labelPosition=LabelPosition.RIGHT, typicalLength=180,cssClass="x-key")
    @Column(allowsNull = "true", name = "EstadoAvisoId")
    private EstadoAviso estadoAviso;

      public String title() {
       return getDescripcion() ;
   }

    @Override
    public int compareTo(@NotNull Aviso o) {
        return 0;
    }

    private final static Comparator<Aviso> comparator =
            Comparator.comparing(Aviso::getDescripcion).thenComparing(Aviso:: getDescripcion);


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(named = "Listar Aviso")
    public List<Aviso> listAvisosCargados() { return repositoryService.allInstances(Aviso.class); }

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "modi", sequence = "1", named = "Modifica Aviso")
    public Object UpdateAviso( String descripcion, Inmueble inmueble,Double valor,TipoOperacion tipoOperacion,
                               Date fechaInicio,Date fechaFin,EstadoAviso estadoAviso
    ) {
        setDescripcion(descripcion);
        setInmueble(inmueble);
        setValor(valor);
        setTipoOperacion(tipoOperacion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setEstadoAviso(estadoAviso);
        return this;
    }
         public @NonNull String default0UpdateAviso() {return getDescripcion(); }
         public Inmueble default1UpdateAviso() {return getInmueble(); }
         public List<Inmueble> autoComplete1UpdateAviso (String name){return repositoryService.allInstances(Inmueble.class); }
         public Double default2UpdateAviso() { return getValor();  }
         public TipoOperacion default3UpdateAviso() { return getTipoOperacion(); }
         public List<TipoOperacion> autoComplete3UpdateAviso (String name){return repositoryService.allInstances(TipoOperacion.class); }
         public Date default4UpdateAviso() { return getFechaInicio(); }
         public Date default5UpdateAviso() { return getFechaFin(); }
         public EstadoAviso default6UpdateAviso() { return getEstadoAviso(); }
         public List<EstadoAviso> autoComplete6UpdateAviso (String name){return repositoryService.allInstances(EstadoAviso.class); }

        @Inject
        RepositoryService repositoryService;
        @Inject
        TitleService titleService;
        @Inject
        MessageService messageService;
        AvisoRepositorio avisoRepositorio;
        ImagenRepositorio imagenRepositorio;


}