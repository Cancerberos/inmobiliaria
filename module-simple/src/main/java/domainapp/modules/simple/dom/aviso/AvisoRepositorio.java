package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.QCliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.reporte.EjecutarReportes;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;


import javax.jdo.JDOQLTypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.AvisoRepositorio")
public class AvisoRepositorio {
    @ActionLayout(named = "Listar todos los Avisos")
    public List<Aviso> findByName() {
        return repositoryService.allMatches(
                Query.named(Aviso.class, Aviso.NAMED_QUERY__FIND_BY_NAME_EXACT_AVISO)
        );
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Consulta Cliente-Localidad-Provincia")
    public List<Cliente> getAllClientes() {
        return repositoryService.allMatches(
                Query.named(Cliente.class, "getAllClientes")
        );
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Avisos Cargados")
    public List<Aviso> listarAvisos() {
        return repositoryService.allInstances(Aviso.class);
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<Localidad> findByProvincia_Localidad(
            final Provincia provincia
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_EXACT)
                        .withParameter("provincia", provincia)

        );
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Aviso> q = jdoSupportService.newTypesafeQuery(Aviso.class);
        final QAviso candidate = QAviso.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }
    @Programmatic
    public Blob generarReporteAvisos()throws JRException, IOException
    {
        List<Aviso> avisos = new ArrayList<Aviso>();
        EjecutarReportes ejecutarReportes=new EjecutarReportes();
        avisos = repositoryService.allInstances(Aviso.class);
        return ejecutarReportes.ListadoAvisosPDF(avisos);
    }
   // public static class CreateDomainEvent extends ActionDomainEvent<domainapp.modules.simple.dom.localidad.LocalidadRepositorio> {
   // }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}
