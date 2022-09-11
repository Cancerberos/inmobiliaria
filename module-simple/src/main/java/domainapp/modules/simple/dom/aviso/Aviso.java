package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.estado_aviso.EstadoAviso;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_operacion.TipoOperacion;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;

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

@DomainObject(logicalTypeName = "simple.Aviso", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class
Aviso implements Comparable<Aviso> {

    @Title
    @Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "inmueble", sequence = "2")
    private Inmueble inmueble;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "valor", sequence = "3")
    private double valor;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "tipoOperacion", sequence = "4")
    private TipoOperacion tipoOperacion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "fecInicio", sequence = "5")
    private DateTime fecInicio;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "fecFin", sequence = "6")
    private DateTime fecFin;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "estadoAviso", sequence = "7")
    EstadoAviso estadoAviso;

    public Aviso(String descripcion, Inmueble inmueble, double valor, TipoOperacion tipoOperacion, DateTime fecInicio, DateTime fecFin, EstadoAviso estadoAviso) {
        this.descripcion = descripcion;
        this.inmueble = inmueble;
        this.valor = valor;
        this.tipoOperacion = tipoOperacion;
        this.fecInicio = fecInicio;
        this.fecFin = fecFin;
        this.estadoAviso = estadoAviso;
    }


    public static class DeleteDomainEvent extends ActionDomainEvent<Aviso>{}
    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void deleteAviso() {
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
    public int compareTo(@NotNull Aviso o) {
        return 0;
    }
}
