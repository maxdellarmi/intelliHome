package it.nesea.intellihome.components;

import it.nesea.intellihome.drivers.Switchable;

/**
 * Questa classe mette a disposizione una semplice funzionalità.
 * In particolare esso è un utilizzatore di oggetti di tipi Switchable ed a sua volta,
 * viene utilizzato fa componenti che richiedono degli interruttori elettrici.
 * Potrebbe essere annotata come component e le property al suo interno usate come
 * Autowired. La scelta ricade tuttavia non sull'uso del Dipendency Injection ma
 * sul Dipendency Inversion
 */
public class ElectricPowerSwitch implements Switch{
    private Switchable device;
    private boolean on;

    public ElectricPowerSwitch(Switchable device) {
        this.device = device;
    }

    public boolean isOn() {
        return on;
    }

    public void press() {
        boolean checkOn = this.isOn();
        if (checkOn){
            device.turnOff();
            this.on = false;
        }else{
            device.turnOn();
            this.on = true;
        }

    }
}
