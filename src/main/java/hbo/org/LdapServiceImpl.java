package hbo.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by hei on 16/08/17.
 */
@Service
public class LdapServiceImpl {

    @Autowired
    LdapTemplate ldapTemplate;

    public void getAllUsers() {
        ldapTemplate.search(query().base("CN=Users,DC=ROOTHBO,DC=LOCAL").where("objectClass").is("person").and("objectClass").is("user"), new AttributesMapper<Object>() {
            @Override
            public Object mapFromAttributes(Attributes attributes) throws NamingException {
                return null;
            }
        });
    }

    public void getAllDistributionGroups() {
        ldapTemplate.search(query().base("DC=ROOTHBO,DC=LOCAL").where("objectClass").is("group"), new AttributesMapper<Object>() {
            @Override
            public Object mapFromAttributes(Attributes attributes) throws NamingException {
                return null;
            }
        });
    }

    public void create(String username, String password) {
        Name dn = LdapNameBuilder
                .newInstance()
                .add("cn", "Users")
                .add("cn", username)
                .build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues(
                "objectclass",
                new String[]
                        { "top",
                                "person",
                                "organizationalPerson",
                                "user" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("userPassword", password);

        ldapTemplate.bind(context);
    }
}
