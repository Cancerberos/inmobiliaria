package domainapp.modules.simple.dom.provincia;


import domainapp.modules.simple.dom.localidad.Localidad;
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

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "findAllInactives", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dominio.provincia.Provincia "
                        + ""),
})
@javax.jdo.annotations.Unique(name="Provincia_name_UNQ", members = {"descripcion"})
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="id")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class Provincia implements Comparable<Provincia>{


    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findAllInactives" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;
    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;
    @Join(table="PROVINCIA_LOCALIDAD")
    private Localidad localidad;
    public Provincia(String descripcion) {
        this.descripcion = descripcion;
    }


    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(position = ActionLayout.Position.PANEL,describedAs = "Elimina este objeto del almacén de datos persistente")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
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


}
