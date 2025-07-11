 public class BookingThread extends Thread {
    private final int vehicleId;
    private final int durationSecs;
    private final VehicleRentalService rentalService;

    public BookingThread(int vehicleId, int durationSecs, VehicleRentalService rentalService) {
        this.vehicleId = vehicleId;
        this.durationSecs = durationSecs;
        this.rentalService = rentalService;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(durationSecs * 1000L); // sleep for the booking duration
        } catch (InterruptedException e) {
            System.out.println("BookingThread interrupted for vehicle ID: " + vehicleId);
        }

        // Automatically make vehicle available again
        rentalService.autoReturnVehicle(vehicleId);
    }
}
