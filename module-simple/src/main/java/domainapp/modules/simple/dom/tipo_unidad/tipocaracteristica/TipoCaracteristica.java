package domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica;

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
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica "
                        + "ORDER BY descripcion ASC"),
        @Query(
                name = "findTipoCaracteristica", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica  "
                        + " "
                        + " ORDER BY descripcion ASC"),

})
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="TipoCaracteristicaId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@Unique(name="Tipo_Caracteristica_UNQ", members = {"descripcion"})
public class TipoCaracteristica implements Comparable<TipoCaracteristica>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findAll" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;

    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    public TipoCaracteristica(String descripcion) {

        this.descripcion = descripcion;
    }

   // @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( named = "Listar Tipo Caracteristica" )
      public List<TipoCaracteristica> listAll() {
        return repositoryService.allInstances(TipoCaracteristica.class);
    }

    @Action(semantics =IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle =PromptStyle.DIALOG_MODAL,associateWith = "tipocaracteristica",
            sequence = "1", named = "Modifica Caracteristica" )
    public TipoCaracteristica updateCaracteristica(final String descripcion)
           {
        setDescripcion(descripcion);
         return this;
    }
    public @NonNull String default0UpdateCaracteristica() {return getDescripcion();
    }

    @Override
    public int compareTo(@NotNull TipoCaracteristica o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;
    TipoCaracteristicaRepositorio tipoCaracteristicaRepositorio;
    @Inject

    MessageService messageService;
    TitleService titleService;
}


