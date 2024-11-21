/**
 * Represents a parking lot that can store solar panels.
 * @author Kal Pandit
 * @author Jessica de Brito
 */
public class ParkingLot {

    private String lotName;
    private int maxPanels;
    private double budget;
    private int energyCapacity;
    private double panelEfficiency;

    /**
     * Constructs a new ParkingLot with specified characteristics.
     *
     * @param lotName The name of the parking lot.
     * @param maxPanels The maximum number of panels that can be installed.
     * @param budget The budget allocated for the parking lot.
     * @param energyCapacity The energy capacity of the parking lot.
     * @param panelEfficiency The efficiency of the solar panels.
     */
    public ParkingLot(String lotName, int maxPanels, double budget, int energyCapacity, double panelEfficiency) {
        this.lotName = lotName;
        this.maxPanels = maxPanels;
        this.budget = budget;
        this.energyCapacity = energyCapacity;
        this.panelEfficiency = panelEfficiency;
    }

    /**
     * Gets the name of the parking lot.
     *
     * @return The name of the parking lot.
     */
    public String getLotName() {
        return this.lotName;
    }

    /**
     * Sets the name of the parking lot.
     *
     * @param lotName The new name of the parking lot.
     */
    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    /**
     * Gets the maximum number of panels that can be installed.
     *
     * @return The maximum number of panels.
     */
    public int getMaxPanels() {
        return this.maxPanels;
    }

    /**
     * Sets the maximum number of panels that can be installed.
     *
     * @param maxPanels The new maximum number of panels.
     */
    public void setMaxPanels(int maxPanels) {
        this.maxPanels = maxPanels;
    }

    /**
     * Gets the budget allocated for the parking lot.
     *
     * @return The budget of the parking lot.
     */
    public double getBudget() {
        return this.budget;
    }

    /**
     * Sets the budget allocated for the parking lot.
     *
     * @param budget The new budget for the parking lot.
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Gets the energy capacity of the parking lot.
     *
     * @return The energy capacity of the parking lot.
     */
    public int getEnergyCapacity() {
        return this.energyCapacity;
    }

    /**
     * Sets the energy capacity of the parking lot.
     *
     * @param energyCapacity The new energy capacity of the parking lot.
     */
    public void setEnergyCapacity(int energyCapacity) {
        this.energyCapacity = energyCapacity;
    }

    /**
     * Gets the efficiency of the solar panels.
     *
     * @return The panel efficiency.
     */
    public double getPanelEfficiency() {
        return this.panelEfficiency;
    }

    /**
     * Sets the efficiency of the solar panels.
     * 
     * @param panelEfficiency The new panel efficiency.
     */
    public void setPanelEfficiency(double panelEfficiency) {
        this.panelEfficiency = panelEfficiency;
    }

    /**
     * Returns a string representation of this lot
     * @return the string representation of the lot
     */
    public String toString() {
        return "{" + lotName + ", " + maxPanels + ", $" + budget + ", " + energyCapacity + ", " + panelEfficiency + "}";
    }
}