package domainapp.modules.simple.dom.cliente;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.reporte.EjecutarReporteCliente;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;
import javax.jdo.JDOQLTypedQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DomainService(nature = NatureOfService.REST,logicalTypeName = "simple.ClienteRepositorio")
public class ClienteRepositorio {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Clientes")
    public List<Cliente> listarCliente() {
        return repositoryService.allInstances(Cliente.class);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Provincia> listAll() {
        return repositoryService.allInstances(Provincia.class);
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Cliente> q = jdoSupportService.newTypesafeQuery(Cliente.class);
        final QCliente candidate = QCliente.candidate();
        q.range(0,2);
        q.orderBy(candidate.apellido.asc());
        q.executeList();
    }

    @Programmatic
    public Blob generarReporteClientes()throws JRException, IOException
    {
        List<Cliente> clientes = new ArrayList<Cliente>();
        EjecutarReporteCliente ejecutarReportes=new EjecutarReporteCliente();
        clientes = repositoryService.allInstances(Cliente.class);
        return ejecutarReportes.ListadoClientesPDF(clientes);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;




}