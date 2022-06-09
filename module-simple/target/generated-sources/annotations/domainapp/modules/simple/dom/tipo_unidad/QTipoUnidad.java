package domainapp.modules.simple.dom.tipo_unidad;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QTipoUnidad extends PersistableExpressionImpl<TipoUnidad> implements PersistableExpression<TipoUnidad>
{
    public static final QTipoUnidad jdoCandidate = candidate("this");

    public static QTipoUnidad candidate(String name)
    {
        return new QTipoUnidad(null, name, 5);
    }

    public static QTipoUnidad candidate()
    {
        return jdoCandidate;
    }

    public static QTipoUnidad parameter(String name)
    {
        return new QTipoUnidad(TipoUnidad.class, name, ExpressionType.PARAMETER);
    }

    public static QTipoUnidad variable(String name)
    {
        return new QTipoUnidad(TipoUnidad.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QTipoUnidad(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QTipoUnidad(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
