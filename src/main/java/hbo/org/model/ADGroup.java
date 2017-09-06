package hbo.org.model;

import java.util.List;

/**
 * Created by hei on 17/08/17.
 */
public class ADGroup {

    private String cn;
    private String name;
    private List<ADUser> managedBy;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ADUser> getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(List<ADUser> managedBy) {
        this.managedBy = managedBy;
    }
}
