package domainapp.modules.simple.dom.aviso_contacto;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QAvisoContacto extends PersistableExpressionImpl<AvisoContacto> implements PersistableExpression<AvisoContacto>
{
    public static final QAvisoContacto jdoCandidate = candidate("this");

    public static QAvisoContacto candidate(String name)
    {
        return new QAvisoContacto(null, name, 5);
    }

    public static QAvisoContacto candidate()
    {
        return jdoCandidate;
    }

    public static QAvisoContacto parameter(String name)
    {
        return new QAvisoContacto(AvisoContacto.class, name, ExpressionType.PARAMETER);
    }

    public static QAvisoContacto variable(String name)
    {
        return new QAvisoContacto(AvisoContacto.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression mombre;
    public final StringExpression apellido;
    public final domainapp.modules.simple.dom.aviso.QAviso aviso;
    public final StringExpression mensaje;
    public final StringExpression email;
    public final domainapp.modules.simple.dom.estado_contacto.QEstadoContacto estadoContacto;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<org.apache.isis.applib.annotation.DomainServiceLayout> domainServiceLayout;
    public final ObjectExpression<domainapp.modules.simple.dom.aviso_contacto.AvisoContactoRepositorio> avisoContactoRepositorio;

    public QAvisoContacto(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.mombre = new StringExpressionImpl(this, "mombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        if (depth > 0)
        {
            this.aviso = new domainapp.modules.simple.dom.aviso.QAviso(this, "aviso", depth-1);
        }
        else
        {
            this.aviso = null;
        }
        this.mensaje = new StringExpressionImpl(this, "mensaje");
        this.email = new StringExpressionImpl(this, "email");
        if (depth > 0)
        {
            this.estadoContacto = new domainapp.modules.simple.dom.estado_contacto.QEstadoContacto(this, "estadoContacto", depth-1);
        }
        else
        {
            this.estadoContacto = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.domainServiceLayout = new ObjectExpressionImpl<org.apache.isis.applib.annotation.DomainServiceLayout>(this, "domainServiceLayout");
        this.avisoContactoRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.aviso_contacto.AvisoContactoRepositorio>(this, "avisoContactoRepositorio");
    }

    public QAvisoContacto(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.mombre = new StringExpressionImpl(this, "mombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.aviso = new domainapp.modules.simple.dom.aviso.QAviso(this, "aviso", 5);
        this.mensaje = new StringExpressionImpl(this, "mensaje");
        this.email = new StringExpressionImpl(this, "email");
        this.estadoContacto = new domainapp.modules.simple.dom.estado_contacto.QEstadoContacto(this, "estadoContacto", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.domainServiceLayout = new ObjectExpressionImpl<org.apache.isis.applib.annotation.DomainServiceLayout>(this, "domainServiceLayout");
        this.avisoContactoRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.aviso_contacto.AvisoContactoRepositorio>(this, "avisoContactoRepositorio");
    }
}
