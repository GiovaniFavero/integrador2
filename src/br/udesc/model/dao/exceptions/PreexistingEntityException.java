package br.udesc.model.dao.exceptions;

/**
 * Classe de declaração de Exceção.
 * @author PIN2
 */
public class PreexistingEntityException extends Exception {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
