/**
 * Created by hei on 17/08/17.
 */
package hbo.org.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan({"hbo.org"})
@Profile("test")
public class LdapTestConfig {

}
