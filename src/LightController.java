public class LightController {
    public static void main(String[] args) throws InterruptedException {
        LightIO io = new LightIO();
        LightMonitor lightMonitor= new LightMonitor(io);
        Thread passThread= new PassThread(lightMonitor, io);
        Thread vehicleThread= new VehicleThread(lightMonitor, io);
        passThread.start();
        vehicleThread.start();

        while (true){

            io.lights(LightIO.RED, LightIO.RED);
            boolean pedestrian= lightMonitor.awaitTraffic();

            if (pedestrian){
                io.lights(LightIO.RED, LightIO.GREEN);
                Thread.sleep(30000);

            }else {
                io.lights(LightIO.RED_AND_YELLOW, LightIO.RED);
                Thread.sleep(3000);
                io.lights(LightIO.GREEN, LightIO.RED);
                lightMonitor.waitSafeCrossing();
                io.lights(LightIO.YELLOW, LightIO.RED);
                Thread.sleep(5000);
                io.lights(LightIO.RED, LightIO.RED);
                Thread.sleep(5000);

            }
        }
    }

}
