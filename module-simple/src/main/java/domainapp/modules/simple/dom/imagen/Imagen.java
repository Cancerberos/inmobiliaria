package domainapp.modules.simple.dom.imagen;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio;
import lombok.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.applib.value.Blob;
import org.openjdk.jmh.util.Optional;


import javax.inject.Inject;
import javax.jdo.annotations.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@PersistenceCapable(
        schema = "Inmobiliaria",
        identityType=IdentityType.DATASTORE)

@Queries({
        @Query(
                name = "findImagenes", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.imagen.Imagen"
                        + " WHERE inmueble == :inmueble"
                        + " ORDER BY descripcion ASC"),

})
@DatastoreIdentity(strategy= IdGeneratorStrategy.IDENTITY, column="Imagenid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)


public class Imagen implements Comparable<Imagen>{

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "findImagenes" ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;
    public Imagen(Blob url,String descripcion,Inmueble inmueble) {
    this.url= url;
    this.descripcion=descripcion;
    this.inmueble=inmueble;
    }

    public String title() {
        return titleService.titleOf(getDescripcion()) ;
    }

   // @javax.jdo.annotations.Persistent(defaultFetchGroup="false")
   @PropertyLayout(fieldSetId = "imagen", sequence = "1")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "attachment_name"),
            @javax.jdo.annotations.Column(name = "attachment_mimetype"),
            @javax.jdo.annotations.Column(name = "attachment_bytes", jdbcType = "BLOB", sqlType = "BLOB")
    })
    @Property(optionality = Optionality.OPTIONAL)
    @Getter @Setter
    private Blob url;


    @Column(allowsNull = "false")
    @Getter @Setter
    @PropertyLayout(fieldSetId = "descripcion", sequence = "1")
    private String descripcion;

    @Column(name="IMAGEN_ID")
     private Inmueble inmueble;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Volver a Inmueble")
    public List<Inmueble> listAll() {
        return repositoryService.allInstances(Inmueble.class);
    }
        @Override
    public int compareTo(@NotNull Imagen o) {
        return 0;
    }
    @Inject
    RepositoryService repositoryService;
    TipoCaracteristicaRepositorio tipoCaracteristicaRepositorio;
    @Inject

    MessageService messageService;
    TitleService titleService;
}


