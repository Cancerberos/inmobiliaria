package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.cliente.Cliente;
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

@DomainService(nature = NatureOfService.VIEW, logicalTypeName = "simple.EjecutarReportes")
public class EjecutarReportes {


    public Blob  ListadoClientesPDF(List<Cliente> clientes)throws JRException, IOException{
        List<RepoClientes> clientesDatasource = new ArrayList<RepoClientes>();
        clientesDatasource.add(new RepoClientes());
        for (Cliente cli : clientes) {
            RepoClientes repoClientes = new RepoClientes(cli.getNombre(),cli.getApellido(),cli.getEmail(),cli.getTelefono(),cli.getCalle());
            clientesDatasource.add(repoClientes);
        }
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(clientesDatasource);
        return GenerarArchivoPDF("ListadoCliente.jrxml","ListadoClientes.pdf", ds);
    }

    public Blob  ListadoAvisosPDF(List<Aviso> avisos)throws JRException, IOException{
        List<RepoAvisos> avisoDatasource = new ArrayList<RepoAvisos>();
        avisoDatasource.add(new RepoAvisos());
        for (Aviso av : avisos) {

            RepoAvisos repoAvisos = new RepoAvisos(av.getDescripcion());

            avisoDatasource.add(repoAvisos);
        }
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(avisoDatasource);
        return GenerarArchivoPDF("ListadoAviso.jrxml","ListadoAviso.pdf", ds);
    }

    private Blob GenerarArchivoPDF(String archivoDesing, String nombreSalida, JRBeanCollectionDataSource ds) throws JRException, IOException{

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoDesing);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ds", ds);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
        byte[] contentBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return new Blob(nombreSalida, "application/pdf", contentBytes);
    }




}
