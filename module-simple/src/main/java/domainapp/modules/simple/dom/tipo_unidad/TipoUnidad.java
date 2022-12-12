package domainapp.modules.simple.dom.tipo_unidad;

import domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristicaRepositorio;
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
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dom.tipounidad.TipoUnidad "
                        + "ORDER BY descripcion ASC"),
        @Query(
                name = "findTipoUnidad", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.tipounidad.TipoUnidad  "
                        + " "
                        + " ORDER BY descripcion ASC"),

})
@DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="TipounidadId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@Unique(name="Tipo_Unidad_UNQ", members = {"descripcion"})
public class TipoUnidad implements Comparable<TipoUnidad>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findAll" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;

    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    public TipoUnidad(String descripcion) {

        this.descripcion = descripcion;
    }
       @ActionLayout( named = "Listar Tipo de Unidad" )
      public List<TipoUnidad> listAll() {
        return repositoryService.allInstances(TipoUnidad.class);
    }

    @Action(semantics =IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle =PromptStyle.DIALOG_MODAL,associateWith = "TipoUnidad",
     sequence = "1", named = "Modifica Tipo" )
    public TipoUnidad updateTipo(final String descripcion)
           {
        setDescripcion(descripcion);
         return this;
    }
    public @NonNull String default0UpdateTipo() {return getDescripcion();
    }

    @Override
    public int compareTo(@NotNull TipoUnidad o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;
    TipoCaracteristicaRepositorio tipoCaracteristicaRepositorio;
    @Inject

    MessageService messageService;
    TitleService titleService;
}


