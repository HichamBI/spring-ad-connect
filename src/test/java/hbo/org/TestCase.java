/**
 * Created by hei on 17/08/17.
 */
package hbo.org;

import hbo.org.config.LdapTestConfig;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LdapTestConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
@EnableWebSecurity
public class TestCase {

    @BeforeClass
    public static void setUp() {
        System.setProperty("spring.profiles.active", "test");
    }
}
