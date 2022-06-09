package domainapp.modules.simple.dom.inmobiliaria;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QInmobiliaria extends PersistableExpressionImpl<Inmobiliaria> implements PersistableExpression<Inmobiliaria>
{
    public static final QInmobiliaria jdoCandidate = candidate("this");

    public static QInmobiliaria candidate(String name)
    {
        return new QInmobiliaria(null, name, 5);
    }

    public static QInmobiliaria candidate()
    {
        return jdoCandidate;
    }

    public static QInmobiliaria parameter(String name)
    {
        return new QInmobiliaria(Inmobiliaria.class, name, ExpressionType.PARAMETER);
    }

    public static QInmobiliaria variable(String name)
    {
        return new QInmobiliaria(Inmobiliaria.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression razonSocial;
    public final StringExpression cuit;
    public final StringExpression direccion;
    public final ObjectExpression<domainapp.modules.simple.types.PhoneNumber> telefono;
    public final StringExpression logo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QInmobiliaria(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.razonSocial = new StringExpressionImpl(this, "razonSocial");
        this.cuit = new StringExpressionImpl(this, "cuit");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.telefono = new ObjectExpressionImpl<domainapp.modules.simple.types.PhoneNumber>(this, "telefono");
        this.logo = new StringExpressionImpl(this, "logo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QInmobiliaria(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.razonSocial = new StringExpressionImpl(this, "razonSocial");
        this.cuit = new StringExpressionImpl(this, "cuit");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.telefono = new ObjectExpressionImpl<domainapp.modules.simple.types.PhoneNumber>(this, "telefono");
        this.logo = new StringExpressionImpl(this, "logo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
