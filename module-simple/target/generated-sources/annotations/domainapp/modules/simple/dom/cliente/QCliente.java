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
    public final domainapp.modules.simple.dom.direccion.QDireccion direccion;
    public final StringExpression telefono;
    public final StringExpression email;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QCliente(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        if (depth > 0)
        {
            this.direccion = new domainapp.modules.simple.dom.direccion.QDireccion(this, "direccion", depth-1);
        }
        else
        {
            this.direccion = null;
        }
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.email = new StringExpressionImpl(this, "email");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QCliente(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.direccion = new domainapp.modules.simple.dom.direccion.QDireccion(this, "direccion", 5);
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.email = new StringExpressionImpl(this, "email");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
