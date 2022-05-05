package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Asesor;

/**
 *
 * @author Samid Alexis Giraldo
 */
@Stateless
public class AsesorFacade extends AbstractFacade<Asesor> {

    @PersistenceContext(unitName = "SysTCWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsesorFacade() {
        super(Asesor.class);
    }

}
