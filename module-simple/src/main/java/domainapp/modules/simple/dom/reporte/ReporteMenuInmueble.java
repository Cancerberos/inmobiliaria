package domainapp.modules.simple.dom.reporte;

import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;
import javax.inject.Inject;
import java.io.IOException;

@DomainService(nature = NatureOfService.VIEW, logicalTypeName ="simple.ReporteMenuInmueble")
class ReporteMenuInmueble {

    @Action(semantics = SemanticsOf.SAFE,restrictTo = RestrictTo.PROTOTYPING )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Exportar Inmueble - Pdf",sequence = "2")
    public Blob generarReporteInmueble() throws JRException, IOException {
        return inmuebleRepositorio.generarReporteInmueble();
    }

    @Inject
    InmuebleRepositorio inmuebleRepositorio;






}