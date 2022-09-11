package domainapp.modules.simple.dom.provincia;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;
import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dom.provincia.Provincia "
                        + ""),

})
//@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="Provinciaid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@javax.jdo.annotations.Unique(name="Provincia_descripcion_UNQ", members = {"descripcion"})
public class Provincia implements Comparable<Provincia>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findAll" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;


    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;


    public Provincia(String descripcion) {
        this.descripcion = descripcion;
    }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(position = ActionLayout.Position.PANEL,describedAs = "Elimina este objeto del almacén de datos persistente",named = "Eliminar Provincia" )
    public void deleteProvincia() {        final String title = titleService.titleOf(" Mensaje del Sistema ");
        messageService.informUser(String.format("- '%s' - Se Borro el Registro => "+ getDescripcion(), title));
        repositoryService.removeAndFlush(this);
    }
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( named = "Listar Provincia" )
    public List<Provincia> listarProvincia() {
        return provinciaRepositorio.listAll();
    }

    @Action(semantics =IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle =PromptStyle.DIALOG_MODAL,
            associateWith = "provincia",
            sequence = "1", named = "Modifica Provincia" )
    public Provincia updateProvincia(final String descripcion)
           {
        setDescripcion(descripcion);
         return this;
    }
    public @NonNull String default0UpdateProvincia() {
        return getDescripcion();
    }
    @Override
    public int compareTo(@NotNull Provincia o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
    LocalidadRepositorio localidadRepositorio;
    ProvinciaRepositorio provinciaRepositorio;


}
