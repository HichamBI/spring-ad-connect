package hbo.org;

/**
 * Created by hei on 16/08/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    LdapServiceImpl ldapServiceImpl;

    @GetMapping("/")
    public String index() {

        ldapServiceImpl.getAllUsers();

        return "Welcome to the home page!";
    }
}
