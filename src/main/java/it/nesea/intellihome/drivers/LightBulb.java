package it.nesea.intellihome.drivers;

import org.springframework.stereotype.Component;

@Component
public class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("Light Now!!!");
    }

    public void turnOff() {
        System.out.println("Light off");
    }
}
