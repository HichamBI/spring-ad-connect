package hbo.org.model;

import java.util.List;

/**
 * Created by hei on 17/08/17.
 */
public class ADUser {
    private String cn;
    private String displayName;
    private String mail;
    private List<ADGroup> memberOf;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<ADGroup> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(List<ADGroup> memberOf) {
        this.memberOf = memberOf;
    }
}
