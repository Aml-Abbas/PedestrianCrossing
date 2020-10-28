public class LightIO {
    public static final int RED = 1, YELLOW = 2, RED_AND_YELLOW = 3, GREEN = 4;
    /**
     * Set traffic lights to value v for vehicles (RED, YELLOW, RED_AND_YELLOW, or GREEN),
     * and p for pedestrians (RED or GREEN).
     */
    public void lights(int v, int p) {

    }
    /**
     * Blocks until the pedestrians’ button is pressed. If the button was
     * pressed before awaitButton() was called, the method returns immediately.
     */
    public void awaitButton() throws InterruptedException {

    }
    /**
     * Blocks until an approaching vehicle is detected. If a vehicle passed before
     * awaitVehicle() was called, the method returns immediately.
     * Returns true if the detected vehicle is a tram, false otherwise.
     */
    public boolean awaitVehicle() throws InterruptedException {
        return true;
    }
}