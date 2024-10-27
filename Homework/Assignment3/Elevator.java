
/*************************************************************************
 *  Compilation:  javac Elevator.java
 *  Execution:    java Elevator 'number of floors' 'floor requests' 'number of restricted floors' 'optional passcode'
 *
 *  @author Aryan Patel
 *  
 *
 *************************************************************************/
public class Elevator {
    public static void main ( String[] args ) {

	// WRITE YOUR CODE HERE
    int totalFloors = Integer.parseInt(args[0]);
    int requestedFloors = Integer.parseInt(args[1]);
    int restrictedFloors = Integer.parseInt(args[2]);
    
    int elevator1 = 1;
    int elevator2 = 1;


    while (requestedFloors>0){
        int nextFloor = requestedFloors %10;
        int difference1 =0;
        int difference2 =0;
        //***************** Calculating difference*********
        if (nextFloor>=elevator1){
            difference1 = nextFloor - elevator1;
        }else {
            difference1 = elevator1 - nextFloor;
        }

        if (nextFloor>=elevator2){
            difference2 = nextFloor - elevator2;
        }else{
            difference2 = elevator2 - nextFloor;
        }

        //***************** Calculating difference*********

        // ***************Main Elevator Code***************

        if (difference1 == difference2){
            System.out.println("1 " + nextFloor);
            elevator1 = nextFloor;
        }else{
            if (difference1>difference2){
                System.out.println("2 " + nextFloor);
                elevator2 = nextFloor;
            }else{
                System.out.println("1 " + nextFloor);
                elevator1 = nextFloor;
            }
        }

        // ***************Main Elevator Code***************


        // ***************Restricted floor access Code***************
        if (nextFloor > (totalFloors - restrictedFloors)){
            int passcode = Integer.parseInt(args[3]);
            if (((passcode%totalFloors) == nextFloor) || ((passcode%totalFloors == 0) && (nextFloor == totalFloors))){
                System.out.println("Granted");
            }else{
                System.out.println("Denied");
            }
        }
        // ***************Restricted floor access Code***************

        requestedFloors = requestedFloors/10;
    }
    }
}
