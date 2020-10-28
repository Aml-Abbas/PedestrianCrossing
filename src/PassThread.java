public class PassThread extends Thread{
    private LightIO lightIO;
    private LightMonitor lightMonitor;

    public PassThread(LightMonitor lightMonitor, LightIO lightIO){
        this.lightIO= lightIO;
        this.lightMonitor= lightMonitor;
    }

    public void run(){

            try {
                while (true){
                lightIO.awaitButton();
                    lightMonitor.buttonDetected();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
