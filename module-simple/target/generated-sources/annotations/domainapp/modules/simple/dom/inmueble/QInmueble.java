package domainapp.modules.simple.dom.inmueble;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QInmueble extends PersistableExpressionImpl<Inmueble> implements PersistableExpression<Inmueble>
{
    public static final QInmueble jdoCandidate = candidate("this");

    public static QInmueble candidate(String name)
    {
        return new QInmueble(null, name, 5);
    }

    public static QInmueble candidate()
    {
        return jdoCandidate;
    }

    public static QInmueble parameter(String name)
    {
        return new QInmueble(Inmueble.class, name, ExpressionType.PARAMETER);
    }

    public static QInmueble variable(String name)
    {
        return new QInmueble(Inmueble.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> Inmuebleid;
    public final StringExpression descripcion;
    public final LocalDateTimeExpression fechaExclusividad;
    public final StringExpression calle;
    public final StringExpression altura;
    public final StringExpression edificacion;
    public final StringExpression piso;
    public final StringExpression departamento;
    public final StringExpression latitud;
    public final StringExpression longitud;
    public final domainapp.modules.simple.dom.localidad.QLocalidad localidad;
    public final domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad tipoUnidad;
    public final domainapp.modules.simple.dom.cliente.QCliente cliente;
    public final domainapp.modules.simple.dom.inmueble_caracteristica.QInmuebleCaracteristica inmueblecaracteristica;
    public final domainapp.modules.simple.dom.imagen.QImagen imagen;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<domainapp.modules.simple.dom.cliente.ClienteRepositorio> clienteRepositorio;
    public final ObjectExpression<org.apache.isis.applib.annotation.DomainServiceLayout> domainServiceLayout;
    public final ObjectExpression<domainapp.modules.simple.dom.inmueble.InmuebleRepositorio> inmuebleRepositorio;

    public QInmueble(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.Inmuebleid = new NumericExpressionImpl<Integer>(this, "Inmuebleid");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new LocalDateTimeExpressionImpl(this, "fechaExclusividad");
        this.calle = new StringExpressionImpl(this, "calle");
        this.altura = new StringExpressionImpl(this, "altura");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        if (depth > 0)
        {
            this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", depth-1);
        }
        else
        {
            this.localidad = null;
        }
        if (depth > 0)
        {
            this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", depth-1);
        }
        else
        {
            this.tipoUnidad = null;
        }
        if (depth > 0)
        {
            this.cliente = new domainapp.modules.simple.dom.cliente.QCliente(this, "cliente", depth-1);
        }
        else
        {
            this.cliente = null;
        }
        if (depth > 0)
        {
            this.inmueblecaracteristica = new domainapp.modules.simple.dom.inmueble_caracteristica.QInmuebleCaracteristica(this, "inmueblecaracteristica", depth-1);
        }
        else
        {
            this.inmueblecaracteristica = null;
        }
        if (depth > 0)
        {
            this.imagen = new domainapp.modules.simple.dom.imagen.QImagen(this, "imagen", depth-1);
        }
        else
        {
            this.imagen = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.clienteRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.cliente.ClienteRepositorio>(this, "clienteRepositorio");
        this.domainServiceLayout = new ObjectExpressionImpl<org.apache.isis.applib.annotation.DomainServiceLayout>(this, "domainServiceLayout");
        this.inmuebleRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.inmueble.InmuebleRepositorio>(this, "inmuebleRepositorio");
    }

    public QInmueble(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.Inmuebleid = new NumericExpressionImpl<Integer>(this, "Inmuebleid");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new LocalDateTimeExpressionImpl(this, "fechaExclusividad");
        this.calle = new StringExpressionImpl(this, "calle");
        this.altura = new StringExpressionImpl(this, "altura");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", 5);
        this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", 5);
        this.cliente = new domainapp.modules.simple.dom.cliente.QCliente(this, "cliente", 5);
        this.inmueblecaracteristica = new domainapp.modules.simple.dom.inmueble_caracteristica.QInmuebleCaracteristica(this, "inmueblecaracteristica", 5);
        this.imagen = new domainapp.modules.simple.dom.imagen.QImagen(this, "imagen", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.clienteRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.cliente.ClienteRepositorio>(this, "clienteRepositorio");
        this.domainServiceLayout = new ObjectExpressionImpl<org.apache.isis.applib.annotation.DomainServiceLayout>(this, "domainServiceLayout");
        this.inmuebleRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.inmueble.InmuebleRepositorio>(this, "inmuebleRepositorio");
    }
}
