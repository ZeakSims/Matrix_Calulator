package Main;

import java.util.*;
import java.util.Random;
import java.lang.*;


public class Matix_Calculator {

public static void main (String[]args) { 
		
		System.out.println("Press enter to begin");
		 
		Scanner userInput = new Scanner(System.in);
		// intialize string input for when the user is ask to repeat program
		String repeat = userInput.nextLine();
		// do while loop to repeat the program after you run through it
		do{
	   
        System.out.println("Enter the number of rows you want in matrix 1. no inputs less the 50."); 
        int m1Row = userInput.nextInt();
      
        //As long as number is 49 or less, the while loop will keep asking you to put a number 50 and greater
        while(m1Row <= 49) { 
        
            System.out.println("Please enter number equal to or greater than 50");
            m1Row = userInput.nextInt();    
        }
        
        System.out.println("Enter the number of columns you want in matrix 1. no inputs less the 50.");
        int m1Col = userInput.nextInt();
        
        while(m1Col <= 49) { 
            
            System.out.println("Please enter number equal to or greater than 50");
            m1Col = userInput.nextInt();
        }
        //this is where it is defining a 2D array to hold matrix data for matrix 1
        int[][] m1 = new int[m1Row][m1Col];
        // this is where you enter and store the data for matrix 1
        createMatrixData_1(userInput, m1, m1Row, m1Col);
        // this is where it prints matrix 1
        printMatrix_1(m1, m1Row, m1Col);
        
        System.out.println("Enter the number of rows you want in matrix 2. no inputs less the 50."); 
        int m2Row = userInput.nextInt();
        
        while(m2Row <= 49) { 
            
            System.out.println("Please enter number equal to or greater than 50");
            m2Row = userInput.nextInt();    
        }
        while(m2Row != m1Col) {
        	// this makes sure that you enter a row size that equals the column size of your first matrix
        	System.out.println("The amount of rows you input must equal the amount of columns you have set for your first matrix. you set " + m1Col + " columns in your first matix.");
        	m2Row = userInput.nextInt();
        }
        
        System.out.println("Enter the number of columns you want in matrix 2. no inputs less the 50.");
        int m2Col = userInput.nextInt();
        
        while(m2Col <= 49) { 
            
            System.out.println("Please enter number equal to or greater than 50");
            m2Col = userInput.nextInt();
        } 
        //this is where it is defining a 2D array to hold matrix data for matrix2
        int[][] m2 = new int[m2Row][m2Col];
        // this is where you enter and store the data for matrix 2
        createMatrixData_2(userInput, m2, m2Row, m2Col);
        // this is where it prints matrix 1
        printMatrix_2(m2, m2Row, m2Col);
        ////this is where it is defining a 2D array to hold matrix data for the new matrix product
        int[][] m3 = new int [m1Row][m2Col];
        
        newMatrix(m1Row, m1Col, m2Row, m2Col, m1, m2, m3);
	
	 // returns the current value of the system timer in nanoseconds
    System.out.println();
    System.out.print("time it took to compile in nanoseconds = ");
    System.out.println(System.nanoTime());
    // returns the current value of the system timer in milliseconds
    System.out.print("time it took to compile in milliseconds = ");
    System.out.println(System.currentTimeMillis());
	// this ask you if you want to repeat the program. it only repeats only if you say yes   
	System.out.println();
	System.out.println("Do you want to do another matrix? yes or no? ");
   	repeat = userInput.next(); 
   	System.out.println();
    // repeats the program if you answer yes
	}while(repeat.equalsIgnoreCase( "yes" ));
}
// method to enter and store data for matrix 1    	
public static void createMatrixData_1(Scanner scan, int[][] m1, int m1Row, int m1Col) {
     
	 Random rand = new Random(); 
	 rand.setSeed(System.currentTimeMillis());
	 
          for (int i = 0; i < m1Row; i++)
          {
              for (int j = 0; j < m1Col; j++)
              {
            	// Generate random integers in range 0 to 99 
            	  int r = rand.nextInt(100); 
                  m1[i][j] =  Math.abs(r);
	                
	                
              }
          }
  }
  // method to print matrix 1
  public static void printMatrix_1(int[][] m1, int m1Row, int m1Col){
    System.out.println("Your Matrix is : ");
        
    
    
        for (int i = 0; i < m1Row; i++)
        {
            for (int j = 0; j < m1Col; j++)
            {
                System.out.print(m1[i][j]+"\t");
            }
             
            System.out.println();
        }
  }
  //method to enter and store data for matrix 1    
  public static void createMatrixData_2(Scanner scan, int[][] m2, int m2Row, int m2Col) {
            
       	 Random rand = new Random(); 
       	 rand.setSeed(System.currentTimeMillis());
       	 
                 for (int i = 0; i < m2Row; i++)
                 {
                     for (int j = 0; j < m2Col; j++)
                     {
                   	// Generate random integers in range 0 to 99 
                   	  int r = rand.nextInt(100); 
                         m2[i][j] =  Math.abs(r);
       	                
       	                
                     }
                 }
         }
  		//method to print matrix 2
         public static void printMatrix_2(int[][] m2, int m2Row, int m2Col){
           System.out.println("Your Matrix is : ");
               
           
           
               for (int i = 0; i < m2Row; i++)
               {
                   for (int j = 0; j < m2Col; j++)
                   {
                       System.out.print(m2[i][j]+"\t");
                   }
                    
                   System.out.println();
               }
	}

         private static void newMatrix(int m1Row, int m1Col, int m2Row, int m2Col, int[][] m1, int[][] m2, int[][] m3) {
        	    // work across row of 1
        		for (int i = 0; i < m1Row; i++) {
        			  // work across cols of 2
        			  for(int j = 0; j < m2Col; j++) {
        			   // now complete the addition and multiplication
        			   for(int k = 0; k < m1Col; k++) {
        				   m3[i][j] += m1 [i][k] * m2[k][j];
        			   }
        			  }
        			}
        			
        			System.out.println("The product is ");
        			  for(int m = 0; m < m3.length; m++) {
        			   for (int n = 0; n < m3[0].length; n++) {
        				   //prints out elements of the new matrix
        				   System.out.print(m3[m][n] + " ");
        			   }
        			    System.out.println();
        			  
        			  }
        		}

}
}
