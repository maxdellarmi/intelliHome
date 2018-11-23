package it.nesea.intellihome;

import it.nesea.intellihome.devices.Abatjour;
import it.nesea.intellihome.services.RoomService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
@PropertySource("classpath:devices.properties")
public class IntelliHomeApplication {
        public static void main(String[] args) {
            ConfigurableApplicationContext run = SpringApplication.run(IntelliHomeApplication.class, args);
            for (String beanName : run.getBeanDefinitionNames()){
                System.out.println("beanName = " + beanName);
            }
            RoomService badroom = (RoomService) run.getBean("roomService");

            Abatjour abatjourDX = (Abatjour)run.getBean("abatjour");
            Abatjour abatjourSX = (Abatjour)run.getBean("abatjour");
            badroom.addDevice(abatjourDX);
            badroom.addDevice(abatjourSX);


            System.out.println("badroom = " + badroom);

            readProperties(run);

        }

    private static void readProperties(ConfigurableApplicationContext run) {
        Resource resource = run.getResource("classpath:devices.properties");
        try{
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
