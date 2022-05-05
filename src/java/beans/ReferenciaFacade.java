package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Referencia;

/**
 *
 * @author Samid Alexis Giraldo
 */
@Stateless
public class ReferenciaFacade extends AbstractFacade<Referencia> {

    @PersistenceContext(unitName = "SysTCWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferenciaFacade() {
        super(Referencia.class);
    }

}
