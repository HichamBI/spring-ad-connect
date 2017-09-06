package hbo.org.repository;

import hbo.org.mapping.ADGroupMapper;
import hbo.org.mapping.ADUserMapper;
import hbo.org.model.ADGroup;
import hbo.org.model.ADUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by hei on 16/08/17.
 */
@Repository
public class LdapRepository {

    private LdapTemplate ldapTemplate;

    @Autowired
    public LdapRepository(LdapTemplate ldapTemplate) {
     this.ldapTemplate = ldapTemplate;
    }

    public List<ADUser> getAllActiveDirectoryUsers() {
        ContainerCriteria allUserQuery = query()
                .base("CN=Users,DC=ROOTHBO,DC=LOCAL")
                .where("objectClass").is("person")
                .and("objectClass").is("user");

        return ldapTemplate.search(allUserQuery, new ADUserMapper());
    }

    public ADUser getActiveDirectoryUserByName(String cn) {
        ContainerCriteria allUserQuery = query()
                .base("CN=Users,DC=ROOTHBO,DC=LOCAL")
                .where("CN").is(cn)
                .and("objectClass").is("person")
                .and("objectClass").is("user");

        return ldapTemplate.search(allUserQuery, new ADUserMapper()).get(0);
    }

    public List<ADGroup> getAllGroupsManagedByUser(String userCn) {
        ContainerCriteria criteria = query()
                .base("OU=Group,DC=ROOTHBO,DC=LOCAL")
                .where("objectClass").is("group")
                .and("objectClass").is("top")
                .and("managedBy").is("CN=helpdesk,CN=Users,DC=ROOTHBO,DC=LOCAL");

        return ldapTemplate.search(criteria, new ADGroupMapper());
    }
}
