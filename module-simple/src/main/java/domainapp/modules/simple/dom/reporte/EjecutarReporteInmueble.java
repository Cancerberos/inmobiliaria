package domainapp.modules.simple.dom.reporte;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.value.Blob;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DomainService(nature = NatureOfService.REST, logicalTypeName = "simple.EjecutarReporteInmueble")
public class EjecutarReporteInmueble {
    public Blob  ListadoInmueblePDF(List<Inmueble> inmuebles)throws JRException, IOException{
        List<RepoInmueble> inmuebleDatasource = new ArrayList<RepoInmueble>();
        inmuebleDatasource.add(new RepoInmueble());

        for (Inmueble imu : inmuebles) {
            RepoInmueble repoInmueble = new RepoInmueble(imu.getDescripcion(),imu.getFechaExclusividad(),imu.getCalle(),imu.getAltura()
                                ,imu.getEdificacion(),imu.getPiso(),imu.getDepartamento(), imu.getLocalidad(), imu.getTipoUnidad(),imu.getCliente()
                        );
            inmuebleDatasource.add(repoInmueble);
        }
        JRBeanCollectionDataSource dsInmueble = new JRBeanCollectionDataSource(inmuebleDatasource);
        return GenerarArchivoInmueblePDF("reporteInmueble/ListadoInmueble.jrxml","ListadoInmueble.pdf", dsInmueble);
    }

    private Blob GenerarArchivoInmueblePDF(String archivoDesing, String nombreSalida, JRBeanCollectionDataSource dsInmueble) throws JRException, IOException{
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoDesing);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ds", dsInmueble);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dsInmueble);
        byte[] contentBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            return new Blob(nombreSalida, "application/pdf", contentBytes);
    }




}
