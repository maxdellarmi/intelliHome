package it.nesea.intellihome.services;

import it.nesea.intellihome.devices.Device;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Con questo servizio è possibile configurare varie stanze della propria casa.
 * Il servizio tiene in considerazione elementi di tipo device che possono essere aggiunti
 * all'interno dell'area.
 * Su tutti questi devie, ereditati come componenti prototype, sarà possibile agire
 * per compiere varie operazioni.
 * IMPORTANTE: lo scope della classe è singleton poiché non intendiamo possedere più
 * sale utuali (una sola camera da pranzo) ed inoltre, non consideriamo più case.
 * Nel caso in cui invece volessimo considerare più abitazioni, questo bean dovrebe essere
 * prototype.
 */
@Service
public class RoomService {
    private List<Device> devices = new LinkedList<>();

    public void addDevice(Device device){
        devices.add(device);
    }

    public void removeDevice(Device  device){
        devices.remove(device);
    }

    public void powerOnAllDevices(){
        devices.forEach(Device::powerOn);
    }

    public List<Device> getRoomDevices(){
        return new LinkedList<>(devices);
    }

    public double calculateElectricPowerCost(double price) {
        return devices.stream().mapToDouble(device -> device.electricalCost(price)).sum();
    }

}
