package com.hexaware.model;

/**
 * Represents a vehicle entity.
 */
public class Vechile {
    private int vid; // Vehicle ID
    private String model; // Model of the vehicle
    private int manuyear; // Manufacturing year of the vehicle
    private String color; // Color of the vehicle
    private String regno; // Registration number of the vehicle
    private boolean avaliability; // Availability of the vehicle
    private double dailyRate; // Daily rental rate of the vehicle

    /**
     * Default constructor.
     */
    public Vechile() {

    }

    /**
     * Constructs a Vehicle object with specified attributes.
     *
     * @param vid         The vehicle ID.
     * @param model       The model of the vehicle.
     * @param manuyear    The manufacturing year of the vehicle.
     * @param color       The color of the vehicle.
     * @param regno       The registration number of the vehicle.
     * @param avaliability The availability of the vehicle.
     * @param dailyRate   The daily rental rate of the vehicle.
     */
    public Vechile(int vid, String model, int manuyear, String color, String regno, boolean avaliability,
                   double dailyRate) {
        super();
        this.vid = vid;
        this.model = model;
        this.manuyear = manuyear;
        this.color = color;
        this.regno = regno;
        this.avaliability = avaliability;
        this.dailyRate = dailyRate;
    }

    /**
     * Constructs a Vehicle object with the specified vehicle ID.
     *
     * @param vehicleId The vehicle ID.
     */
    public Vechile(int vehicleId) {
        // Constructor with vehicle ID
    }

    // Getters and setters

    /**
     * Gets the vehicle ID.
     *
     * @return The vehicle ID.
     */
    public int getVid() {
        return vid;
    }

    /**
     * Sets the vehicle ID.
     *
     * @param vid The vehicle ID to set.
     */
    public void setVid(int vid) {
        this.vid = vid;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param model The model of the vehicle to set.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the manufacturing year of the vehicle.
     *
     * @return The manufacturing year of the vehicle.
     */
    public int getManuyear() {
        return manuyear;
    }

    /**
     * Sets the manufacturing year of the vehicle.
     *
     * @param manuyear The manufacturing year of the vehicle to set.
     */
    public void setManuyear(int manuyear) {
        this.manuyear = manuyear;
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return The color of the vehicle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the vehicle.
     *
     * @param color The color of the vehicle to set.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the registration number of the vehicle.
     *
     * @return The registration number of the vehicle.
     */
    public String getRegno() {
        return regno;
    }

    /**
     * Sets the registration number of the vehicle.
     *
     * @param regno The registration number of the vehicle to set.
     */
    public void setRegno(String regno) {
        this.regno = regno;
    }

    /**
     * Gets the availability of the vehicle.
     *
     * @return The availability of the vehicle.
     */
    public boolean getAvaliability() {
        return avaliability;
    }

    /**
     * Sets the availability of the vehicle.
     *
     * @param b The availability of the vehicle to set.
     */
    public void setAvaliability(boolean b) {
        this.avaliability = b;
    }

    /**
     * Gets the daily rental rate of the vehicle.
     *
     * @return The daily rental rate of the vehicle.
     */
    public double getDailyRate() {
        return dailyRate;
    }

    /**
     * Sets the daily rental rate of the vehicle.
     *
     * @param dailyRate The daily rental rate of the vehicle to set.
     */
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * Returns a string representation of the Vehicle object.
     *
     * @return A string representation of the Vehicle object.
     */
    @Override
    public String toString() {
        return "Vechile [vid=" + vid + ", model=" + model + ", make=" + ", manuyear=" + manuyear + ", color="
                + color + ", regno=" + regno + ", availability=" + avaliability + ", dailyRate=" + dailyRate + "]";
    }

    /**
     * Checks if the vehicle is available.
     *
     * @return True if the vehicle is available, false otherwise.
     */
    public boolean isAvailability() {
        // Implementation of isAvailability method
        return false;
    }
}
