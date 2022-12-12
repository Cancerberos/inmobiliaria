package domainapp.modules.simple.dom.inmueble_caracteristica;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristica;
import domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristicaRepositorio;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;


import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "findCaracteristicas", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.inmueble_Caracteristica.InmuebleCaracteristica "
                        + " WHERE inmueble == :inmueble"
                        + " ORDER BY tipoCaracteristica ASC"),

})
@DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="ImCaracteristicasId")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
//@Unique(name="Tipo_Caracteristica_UNQ", members = {"descripcion"})
public class InmuebleCaracteristica implements Comparable<InmuebleCaracteristica>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findCaracteristicas" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;
    public InmuebleCaracteristica(TipoCaracteristica tipoCaracteristica ,int cant,Inmueble inmueble) {
        this.cant=cant;
        this.inmueble=inmueble;
        this.tipoCaracteristica=tipoCaracteristica;
    }

    public String title() {
        return titleService.titleOf( getTipoCaracteristica());
    }
    @Getter @Setter
    @PropertyLayout(fieldSetId = "Cant", sequence = "1")
    private int cant;

    @javax.jdo.annotations.Column(allowsNull = "true", name = "TipoCaracteristicaId")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private TipoCaracteristica tipoCaracteristica;

    @Column(name="INMUEBLE_ID")
     private Inmueble inmueble;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Volver a Inmueble")
    public List<Inmueble> listAll() {
        return repositoryService.allInstances(Inmueble.class);
    }
      @Override
    public int compareTo(@NotNull InmuebleCaracteristica o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;
    TipoCaracteristicaRepositorio tipoCaracteristicaRepositorio;
    @Inject

    MessageService messageService;
    TitleService titleService;
}


