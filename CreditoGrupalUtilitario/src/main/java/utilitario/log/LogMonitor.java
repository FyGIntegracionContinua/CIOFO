package utilitario.log;

import org.fabric3.api.annotation.monitor.Debug;
import org.fabric3.api.annotation.monitor.Info;
import org.fabric3.api.annotation.monitor.Severe;
import org.fabric3.api.annotation.monitor.Warning;


/**
 * The Interface LogMonitor.
 * @author mi.mejorada
 * @version 1.0.0
 */
public interface LogMonitor {

    /**
     * Error.
     *
     * @param error the error
     */
    @Severe
    void error(ErrorEvent error);

    /**
     * Info.
     *
     * @param o the o
     */
    @Info("INFO :: {0}")
    void info(Object o);

    /**
     * Debug.
     *
     * @param o the o
     */
    @Debug("DEBUG :: {0}")
    void debug(Object o);

    /**
     * Warning.
     *
     * @param o the o
     */
    @Warning("WARNING :: {0}")
    void warning(Object o);

}
