package it.nesea.intellihome.devices;

import it.nesea.intellihome.components.ElectricPowerSwitch;
import it.nesea.intellihome.drivers.LightBulb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Questo componente rappresenta il Factory.
 * Per l'Abat-jour occorrono due componenti, una lampadina ed un interruttore.
 * Le funzionalità del circuito lampadina, sono pilotate dal driver LightBulb.
 * Il contesto Spring inizializza allo startup come comonente questo elemento.
 * Lo switch invece viene definito all'interno del factory Abat-jour (il costruttore).
 * Da questo momento in poi sarà possibile utilizzare i due comonenti insieme
 * utilizzando il mix D.Inversion (Switch / Switchable) ed Injection
 * (Switchable -> Device)
 *
 * Questo componente DEVE essere prototype altrimenti, avremmo concretamente
 * una sola abatjour per tutta casa!
 */
@Component
@Scope("prototype")
public class Abatjour implements Device{
    @Value("${device.abatjour.power}")
    private int power;
    private LightBulb lightBulb;
    private ElectricPowerSwitch electricPowerSwitch;

    public Abatjour(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.electricPowerSwitch = new ElectricPowerSwitch(this.lightBulb);
    }

    public void powerOn(){
        if(!this.isOn())
            this.electricPowerSwitch.press();
    }

    public void powerOff(){
        if(this.isOn())
            this.electricPowerSwitch.press();
    }

    public boolean isOn(){
        return electricPowerSwitch.isOn();
    }

    @Override
    public double electricalCost(double price) {
        return power * price;
    }
}
