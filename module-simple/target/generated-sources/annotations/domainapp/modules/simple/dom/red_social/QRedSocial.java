package domainapp.modules.simple.dom.red_social;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QRedSocial extends PersistableExpressionImpl<RedSocial> implements PersistableExpression<RedSocial>
{
    public static final QRedSocial jdoCandidate = candidate("this");

    public static QRedSocial candidate(String name)
    {
        return new QRedSocial(null, name, 5);
    }

    public static QRedSocial candidate()
    {
        return jdoCandidate;
    }

    public static QRedSocial parameter(String name)
    {
        return new QRedSocial(RedSocial.class, name, ExpressionType.PARAMETER);
    }

    public static QRedSocial variable(String name)
    {
        return new QRedSocial(RedSocial.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final StringExpression url;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QRedSocial(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.url = new StringExpressionImpl(this, "url");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QRedSocial(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.url = new StringExpressionImpl(this, "url");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
