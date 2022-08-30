package domainapp.modules.simple.dom.localidad;


import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
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
import java.util.Comparator;
import java.util.List;

@PersistenceCapable(schema = "Inmobiliaria",identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAllLocalidades", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.localidad.Localidad "
                        + "ORDER BY descripcion ASC"),

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
    public Localidad(Provincia provincia,String descripcion, String codigoPostal) {
        this.provincia=provincia;
        this.descripcion = descripcion;
        this.codigoPostal = codigoPostal;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE ="findAllLocalidades" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT ="findByDescription" ;
    @javax.jdo.annotations.Column(allowsNull = "false", name = "Provinciaid")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private Provincia provincia ;
    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Getter
    @Setter
    @PropertyLayout(fieldSetId = "Datos Localidad", sequence = "1",named = "Descripcion")
    @Property(editing = Editing.DISABLED)
    private String descripcion;
    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Getter
    @Setter
    @PropertyLayout(fieldSetId = "Datos Localidad", sequence = "1",named ="Codigo Postal")
    private String codigoPostal;


    public String title() {
        return getDescripcion() ;
    }
    public String iconName() { return "Localidad.png";  }
    @Override
    public int compareTo(@NotNull Localidad o) {
        return 0;
    }

    private final static Comparator<Localidad> comparator =
            Comparator.comparing(Localidad::getDescripcion).thenComparing(Localidad::getDescripcion);
    //@Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "localidad", sequence = "1", named = "Modifica Localidad")
    public Localidad act(
            final String descripcion,
            final String codigoPostal) {
        setProvincia(provincia);
        setDescripcion(descripcion);
        setCodigoPostal(codigoPostal);
        return this;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;
    @Inject
    LocalidadRepositorio localidadRepositorio;
    ProvinciaRepositorio provinciaRepositorio;

}
