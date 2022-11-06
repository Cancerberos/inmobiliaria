package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import lombok.AccessLevel;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;

import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Blob;
import javax.jdo.annotations.Order;
import java.io.IOException;

@DomainService(nature = NatureOfService.VIEW, logicalTypeName ="simple.ReporteMenu")
class ReporteMenu {

    @Action(semantics = SemanticsOf.SAFE,restrictTo = RestrictTo.PROTOTYPING )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Exportar Clientes - Pdf",sequence = "1")
    public Blob generarReporteClientes() throws JRException, IOException {
        return clienteRepositorio.generarReporteClientes();
    }
    @Action(semantics = SemanticsOf.SAFE,restrictTo = RestrictTo.PROTOTYPING )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Exportar Localidades - Pdf",sequence = "1")
    public Blob generarReporteLocalidades() throws JRException, IOException {
        return localidadRepositorio.generarReporteLocalidades();
    }
    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    ClienteRepositorio clienteRepositorio;
    LocalidadRepositorio localidadRepositorio;
    @javax.inject.Inject
    RepositoryService repositoryService;


}