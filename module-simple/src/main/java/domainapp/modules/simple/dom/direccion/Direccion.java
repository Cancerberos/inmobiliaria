package domainapp.modules.simple.dom.direccion;


import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;
@PersistenceCapable(schema = "Inmobiliaria", identityType=IdentityType.DATASTORE)
@Queries({
        @Query(
                name = "findAll", language = "JDOQL",
                value = "SELECT "
                        + " FROM domainapp.modules.simple.dom.direccion.Direccion "
                        + "ORDER BY calle ASC")
})
@javax.jdo.annotations.Unique(name="Direccion_localidad_calle_UNQ", members = {"localidad","calle"})
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY, column="Direccionid")
@Version(strategy= VersionStrategy.DATE_TIME, column="version")
@DomainObject(logicalTypeName = "simple.direccion", entityChangePublishing = Publishing.ENABLED)
@lombok.RequiredArgsConstructor
@DomainObjectLayout(cssClassFa = "file-text-o")
public class Direccion implements Comparable<Direccion>{
    public Direccion( Localidad localidad, String calle, int numero, String edificacion, String piso, String departamento, String latitud, String longitud) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.edificacion = edificacion;
        this.piso = piso;
        this.departamento = departamento;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public static final String NAMED_QUERY__FIND_BY_NAME_LIKE =null ;
    public static final String NAMED_QUERY__FIND_BY_NAME_EXACT =null ;
    @javax.jdo.annotations.Column(allowsNull = "false", name = "Localidadid")
    @Property(editing = Editing.DISABLED)
    @Getter
    @Setter
    private Localidad localidad ;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "calle", sequence = "4")
    private String calle;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "numero", sequence = "5")
    private int numero;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "edificacion", sequence = "6")
    private String edificacion;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "piso", sequence = "7")
    private String  piso;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "departamento", sequence = "8")
    private String departamento;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "latitud", sequence = "9")
    private String latitud;

    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "longitud", sequence = "10")
    private String longitud;




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
    public int compareTo(@NotNull Direccion o) {
        return 0;
    }

    @Inject
    RepositoryService repositoryService;
    @Inject
    TitleService titleService;
    @Inject
    MessageService messageService;

}
