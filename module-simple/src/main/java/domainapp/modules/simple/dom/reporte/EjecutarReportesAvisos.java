package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.aviso.Aviso;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.value.Blob;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DomainService(nature = NatureOfService.REST, logicalTypeName = "simple.EjecutarReportesAvisos")
public class EjecutarReportesAvisos {

    public Blob  ListadoAvisosPDF(List<Aviso> avisos)throws JRException, IOException{
        List<RepoAvisos> avisosDatasource = new ArrayList<RepoAvisos>();
        avisosDatasource.add(new RepoAvisos());

        for (Aviso avi : avisos) {
            RepoAvisos repoAviso = new RepoAvisos(avi.getDescripcion(),avi.getInmueble(),avi.getValor().toString(),avi.getTipoOperacion(),
                    avi.getFechaInicio(),avi.getFechaFin(),avi.getEstadoAviso()
                    );
            avisosDatasource.add(repoAviso);
        }
        JRBeanCollectionDataSource dsAvisos = new JRBeanCollectionDataSource(avisosDatasource);
        return GenerarArchivoPDF("reporteAvisos/ListadoAvisos.jrxml","ListadoAvisos.pdf", dsAvisos);
    }

    private Blob GenerarArchivoPDF(String archivoDesing, String nombreSalida, JRBeanCollectionDataSource dsAvisos) throws JRException, IOException{

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoDesing);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ds", dsAvisos);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dsAvisos);
        byte[] contentBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            return new Blob(nombreSalida, "application/pdf", contentBytes);
    }




}
