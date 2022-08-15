package domainapp.webapp.application.services.homepage;

import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

import javax.inject.Inject;
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Localidad {

    final HomePageViewModel homePageViewModel;

    public Object act(Provincia provincia, String descripcion , int cp,boolean showVisit) {
        Localidad localidad = wrapperFactory.wrapMixin(LocalidadRepositorio.class,provincia).act(provincia,descripcion,cp);
        return  showVisit ? localidad :homePageViewModel;
    }
    public List<Provincia> autoComplete0Act(final String name) {
        return (List<Provincia>) provinciaRepositorio.findByName(name);
    }
    @Inject
    ProvinciaRepositorio provinciaRepositorio;
    @Inject
    LocalidadRepositorio localidadRepositorioy;
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
