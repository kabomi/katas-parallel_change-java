package com.pduda.method;

public class AuthenticationService {
    public boolean isAuthenticated(int id) {
        return id == 12345;
    }

    public boolean isAuthenticated(int id, String role) {
        return role.equals("ADMIN");
    }

    public boolean isAuthenticated(User user) {
        return user.getRole().equals("ADMIN");
    }
}
