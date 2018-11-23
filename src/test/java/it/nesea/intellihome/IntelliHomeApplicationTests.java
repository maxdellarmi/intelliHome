package it.nesea.intellihome;

import it.nesea.intellihome.devices.Abatjour;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(locations = "classpath*:beans-test.xml")
@ComponentScan(basePackages = {"it.nesea.intellihome"})
public class IntelliHomeApplicationTests {

    @Autowired
    private Abatjour abatjour;

    @Test
    public void contextLoads() {

        Assert.assertEquals(abatjour.electricalCost(10d), 15d, 0);
    }

}
