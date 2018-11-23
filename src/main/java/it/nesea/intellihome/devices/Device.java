package it.nesea.intellihome.devices;

public interface Device  {
    /**
     * Calcolo del costo KW/h
     * @param price
     * @return
     */
    double electricalCost(double price);
    void powerOn();
    void powerOff();
    boolean isOn();
}
