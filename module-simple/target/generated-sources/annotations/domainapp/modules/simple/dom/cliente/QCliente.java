package domainapp.modules.simple.dom.cliente;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QCliente extends PersistableExpressionImpl<Cliente> implements PersistableExpression<Cliente>
{
    public static final QCliente jdoCandidate = candidate("this");

    public static QCliente candidate(String name)
    {
        return new QCliente(null, name, 5);
    }

    public static QCliente candidate()
    {
        return jdoCandidate;
    }

    public static QCliente parameter(String name)
    {
        return new QCliente(Cliente.class, name, ExpressionType.PARAMETER);
    }

    public static QCliente variable(String name)
    {
        return new QCliente(Cliente.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression nombre;
    public final StringExpression apellido;
    public final StringExpression email;
    public final StringExpression telefono;
    public final StringExpression calle;
    public final StringExpression altura;
    public final StringExpression edificacion;
    public final StringExpression piso;
    public final StringExpression departamento;
    public final StringExpression latitud;
    public final StringExpression longitud;
    public final domainapp.modules.simple.dom.localidad.QLocalidad localidad;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QCliente(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.email = new StringExpressionImpl(this, "email");
        this.telefono = new StringExpressionImpl(this, "telefono");
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
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QCliente(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.email = new StringExpressionImpl(this, "email");
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.calle = new StringExpressionImpl(this, "calle");
        this.altura = new StringExpressionImpl(this, "altura");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
