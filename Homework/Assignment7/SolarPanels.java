/**
 * Class represents solar panels, street map, and
 * an array of parking lot projects.
 * 
 * @author Aryan patel
 * @author Jessica De Brito
 * @author Kala Pandit lol
 */
public class SolarPanels {
    
    private Panel[][] panels;
    private String[][] streetMap;
    private ParkingLot[] lots;

    /**
     * Default constructor: initializes empty panels and objects.
     */
    public SolarPanels() {
        panels = null;
        streetMap = null;
        lots = null;
        StdRandom.setSeed(2023);
    }

    /**
     * Updates the instance variable streetMap to be an l x w
     * array of Strings. Reads each label from input file in parameters.
     * 
     * @param streetMapFile the input file to read from
     */
    public void setupStreetMap(String streetMapFile) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(streetMapFile);
        int rows = StdIn.readInt(); // taking input of array size from input file
        int cols = StdIn.readInt(); // taking input of array size from input file
        this.streetMap = new String[rows][cols]; // creating 2D array of required size with string type objects
        for ( int i = 0; i< rows; i++){
            for ( int j = 0; j< cols; j++){
                // itterating through the 2D Array
                this.streetMap[i][j] = StdIn.readString(); // reading Street Attributes and storing it in the coorosponding index in the 2D array
            }
        }
        // streetMap updated and ready to use
    }

    /**
     * Adds parking lot information to an array of parking lots.
     * Updates the instance variable lots to store these parking lots.
     * 
     * @param parkingLotFile the lot input file to read
     */
    public void setupParkingLots(String parkingLotFile) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(parkingLotFile); // setting input fule for StdIn
        int noOfLots = StdIn.readInt(); // reading the number of lots like P1 through P4 from the input file
        lots = new ParkingLot[noOfLots]; // creaa new array of ParkingLot objects
        for ( int i = 0; i< noOfLots; i++){
            // iniatializing the ParkingLot objects with parameters taken from the input file
            lots[i] = new ParkingLot(StdIn.readString(), StdIn.readInt(), StdIn.readDouble(), StdIn.readInt(), StdIn.readDouble()); 
        }

    }

    /**
     * Insert panels on each lot as much as space and budget allows.
     * Updates the instance variable panels to be a 2D array parallel to
     * streetMap, storing panels placed.
     * 
     * Panels have a 95% chance of working. Use StdRandom.uniform(); if
     * the resulting value is < 0.95 the panel works.
     * 
     * @param costPerPanel the fixed cost per panel, as a double
     */
    public void insertPanels(double costPerPanel) {
        // WRITE YOUR CODE HERE
        // creating a panels 2D parallel array that is parallel to streetMap
        panels = new Panel[streetMap.length][streetMap[0].length]; 
        // Arrays to Keep track of the budget and panels
        double[] MaxBudget = new double[lots.length];
        int[] MaxPanels = new int[lots.length];
        for (int i = 0; i < lots.length; i++){
            MaxBudget[i] = lots[i].getBudget(); // kinda parallel arrays to lots but insted of objects it has diff private variables 
            MaxPanels[i] = lots[i].getMaxPanels();

            // for testing if the arrays are created properly or not
            //System.out.println("maxbud:- " + MaxBudget[i] + "  maxPanels:- " + MaxPanels[i]);
        }

        for ( int i = 0; i< streetMap.length; i++){
            for ( int j = 0; j< streetMap[0].length; j++){

                for ( int k =0; k < lots.length; k++){
                    //System.out.println(lots[k].getLotName() + "==" + streetMap[i][j]);
                    if ((lots[k].getLotName().equals(streetMap[i][j]))){
                        if ((MaxBudget[k] - costPerPanel >= 0)&&(MaxPanels[k] - 1 >= 0)){
                            // randamizing if the panel is working or not
                            // 95% chances of working panel
                            boolean panelStatus = false;
                            if (StdRandom.uniform() < 0.95){
                                panelStatus = true;
                            }
                            panels[i][j] = new Panel(lots[k].getPanelEfficiency(), lots[k].getEnergyCapacity(), panelStatus);
                            //System.out.println("eff "+ lots[k].getPanelEfficiency() + "cap "+ lots[k].getEnergyCapacity()+ "status " + panelStatus);
                            MaxBudget[k]-= costPerPanel;
                            MaxPanels[k]-=1;
                        }
                    }
                }
            }
        }
        // for (int i = 0; i < lots.length; i++){
        //     // for testing if the arrays are created properly or not
        //     System.out.println("maxbud:- " + MaxBudget[i] + "  maxPanels:- " + MaxPanels[i]);
        // }
    }

    /**
     * Given a temperature and coefficient, update panels' actual efficiency
     * values. Panels are most optimal at 77 degrees F.
     * 
     * Panels perform worse in hotter environments and better in colder ones.
     * worse = efficiency loss, better = efficiency gain.
     * 
     * Coefficients are usually negative to represent energy loss.
     * 
     * @param temperature the current temperature, in degrees F
     * @param coefficient the coefficient to use
     */
    public void updateActualEfficiency(int temperature, double coefficient) {
        // WRITE YOUR CODE HERE
        double efficiencyLoss = coefficient * (temperature - 77);
        for ( int i = 0; i < panels.length; i++){
            for ( int j = 0; j < panels[i].length; j++){
                
                if (panels[i][j] != null){
                    for (int k = 0;k < lots.length; k++){
                        double eff = panels[i][j].getRatedEfficiency() - efficiencyLoss;
                        panels[i][j].setActualEfficiency(eff);
                        //System.out.println("[" + i + "] [" + j + "]");
                    } 
                }
            }    
        }
    }

    /**
     * For each WORKING panel, update the electricity generated for 4 hours 
     * of sunlight as follows:
     * 
     * (actual efficiency / 100) * 1500 * 4
     * 
     * RUN updateActualEfficiency BEFORE running this method.
     */
    public void updateElectricityGenerated() {
        // WRITE YOUR CODE HERE
        // itterating through the 2D Array for accessing 
        for ( int i = 0; i < panels.length; i++){
            for ( int j = 0; j< panels[i].length; j++){

                // checking if the solar panel is present there or not
                if (panels[i][j] != null && panels[i][j].isWorking() != false){
                    // updating the electricty generated from the formula
                    int genElectricty = (int)((panels[i][j].getActualEfficiency()/100)*1500*4);
                    panels[i][j].setElectricityGenerated(genElectricty);
                }
            }
        }
    }

    /**
     * Count the number of working panels in a parking lot.
     * 
     * @param parkingLot the parking lot name
     * @return the number of working panels
     */
    public int countWorkingPanels(String parkingLot) {
        // WRITE YOUR CODE HERE
        int workingPanels = 0;
        for ( int i = 0; i< panels.length; i++){
            for ( int j = 0; j < panels[0].length; j++){
                if (panels[i][j] != null){
                    if (streetMap[i][j].equals(parkingLot) && panels[i][j].isWorking()) workingPanels+=1;
                }
                
            }
        }

        return workingPanels; // PLACEHOLDER TO AVOID COMPILATION ERROR - REPLACE WITH YOUR CODE
    }

    /**
     * Find the broken panels in the map and repair them.
     * @return the count of working panels in total, after repair
     */
    public int updateWorkingPanels() {
        // WRITE YOUR CODE HERE
        int workingPanels = 0;
        for ( int i = 0; i< panels.length; i++){
            for ( int j = 0; j < panels[0].length; j++){
                if (panels[i][j] != null){
                    if (panels[i][j].isWorking()){
                        workingPanels+=1;
                    } else {
                        panels[i][j].setIsWorking(true);
                        workingPanels+=1;
                    }
                }
                
            }
        }

        return workingPanels; // PLACEHOLDER TO AVOID COMPILATION ERROR - REPLACE WITH YOUR CODE
    }

    /**
     * Calculate Rutgers' savings on energy by using
     * these solar panels.
     * 
     * ASSUME:
     * - Multiply total electricity generated by 0.001 to convert to KwH.
     * - There are 365 days in a year.
     * 
     * RUN electricityGenerated before running this method.
     */
    public double calculateSavings() {
        // WRITE YOUR CODE HERE
        int totalElectrictyGenerated = 0;

        for ( int i =0; i< panels.length; i++){
            for ( int j = 0; j< panels[0].length; j++){
                // finding the total electricity generated in waat hrs
                if ( panels[i][j] != null && panels[i][j].isWorking()){
                    totalElectrictyGenerated+= panels[i][j].getElectricityGenerated();
                }
            }    
        }

        double electricityInYear = (totalElectrictyGenerated *0.001) *365;
        double moneySaved = (electricityInYear/4270000)*60000000;
        return moneySaved; // PLACEHOLDER TO AVOID COMPILATION ERROR - REPLACE WITH YOUR CODE
    }

    /*
     * Getter and Setter methods
     */
    public Panel[][] getPanels() {
        // DO NOT TOUCH THIS METHOD
        return this.panels;
    }

    public void setPanels(Panel[][] panels) {
        // DO NOT TOUCH THIS METHOD
        this.panels = panels;
    }

    public String[][] getStreetMap() {
        // DO NOT TOUCH THIS METHOD
        return this.streetMap;
    }

    public void setStreetMap(String[][] streetMap) {
        // DO NOT TOUCH THIS METHOD
        this.streetMap = streetMap;
    }

    public ParkingLot[] getLots() {
        // DO NOT TOUCH THIS METHOD
        return this.lots;
    }

    public void setLots(ParkingLot[] lots) {
        // DO NOT TOUCH THIS METHOD
        this.lots = lots;
    }
}
