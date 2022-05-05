package restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Samid Alexis Giraldo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(restful.AsesorFacadeREST.class);
        resources.add(restful.ClienteFacadeREST.class);
        resources.add(restful.ReferenciaFacadeREST.class);
        resources.add(restful.SolicitudEstadoFacadeREST.class);
        resources.add(restful.SolicitudFacadeREST.class);
        resources.add(restful.TipoDocumentoFacadeREST.class);
    }

}
