package com.AthorizationAndAuthentication.AthorizationAndAuthentication.security;

//import com.google.common.collect.Sets;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;
import com.AthorizationAndAuthentication.AthorizationAndAuthentication.security.*;

public enum ApplicationUserRole {
    /*
    ENDUSER(Sets.newHashSet(ApplicationUserPermission.ADVERTISEMENT_READ, ApplicationUserPermission.ADVERTISEMENT_WRITE)),
    AGENT(Sets.newHashSet(ApplicationUserPermission.ADVERTISEMENT_READ, ApplicationUserPermission.ADVERTISEMENT_WRITE)),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.ADVERTISEMENT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
    */
}