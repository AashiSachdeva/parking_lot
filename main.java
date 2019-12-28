import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 
public class main {
    public static Parking parkingObject;
    public static int totalslots;
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
         if(input.equals("./parking_lot")){
            //Interactive
          
            while(true){
                String command[];
                command = scan.nextLine().split(" ");
             
                operation(command);
            }
        }
        else{
            //File
            String filePath = (System.getProperty("user.dir")+input.substring(input.indexOf('/')));
            File file = new File(filePath); 
            Scanner sc = new Scanner(file); 
            String line;

            
            while(sc.hasNext()){
                line = sc.nextLine();
                String command[];
                command = line.split(" ");

                operation(command);
            }
        }
        scan.close();
    
    }
     public static void operation(String[] command){
      
        switch(command[0]){
            case "create_parking_lot":
                parkingObject = new Parking(Integer.parseInt(command[1]));
                totalslots=Integer.parseInt(command[1]);
                System.out.println("Created a parking lot with "+command[1]+" slots");
                break;
            case "park":
                System.out.println(parkingObject.park(command[1],command[2]));
                break;
            case "status":
                String status[] = parkingObject.status();
                System.out.println("Slot No.\tRegistration No.\tColour");
                for(int i = 0 ; i < totalslots; i++){
                    if(status[i] != null) System.out.println(status[i]);
                }
                break;
            case "leave":
                System.out.println(parkingObject.leave(Integer.parseInt(command[1])));
                break;
            case "registration_numbers_for_cars_with_colour":
                System.out.println(parkingObject.getRegistrationNumberFromColour(command[1]));
                break;
            case "slot_numbers_for_cars_with_colour":
                System.out.println(parkingObject.getSlotNumberFromColour(command[1]));
                break;
            case "slot_number_for_registration_number":
                System.out.println(parkingObject.getSlotNumberFromRegistrationNumber(command[1]));
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}


