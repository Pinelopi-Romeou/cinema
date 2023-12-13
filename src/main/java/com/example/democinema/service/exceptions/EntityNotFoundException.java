package com.example.democinema.service.exceptions;

public class EntityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entityClass, Long id) {
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " does not exist");
    }

    public EntityNotFoundException(Class<?> entityClass, String username) {
        super("Entity " + entityClass.getSimpleName() + " with username " + username + " does not exist");
    }
}
