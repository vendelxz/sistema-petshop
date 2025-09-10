package br.wendel.petshop.exception;

public class CpfExistsException extends RuntimeException {
    public CpfExistsException(String message) {
        super(message);
    }

}
