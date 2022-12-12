package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.aviso.AvisoRepositorio;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;
import java.io.IOException;

@DomainService(nature = NatureOfService.VIEW, logicalTypeName ="simple.ReporteMenuAvisos")
class ReporteMenuAvisos {
    @Action(semantics = SemanticsOf.SAFE,restrictTo = RestrictTo.PROTOTYPING )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Exportar Avisos - Pdf",sequence = "2")
    public Blob generarReporteAvisos() throws JRException, IOException {
        return avisoRepositorio.generarReporteAvisos();
    }

     @javax.inject.Inject
    AvisoRepositorio avisoRepositorio;






}