package hbo.org.mapping;

import hbo.org.model.ADGroup;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

/**
 * Created by hei on 17/08/17.
 */
public class ADGroupMapper implements AttributesMapper<ADGroup> {

    @Override
    public ADGroup mapFromAttributes(Attributes attributes) throws NamingException {
        if(attributes == null) {
            return null;
        }

        ADGroup adGroup = new ADGroup();

        Attribute cn = attributes.get("cn");
        Attribute name = attributes.get("name");

        adGroup.setCn(cn.get().toString());

        if(name != null) {
            adGroup.setName(name.get().toString());
        }

        return adGroup;
    }
}
