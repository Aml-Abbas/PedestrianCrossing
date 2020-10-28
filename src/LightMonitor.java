public class LightMonitor {
    private LightIO lightIO;
    private boolean passenger;
    private boolean vehicle;
    private long crossingTime;

    public LightMonitor(LightIO lightIO){
        this.lightIO= lightIO;
    }

    public synchronized boolean awaitTraffic() throws InterruptedException {
        while (!passenger && !vehicle){
            wait();
        }
        if (passenger){
            passenger= false;
            return true;
        }else {
            vehicle=false;
            return false;
        }
    }


    public synchronized void buttonDetected() {
        passenger= true;
        notifyAll();
    }

    public synchronized void vehicleDetected(boolean isTram) {
        vehicle= true;
        if (isTram){
          long time= System.currentTimeMillis()+30000;
          if (time> crossingTime){
              crossingTime= time;
          }
        }
        notifyAll();
    }

    public synchronized void waitSafeCrossing() throws InterruptedException {
        long now= System.currentTimeMillis();
        crossingTime= now +120000;
        while (now< crossingTime && !passenger){
            if (!passenger){
                wait();
            }else {
                wait(crossingTime-now);
            }
            now= System.currentTimeMillis();
        }
    }
}
