package domainapp.modules.simple.dom.inmueble_caracteristica;

import domainapp.modules.simple.dom.caracteristica.Caracteristica;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

@javax.jdo.annotations.PersistenceCapable(
        schema = "Inmobiliaria",
        identityType= IdentityType.DATASTORE)
@javax.jdo.annotations.Unique(
        //name = "caracteristica_descripcion_UNQ", members = {"descripcion"}
)
@javax.jdo.annotations.DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column="version")

@DomainObject(logicalTypeName = "simple.inmuebleCaracteristica", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class InmuebleCaracteristica implements Comparable<InmuebleCaracteristica>{

    @Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "caracteristica", sequence = "1")
    private Caracteristica caracteristica;

    /*@Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "caracteristica", sequence = "2")
    private Inmueble inmueble;*/

    @Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "cantidad", sequence = "3")
    private int cantidad;

    public InmuebleCaracteristica(Caracteristica caracteristica, int cantidad) {
        this.caracteristica = caracteristica;
        this.cantidad = cantidad;
    }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public int compareTo(@NotNull InmuebleCaracteristica o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
}
