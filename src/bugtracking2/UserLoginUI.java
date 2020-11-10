// Boundary Class
// Package
package bugtracking2;

// import libraries
import java.util.Scanner; // Import the Scanner Class
import java.io.Console; // For masking Password

public class UserLoginUI 
{
    public static int userRole = 0;
    public static int uID = 0;    

    public UserLoginUI() // Default Constructor
    {
        // Create Scanner Object
        Scanner input = new Scanner (System.in);
        boolean authenticate = false;
        
        while (authenticate == false)
        {
            // User Interface
            System.out.println("\nLogin Page");
            System.out.println("===================================");

            System.out.print("Username: ");
            String userName = input.nextLine();

            System.out.print("Password: ");
            String password = maskPassword();
            System.out.println("===================================");

            if (userName.isEmpty() == false && password.isEmpty() == false)
            {
                // Create Controller Class Object
                UserLoginController loginController = new UserLoginController(); 
                
                // Check Login Credentials Match
                if(loginController.ValidateUser(userName, password) == true)
                { // Login Successful [Match]
                    int[] userID = loginController.getUser(userName, password); 
                    if (userID[0] >= 1 && userID[0] <=4)
                    {
                        userRole = userID[0];
                        uID = userID[1];
                        // Transition to relevant scene
                    }
                    else// Display error message! 
                    {System.out.println("No role found.");}  

                    System.out.println("Authenticated");
                    authenticate = true;
                }
                else 
                { // Login Fail [No Match]
                    System.out.println("Invalid Login Credentials!");
                    System.out.println("Please try again!");
                }         
            }
            else if (userName.isEmpty()) // Error message
            {System.out.println("Blank username field!");}
                          
            else if (password.isEmpty()) // Error message
            {System.out.println("Blank password field!");}
                
            else // Error message
            {System.out.println("Invalid Credentials, Please try again!");}
        }
    } 
    public String maskPassword()
    {//PASSWORD MASKING METHOD.... only works in command/terminal line
        Console console = System.console();
        if (console != null) 
        {
            char[] password = console.readPassword(); 
            String temp = new String(password);
            return temp;
        }
        else
        {
            Scanner inputScanner = new Scanner(System.in);
            return  inputScanner.nextLine();
        }
    }
}