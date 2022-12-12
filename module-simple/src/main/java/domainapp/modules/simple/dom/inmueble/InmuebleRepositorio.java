package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.reporte.EjecutarReporteInmueble;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import javax.jdo.JDOQLTypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DomainService(nature = NatureOfService.REST,logicalTypeName = "simple.InmuebleRepositorio")
public class InmuebleRepositorio {

    @ActionLayout(named = "Buscar Inmueble por Nombre")
       public List<Inmueble> BuscarPorNombreInmueble(
            final String name
    ) {
        return repositoryService.allMatches(
                Query.named(Inmueble.class, Inmueble.NAMED_QUERY__FIND_BY_NAME_LIKE_INMUEBLE)
                      );
    }


    @ActionLayout(named = "Listar  Inmuebles")
    public List<Inmueble> listAll( ) {
        return repositoryService.allMatches(
                Query.named(Inmueble.class, Inmueble.NAMED_QUERY__FIND_ALL_INMUEBLE)
        );
    }
   // @ActionLayout(named = "Listar  Inmuebles")
  //  public List<Inmueble> listAll() {return repositoryService.allInstances(Inmueble.class);
   // }


   @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<Inmueble> BuscarPorInmueble(
             final Inmueble inmueble
    ) {
        return repositoryService.allMatches(
                Query.named(Inmueble.class, Inmueble.NAMED_QUERY__FIND_BY_NAME_LIKE_INMUEBLE)
                        .withParameter("inmueble", inmueble)

        );
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Inmueble> q = jdoSupportService.newTypesafeQuery(Inmueble.class);
        final QInmueble candidate = QInmueble.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
    @Programmatic
    public Blob generarReporteInmueble()throws JRException, IOException
    {
        List<Inmueble> inmuebles = new ArrayList<Inmueble>();
        EjecutarReporteInmueble ejecutarReportes=new EjecutarReporteInmueble();
        inmuebles = repositoryService.allInstances(Inmueble.class);
        return ejecutarReportes.ListadoInmueblePDF(inmuebles);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}