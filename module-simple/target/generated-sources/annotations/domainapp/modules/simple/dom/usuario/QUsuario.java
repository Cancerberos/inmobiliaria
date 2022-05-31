package domainapp.modules.simple.dom.usuario;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QUsuario extends PersistableExpressionImpl<Usuario> implements PersistableExpression<Usuario>
{
    public static final QUsuario jdoCandidate = candidate("this");

    public static QUsuario candidate(String name)
    {
        return new QUsuario(null, name, 5);
    }

    public static QUsuario candidate()
    {
        return jdoCandidate;
    }

    public static QUsuario parameter(String name)
    {
        return new QUsuario(Usuario.class, name, ExpressionType.PARAMETER);
    }

    public static QUsuario variable(String name)
    {
        return new QUsuario(Usuario.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression username;
    public final StringExpression apellido;
    public final StringExpression nombre;
    public final StringExpression telefono;
    public final StringExpression mail;
    public final StringExpression password;
    public final BooleanExpression esAdmin;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QUsuario(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.username = new StringExpressionImpl(this, "username");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.mail = new StringExpressionImpl(this, "mail");
        this.password = new StringExpressionImpl(this, "password");
        this.esAdmin = new BooleanExpressionImpl(this, "esAdmin");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QUsuario(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.username = new StringExpressionImpl(this, "username");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.mail = new StringExpressionImpl(this, "mail");
        this.password = new StringExpressionImpl(this, "password");
        this.esAdmin = new BooleanExpressionImpl(this, "esAdmin");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
