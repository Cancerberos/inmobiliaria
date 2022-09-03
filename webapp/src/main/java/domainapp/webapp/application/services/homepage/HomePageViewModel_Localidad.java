package domainapp.webapp.application.services.homepage;

import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadAdd;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

import javax.inject.Inject;
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Localidad {

    final HomePageViewModel homePageViewModel;
    @ActionLayout( promptStyle = PromptStyle.DIALOG_MODAL,named = "Alta de Localidad")
    public Object act(Provincia provincia, String descripcion , String cp) {
        Localidad localidad = wrapperFactory.wrapMixin(LocalidadAdd.class,provincia).act(descripcion,cp);
        return localidad;
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
