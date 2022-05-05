package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.SolicitudEstado;

/**
 *
 * @author Samid Alexis Giraldo
 */
@Stateless
public class SolicitudEstadoFacade extends AbstractFacade<SolicitudEstado> {

    @PersistenceContext(unitName = "SysTCWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudEstadoFacade() {
        super(SolicitudEstado.class);
    }

}
