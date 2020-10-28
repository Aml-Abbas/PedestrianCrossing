public class VehicleThread extends Thread{
    private LightIO lightIO;
    private LightMonitor lightMonitor;

    public VehicleThread(LightMonitor lightMonitor, LightIO lightIO){
        this.lightIO= lightIO;
        this.lightMonitor= lightMonitor;
    }

    public void run(){

        try {
            while (true){
                boolean isTram= lightIO.awaitVehicle();
                lightMonitor.vehicleDetected(isTram);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
