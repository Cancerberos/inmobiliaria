package domainapp.modules.simple.dom.localidad;


import domainapp.modules.simple.dom.provincia.Provincia;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.jetbrains.annotations.NotNull;
import javax.inject.Inject;
import javax.jdo.annotations.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Comparator;
import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;
@PersistenceCapable(schema = "Inmobiliaria",identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAllLocalidades", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.localidad.Localidad "
                        + "ORDER BY descripcion ASC"),

@Query(
        name = "find", language = "JDOQL",
        value = "SELECT "
                + "FROM domainapp.dom.PPB.Component "),
@Query(
        name = "findByDescriptionContains", language = "JDOQL",
        value = "SELECT "
                + "FROM domainapp.modules.simple.dom.localidad.Localidad "
                + "WHERE descripcion.indexOf(:descripcion) >= 0 "),
})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Localidadid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.localidad",entityChangePublishing = Publishing.ENABLED,editing=Editing.DISABLED)
@lombok.RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
@javax.jdo.annotations.Unique(name="Localidad_descripcion_provincia_UNQ", members = {"descripcion","provincia"})
public class Localidad implements Comparable<Localidad>{
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE ="findAllLocalidades" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT ="findByDescriptionContains" ;
    @javax.jdo.annotations.Column(allowsNull = "false", name = "Provinciaid")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private Provincia provincia ;
    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Getter
    @Setter
    @Title
    private String descripcion;
    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Getter
    @Setter
    @Title
    private String codigoPostal;

    public Localidad(Provincia provincia,String descripcion, String codigoPostal) {
        this.provincia=provincia;
        this.descripcion = descripcion;
        this.codigoPostal = codigoPostal;
    }
    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }
    @Override
    public int compareTo(@NotNull Localidad o) {
        return 0;
    }

    private final static Comparator<Localidad> comparator =
            Comparator.comparing(Localidad::getDescripcion).thenComparing(Localidad::getDescripcion);
    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
    @Inject
    LocalidadRepositorio localidadRepositorio;

}
