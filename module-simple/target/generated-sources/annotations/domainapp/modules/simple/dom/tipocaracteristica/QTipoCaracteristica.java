package domainapp.modules.simple.dom.tipocaracteristica;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QTipoCaracteristica extends PersistableExpressionImpl<TipoCaracteristica> implements PersistableExpression<TipoCaracteristica>
{
    public static final QTipoCaracteristica jdoCandidate = candidate("this");

    public static QTipoCaracteristica candidate(String name)
    {
        return new QTipoCaracteristica(null, name, 5);
    }

    public static QTipoCaracteristica candidate()
    {
        return jdoCandidate;
    }

    public static QTipoCaracteristica parameter(String name)
    {
        return new QTipoCaracteristica(TipoCaracteristica.class, name, ExpressionType.PARAMETER);
    }

    public static QTipoCaracteristica variable(String name)
    {
        return new QTipoCaracteristica(TipoCaracteristica.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio> tipoCaracteristicaRepositorio;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;

    public QTipoCaracteristica(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }

    public QTipoCaracteristica(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }
}
