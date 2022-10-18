package domainapp.webapp.application.services.homepage;

import java.util.List;

import javax.inject.Inject;

import domainapp.modules.simple.dom.aviso.Aviso;
import domainapp.modules.simple.dom.aviso.AvisoRepositorio;
import domainapp.modules.simple.dom.aviso_contacto.AvisoContacto;
import domainapp.modules.simple.dom.aviso_contacto.AvisoContactoRepositorio;
import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteRepositorio;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.inmueble.InmuebleRepositorio;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidadRepositorio;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio;
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

      public List<Aviso> getAviso() { return avisoRepositorio.listarAvisos(); }
    public List<Cliente> getCliente() {
        return clienteRepositorio.listarCliente();
    }
    public List<Inmueble> getInmueble() { return inmuebleRepositorio.listAllInmuebles()  ; }

    public List<AvisoContacto> getAvisoContacto() { return avisoContactoRepositorio.listarAvisoContacto() ; }

    @Inject
    AvisoRepositorio avisoRepositorio;
    @Inject
    ClienteRepositorio clienteRepositorio;

    @Inject
    TipoUnidadRepositorio tipoUnidadRepositorio;
    @Inject
    InmuebleRepositorio inmuebleRepositorio;
    @Inject
    AvisoContactoRepositorio avisoContactoRepositorio;
}
