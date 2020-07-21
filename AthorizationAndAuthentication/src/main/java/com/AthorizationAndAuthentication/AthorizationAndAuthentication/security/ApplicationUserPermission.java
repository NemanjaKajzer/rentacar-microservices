package com.AthorizationAndAuthentication.AthorizationAndAuthentication.security;

public enum ApplicationUserPermission {
    ADVERTISEMENT_READ("advertisement:read"),
    ADVERTISEMENT_WRITE("advertisement:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}