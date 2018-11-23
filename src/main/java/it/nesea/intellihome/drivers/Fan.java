package it.nesea.intellihome.drivers;

import org.springframework.stereotype.Component;

/**
 * Questa classe viene marcata come pomponente in quanto, logicamente
 * essa rappresenta un elemento cardine dell'applicazone.
 * Il Driver deve essere unico per tutti i componenti che lo necessitano.
 * Questo fa si che la scelta dello scope di Default, Singleton, sia appropriata
 */
@Component
public class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan Start");
    }

    public void turnOff() {
        System.out.println("Fan Stop");
    }
}
