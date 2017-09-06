
/**
 * Created by hei on 17/08/17.
 */

package hbo.org.repository;

import hbo.org.TestCase;
import hbo.org.model.ADGroup;
import hbo.org.model.ADUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LdapRepositoryTest extends TestCase {

    @Autowired
    private LdapRepository ldapRepository;

    @Test
    public void getAllActiveDirectoryUsers() throws Exception {
        List<ADUser> allActiveDirectoryUsers = ldapRepository.getAllActiveDirectoryUsers();

        assertThat(allActiveDirectoryUsers).hasSize(11);

        assertThat(allActiveDirectoryUsers).extracting("cn").containsOnly(
                "Administrateur", "Invité", "krbtgt", "helpdesk", "Ben Alex", "Bob Hamilton", "Joe Smith",
                "Mouse Jerry", "Slash Guy", "Guote Guy", "Space Cadet");

        assertThat(allActiveDirectoryUsers).extracting("displayName").containsOnly(
                null, null, null, "helpdesk", "Ben Alex", "Bob Hamilton", "Joe Smith",
                "Mouse Jerry", "Slash Guy", "Guote Guy", "Space Cadet");
    }

    @Test
    public void getActiveDirectoryUserByName() throws Exception {
        ADUser user = ldapRepository.getActiveDirectoryUserByName("Ben Alex");

        assertThat(user).isNotNull();
        assertThat(user).extracting("displayName").containsOnly("Ben Alex");
        assertThat(user).extracting("mail").containsOnly("Ben.Alex@hbo.com");
    }

    @Test
    public void getAllGroupsManagedByUser() throws Exception {
        List<ADGroup> adGroups = ldapRepository.getAllGroupsManagedByUser("helpdesk");

        assertThat(adGroups).isNotEmpty();
    }
}