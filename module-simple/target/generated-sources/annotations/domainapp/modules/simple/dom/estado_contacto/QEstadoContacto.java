package domainapp.modules.simple.dom.estado_contacto;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QEstadoContacto extends PersistableExpressionImpl<EstadoContacto> implements PersistableExpression<EstadoContacto>
{
    public static final QEstadoContacto jdoCandidate = candidate("this");

    public static QEstadoContacto candidate(String name)
    {
        return new QEstadoContacto(null, name, 5);
    }

    public static QEstadoContacto candidate()
    {
        return jdoCandidate;
    }

    public static QEstadoContacto parameter(String name)
    {
        return new QEstadoContacto(EstadoContacto.class, name, ExpressionType.PARAMETER);
    }

    public static QEstadoContacto variable(String name)
    {
        return new QEstadoContacto(EstadoContacto.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QEstadoContacto(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QEstadoContacto(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
