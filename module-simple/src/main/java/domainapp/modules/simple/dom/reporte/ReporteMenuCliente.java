package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.aviso.AvisoRepositorio;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;

import javax.inject.Inject;
import java.io.IOException;

@DomainService(nature = NatureOfService.VIEW, logicalTypeName ="simple.ReporteMenuCliente")
class ReporteMenuCliente {

    @Action(semantics = SemanticsOf.SAFE,restrictTo = RestrictTo.PROTOTYPING )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Exportar Clientes - Pdf",sequence = "1")
    public Blob generarReporteClientes() throws JRException, IOException {
        return clienteRepositorio.generarReporteClientes();
    }

    @Inject
    ClienteRepositorio clienteRepositorio;







}