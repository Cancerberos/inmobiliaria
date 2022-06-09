package domainapp.modules.simple.dom.aviso_contacto;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.usuario.Usuario;
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

@javax.jdo.annotations.DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column="version")

@DomainObject(logicalTypeName = "simple.AvisoContacto", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class AvisoContacto implements Comparable<AvisoContacto>{

    @Getter
    @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "usuario", sequence = "1")
    private Usuario usuario;

    @Getter
    @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "aviso", sequence = "2")
    private Aviso aviso;

    @Getter
    @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "mensaje", sequence = "3")
    private String mensaje;

    @Getter
    @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "estadoContacto", sequence = "4")
    private EstadoContacto estadoContacto;

    public AvisoContacto(Usuario usuario, Aviso aviso, String mensaje, EstadoContacto estadoContacto) {
        this.usuario = usuario;
        this.aviso = aviso;
        this.mensaje = mensaje;
        this.estadoContacto = estadoContacto;
    }

    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void deleteAvisoContacto() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

    @Override
    public int compareTo(@NotNull AvisoContacto o) {
        return 0;
    }
}
