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

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.provincia.Estado_Aviso "
                        + "ORDER BY descripcion ASC")
})
@Unique(
        name = "descripcion_EstadoAviso_UNQ", members = {"descripcion"}
)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="id")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(editing = Editing.DISABLED)
//@DomainObject(logicalTypeName = "simple.direccion", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class Estado_Aviso implements Comparable<Estado_Aviso>{


    @Title
    @Name
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    public Estado_Aviso(String descripcion) {
        this.descripcion = descripcion;
    }


    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Elimina este objeto del almacén de datos persistente")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull Estado_Aviso o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
