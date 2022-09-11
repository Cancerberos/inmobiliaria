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

    public final StringExpression descripcion;
    public final DateTimeExpression fechaExclusividad;
    public final StringExpression calle;
    public final StringExpression altura;
    public final StringExpression edificacion;
    public final StringExpression piso;
    public final StringExpression departamento;
    public final StringExpression latitud;
    public final StringExpression longitud;
    public final domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad tipoUnidad;
    public final StringExpression superficie;
    public final NumericExpression<Integer> cantHabientes;
    public final NumericExpression<Integer> cantHabitaciones;
    public final NumericExpression<Integer> cantBanios;
    public final NumericExpression<Integer> cantCocheras;
    public final BooleanExpression patio;
    public final BooleanExpression parrilla;
    public final BooleanExpression piscina;
    public final BooleanExpression cochera;
    public final NumericExpression<Integer> tipoCalefaccion;
    public final domainapp.modules.simple.dom.localidad.QLocalidad localidad;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<domainapp.modules.simple.dom.cliente.ClienteRepositorio> clienteRepositorio;

    public QInmueble(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        this.calle = new StringExpressionImpl(this, "calle");
        this.altura = new StringExpressionImpl(this, "altura");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        if (depth > 0)
        {
            this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", depth-1);
        }
        else
        {
            this.tipoUnidad = null;
        }
        this.superficie = new StringExpressionImpl(this, "superficie");
        this.cantHabientes = new NumericExpressionImpl<Integer>(this, "cantHabientes");
        this.cantHabitaciones = new NumericExpressionImpl<Integer>(this, "cantHabitaciones");
        this.cantBanios = new NumericExpressionImpl<Integer>(this, "cantBanios");
        this.cantCocheras = new NumericExpressionImpl<Integer>(this, "cantCocheras");
        this.patio = new BooleanExpressionImpl(this, "patio");
        this.parrilla = new BooleanExpressionImpl(this, "parrilla");
        this.piscina = new BooleanExpressionImpl(this, "piscina");
        this.cochera = new BooleanExpressionImpl(this, "cochera");
        this.tipoCalefaccion = new NumericExpressionImpl<Integer>(this, "tipoCalefaccion");
        if (depth > 0)
        {
            this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", depth-1);
        }
        else
        {
            this.localidad = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.clienteRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.cliente.ClienteRepositorio>(this, "clienteRepositorio");
    }

    public QInmueble(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        this.calle = new StringExpressionImpl(this, "calle");
        this.altura = new StringExpressionImpl(this, "altura");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", 5);
        this.superficie = new StringExpressionImpl(this, "superficie");
        this.cantHabientes = new NumericExpressionImpl<Integer>(this, "cantHabientes");
        this.cantHabitaciones = new NumericExpressionImpl<Integer>(this, "cantHabitaciones");
        this.cantBanios = new NumericExpressionImpl<Integer>(this, "cantBanios");
        this.cantCocheras = new NumericExpressionImpl<Integer>(this, "cantCocheras");
        this.patio = new BooleanExpressionImpl(this, "patio");
        this.parrilla = new BooleanExpressionImpl(this, "parrilla");
        this.piscina = new BooleanExpressionImpl(this, "piscina");
        this.cochera = new BooleanExpressionImpl(this, "cochera");
        this.tipoCalefaccion = new NumericExpressionImpl<Integer>(this, "tipoCalefaccion");
        this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.clienteRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.cliente.ClienteRepositorio>(this, "clienteRepositorio");
    }
}
