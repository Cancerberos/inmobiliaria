package domainapp.modules.simple.dom.localidad;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QLocalidad extends PersistableExpressionImpl<Localidad> implements PersistableExpression<Localidad>
{
    public static final QLocalidad jdoCandidate = candidate("this");

    public static QLocalidad candidate(String name)
    {
        return new QLocalidad(null, name, 5);
    }

    public static QLocalidad candidate()
    {
        return jdoCandidate;
    }

    public static QLocalidad parameter(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.PARAMETER);
    }

    public static QLocalidad variable(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final NumericExpression<Integer> codigoPostal;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QLocalidad(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codigoPostal = new NumericExpressionImpl<Integer>(this, "codigoPostal");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QLocalidad(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codigoPostal = new NumericExpressionImpl<Integer>(this, "codigoPostal");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
