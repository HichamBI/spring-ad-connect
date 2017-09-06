package hbo.org.mapping;

import hbo.org.model.ADUser;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

/**
 * Created by hei on 17/08/17.
 */
public class ADUserMapper implements AttributesMapper<ADUser> {

    @Override
    public ADUser mapFromAttributes(Attributes attributes) throws NamingException {
        if (attributes == null) {
            return null;
        }

        ADUser adUser = new ADUser();

        Attribute cn = attributes.get("cn");
        Attribute displayName = attributes.get("displayName");
        Attribute mail = attributes.get("mail");

        adUser.setCn(cn.get().toString());

        if (displayName != null) {
            adUser.setDisplayName(displayName.get().toString());
        }
        if (mail != null) {
            adUser.setMail(mail.get().toString());
        }
        return adUser;
    }
}
