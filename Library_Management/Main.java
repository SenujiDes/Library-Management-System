import java.util.Scanner;
import java.util.InputMismatchException;;

public class Main {
    public static void main(String[] args) {

        Library my_obj= new Library();

        System.out.println("Welcome to BookSide!");
        boolean quit= false;

        while(!quit){
            System.out.println("\n*******************************************************************");
            System.out.println("*                      MENU OPTIONS                               *");
            System.out.println("*******************************************************************");
        
            System.out.println("1)Add a new book"); 
            System.out.println("2)Remove a book"); 
            System.out.println("3)Add a member"); 
            System.out.println("4)Remove a member"); 
            System.out.println("5)Search all books"); 
            System.out.println("6)Search relavent book availability"); 
            System.out.println("7)Search all members"); 
            System.out.println("8)Search relavent member");   
            System.out.println("9)Borrow book");  
            System.out.println("10)Borrow book details"); 
            System.out.println("11)Quit"); 
            System.out.println("*******************************************************************\n");
            System.out.println();

            Scanner input = new Scanner(System.in);
            int option;
            while(true){
                System.out.print("Please select an option :");
                try{
                    option=input.nextInt();
                    if(option>0 && option <=11){
                        break;
                    }
                    else{
                        System.out.println("Please enter a valid option number");
                        input.nextLine();
                        System.out.println();
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid option.");
                    input.nextLine();  //Invalid input is being cleared from the scanner buffet
                    System.out.println();
                }
               
            }

            switch (option) {
                case 1:
                    my_obj.addBook();
                    break;
                case 2:
                    my_obj.removeBook();
                    break;
                case 3:
                    my_obj.addMember();
                    break;
                case 4:
                    my_obj.removeMember();
                    break;
                case 5:
                    my_obj.showBooks();
                    break;
                case 6:
                    my_obj.DisplayRelaventBook();
                    break;
                case 7:
                    my_obj.showMembers();
                    break;
                case 8:
                    my_obj.DisplayRelaventMember();
                    break;
                case 9:
                    my_obj.LendBook();
                    break;
                case 10:
                    my_obj.RelaventLendDetails();
                    break;
                case 11:
                    System.out.println("System Existing");
                    quit=true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a correct option number");
                    break;

            }
        }
        
    }
    
}
