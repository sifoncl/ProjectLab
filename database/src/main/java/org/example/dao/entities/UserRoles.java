package org.example.dao.entities;

public enum UserRoles {

    ADMIN(1),

    PATIENT(2),

    DOCTOR(3);

    private Integer id;

    public Integer getId() {
        return id;
    }

    UserRoles(Integer id) {
        this.id = id;
    }
}
