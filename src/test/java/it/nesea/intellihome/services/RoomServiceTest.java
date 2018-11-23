package it.nesea.intellihome.services;

import it.nesea.intellihome.devices.Abatjour;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    @Autowired
    private Abatjour luceComoDestro;
    @Autowired
    Abatjour luceComoSinistro;

    @PostConstruct
    public void init(){
        roomService.addDevice(luceComoDestro);
        roomService.addDevice(luceComoSinistro);
    }

    @Test
    public void calculateElectricPowerCostTest(){
        double v = roomService.calculateElectricPowerCost(12);
        System.out.println("v = " + v);
        Assert.assertEquals(v, 30,0);
    }

    @Test
    public void powerOnAllDevicesTest(){
        roomService.powerOnAllDevices();
        boolean b = roomService.getRoomDevices().stream().anyMatch(device -> !device.isOn());
        Assert.assertFalse(b);
    }
}
