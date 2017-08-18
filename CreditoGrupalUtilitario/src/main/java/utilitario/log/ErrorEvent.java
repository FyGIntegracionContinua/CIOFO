package utilitario.log;

import java.io.Serializable;

/**
 * The Class ErrorEvent.
 */
public class ErrorEvent implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8987250338693811241L;

    /** The message. */
    private String message;

    /**
     * Instancia una nueva error event.
     *
     * @param message the message
     */
    public ErrorEvent(String message) {
        this.message = message;
    }

    /**
     * Instancia una nueva error event.
     */
    public ErrorEvent() {
    }

    /**
     * Obtiene message.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece message.
     *
     * @param message a message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
