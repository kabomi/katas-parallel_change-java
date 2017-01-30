package method;

import com.pduda.method.AuthenticationService;
import com.pduda.method.User;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationServiceTest {

    private final User user = new User(11101, "NORMAL");
    private final User admin = new User(12344, "ADMIN");

    @Test
    public void administratorIsAlwaysAuthenticated() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int adminId = 12345;
        Assert.assertTrue(service.isAuthenticated(adminId));
    }
    @Test
    public void administratorWithRoleIsAlwaysAuthenticated() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int adminId = 12344;
        String role = "ADMIN";
        Assert.assertTrue(service.isAuthenticated(adminId, role));
    }
    @Test
    public void adminUserAlwaysAuthenticated() throws Exception {
        AuthenticationService service = new AuthenticationService();
        Assert.assertTrue(service.isAuthenticated(admin));
    }

    @Test
    public void normalUserIsNotAuthenticatedInitially() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int normalUserId = 11111;
        Assert.assertFalse(service.isAuthenticated(normalUserId));
    }
    @Test
    public void normalUserWithRoleIsNotAuthenticatedInitially() throws Exception {
        AuthenticationService service = new AuthenticationService();
        int normalUserId = 11101;
        String role = "NORMAL";
        Assert.assertFalse(service.isAuthenticated(normalUserId, role));
    }
    @Test
    public void aUserIsNotAuthenticatedInitially() throws Exception {
        AuthenticationService service = new AuthenticationService();
        Assert.assertFalse(service.isAuthenticated(user));
    }
}
