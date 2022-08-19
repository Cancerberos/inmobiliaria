package domainapp.webapp.application.services.homepage;

import java.util.List;

import javax.inject.Inject;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.HomePage;
import org.apache.isis.applib.annotation.Nature;

@DomainObject(
        nature = Nature.VIEW_MODEL,
        logicalTypeName = "simple.HomePageViewModel"
        )
@HomePage
@DomainObjectLayout()
public class HomePageViewModel {
    public String title() {
        return  "Del Sur";
    }
    public List<Cliente> getCliente() {
        return clienteRepositorio.listarCliente();
    }
    public List<Direccion> getDireccion() { return direccionRepositorio.listAll(); }
    public List<Provincia> getProvincia() {
        return provinciaRepositorio.listAll();
    }
    public List<Localidad> getLocalidad() {
        return localidadRepositorio.listAll();
    }

    @Inject LocalidadRepositorio localidadRepositorio;
    @Inject ClienteRepositorio clienteRepositorio;
    @Inject ProvinciaRepositorio provinciaRepositorio;
    @Inject DireccionRepositorio direccionRepositorio;
}
