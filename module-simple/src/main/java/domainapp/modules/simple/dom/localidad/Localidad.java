package domainapp.modules.simple.dom.localidad;


import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;
import org.jetbrains.annotations.NotNull;
import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@Entity
@PersistenceCapable(schema = "Inmobiliaria",identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAllLocalidades", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.localidad.Localidad "
                        + "ORDER BY descripcion ASC"),
        @Query(
                name = "findLocalidad_Provincia", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.localidad.Localidad "
                        + " WHERE provincia == :provincia"
                        + " ORDER BY descripcion ASC"),

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
    public Localidad(String descripcion, String codigoPostal,Provincia provincia) {
        this.provincia=provincia;
        this.descripcion = descripcion;
        this.codigoPostal = codigoPostal;
    }
    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE ="findAllLocalidades" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT ="findLocalidad_Provincia" ;
    @javax.jdo.annotations.Column(allowsNull = "true", name = "Provinciaid")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private Provincia provincia ;

    @Column(allowsNull = "true")
    @NonNull @Getter  @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "Datos Localidad", sequence = "1",named = "Localidad")
    @Property(editing = Editing.DISABLED)
    private String descripcion;
    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Getter
    @Setter
    @ToString.Include
    @PropertyLayout(fieldSetId = "Datos Localidad", sequence = "1",named ="Codigo Postal")
    @Property(editing = Editing.DISABLED)
    private String codigoPostal;


    public String title() {
        return getDescripcion() ;
    }

    @Override
    public int compareTo(@NotNull Localidad o) {
        return 0;
    }

    private final static Comparator<Localidad> comparator =
            Comparator.comparing(Localidad::getDescripcion).thenComparing(Localidad::getDescripcion);

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Listar Localidades")
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }
    public Object Delete(){
        return  null;
    }
    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout( promptStyle =PromptStyle.DIALOG_MODAL ,associateWith = "Datos Localidad", sequence = "1", named = "Modifica Localidad")
    public Object UpdateLocalidad(Provincia  provincia, String descripcion , String cp) {
        setProvincia((Provincia) provincia);
        setDescripcion(descripcion);
        setCodigoPostal(cp);
        return this;
    }
    public Provincia default0UpdateLocalidad() {
        return getProvincia();
    }
    public List<Provincia> autoComplete0UpdateLocalidad(String name) {return repositoryService.allInstances(Provincia.class); }
    public @NonNull String default1UpdateLocalidad() {
        return getDescripcion();
    }
    public @NonNull String default2UpdateLocalidad() {
        return getCodigoPostal();
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
    @Inject
    WrapperFactory wrapperFactory;
}
