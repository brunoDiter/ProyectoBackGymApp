package com.proyecto.Booking.util;

import java.util.Arrays;
import java.util.List;

public enum Role {
    USER(Arrays.asList(Permission.CHOOSE_CLASS,Permission.EDIT_PROFILE)),
    ADMIN(Arrays.asList(Permission.CRUD_USERS,Permission.CRUD_CLASSES)),
    PROFESSOR(Arrays.asList(Permission.EDIT_PROFILE,Permission.MANAGE_CLASSES));

    private List<Permission> permissionList;

    Role(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
