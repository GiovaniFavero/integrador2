package br.udesc.model.dao.exceptions;

/**
 * Classe de declaração de Exceção.
 * @author PIN2
 */
public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
