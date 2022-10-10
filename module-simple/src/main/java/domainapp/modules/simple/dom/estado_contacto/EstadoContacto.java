package domainapp.modules.simple.dom.estado_contacto;

import domainapp.modules.simple.types.Name;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "buscarTodpPorDescripcion", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dom.estado_contacto.EstadoContacto "
                        + "ORDER BY descripcion ASC"),
        @Query(
                name = "buscarPorDescripcion", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.estado_contacto.EstadoContacto "
                        + " WHERE descripcion == :descripcion"
                        + " ORDER BY descripcion ASC"),

})
@DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="EstadoContactoId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
//@Unique(name="Tipo_Unidad_UNQ", members = {"descripcion"})
public class EstadoContacto implements Comparable<EstadoContacto>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE_CONTACTO = "buscarTodpPorDescripcion" ;
    public static final String NAMED_QUERY__FIND_BY_DES_CONTACTO ="buscarPorDescripcion" ;

    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    public EstadoContacto(String descripcion) {

        this.descripcion = descripcion;
    }
       @ActionLayout( named = "Listar Estados Contacto" )
      public List<EstadoContacto> ListaTodp() {
        return repositoryService.allInstances(EstadoContacto.class);
    }
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL, named = "Agregar un Estado Contacto" )
    public EstadoContacto AddEstadoContacto(final String descripcion) {
        return repositoryService.persist(new EstadoContacto( descripcion));

    }
    @Action(semantics =IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle =PromptStyle.DIALOG_MODAL,associateWith = "EstadoContacto",
     sequence = "1", named = "Modifica Estado Contacto" )
    public EstadoContacto UpdateEstadoContacto(final String descripcion)
           {
        setDescripcion(descripcion);
         return this;
    }
    public @NonNull String default0UpdateEstadoContacto() {return getDescripcion();
    }

    @Override
    public int compareTo(@NotNull EstadoContacto o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;

    @Inject
    EstadoContactoRepositorio  estadoContactoRepositorio;
    MessageService messageService;
    TitleService titleService;
}


