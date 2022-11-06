package domainapp.modules.simple.dom.reporte;


import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.localidad.Localidad;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.isis.applib.value.Blob;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@DomainService(nature = NatureOfService.VIEW, logicalTypeName = "simple.EjecutarReportes")
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

    public Blob  ListadoLocalidadesPDF(List<Localidad> localidades)throws JRException, IOException{

        List<RepoLocalidades> localidadesDatasource = new ArrayList<RepoLocalidades>();

        localidadesDatasource.add(new RepoLocalidades());

        for (Localidad loc : localidades) {

            RepoLocalidades repoLocalidades = new RepoLocalidades(loc.getProvincia(),loc.getDescripcion(), loc.getCodigoPostal());

            localidadesDatasource.add(repoLocalidades);
        }
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(localidadesDatasource);
        return GenerarArchivoPDF("ListadoLocalidades.jrxml","ListadoLocalidades.pdf", ds);
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
