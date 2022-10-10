package domainapp.modules.simple.dom.estado_aviso;


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
                        + " FROM domainapp.modules.simple.dom.estado_aviso.EstadoAviso "
                        + "ORDER BY descripcion ASC")
})
@Unique(
        name = "descripcion_EstadoAviso_UNQ", members = {"descripcion"}
)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="EstadoAvisoId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(editing = Editing.DISABLED)
//@DomainObject(logicalTypeName = "simple.direccion", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class EstadoAviso implements Comparable<EstadoAviso>{

    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    public EstadoAviso(String descripcion) {
        this.descripcion = descripcion;
    }

    @ActionLayout( named = "Listar  Estados de  Avisos" )
    public List<EstadoAviso> listAll() {
        return repositoryService.allInstances(EstadoAviso.class);
    }

    @Action(semantics =IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle =PromptStyle.DIALOG_MODAL,associateWith = "EstadoAviso",
            sequence = "1", named = "Modifica Estado de Aviso" )
    public EstadoAviso UpdateTipo(final String descripcion)
    {
        setDescripcion(descripcion);
        return this;
    }
    public @NonNull String default0UpdateTipo() {return getDescripcion();
    }

    @Override
    public int compareTo(@NotNull EstadoAviso o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
