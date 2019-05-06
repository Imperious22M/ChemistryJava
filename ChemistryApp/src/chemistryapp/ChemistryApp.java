/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemistryapp;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author scott
 */
public class ChemistryApp {
    static int FirstMult,// Storage for Chemical subscripts
               SecondMult,
               ThirdMult;
    
    static String FirstChem,// Storage for Chemical Names
                  SecondChem,
                  ThirdChem;
    
    static double MolarMass;//Stores the Molar Mass after the User inputs the eqation.
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        menu();
        
    }// End of main class
    
    public static void menu()
    {
        int choice = 1;
        try{
        choice = Integer.parseInt(JOptionPane.showInputDialog("Main Menu: \n"
                +"Chemical Equation: "+FirstMult+FirstChem+SecondMult+SecondChem+ThirdMult+ThirdChem+"\n"
                + "1. Molar Mass\n"
                + "2. Grams to Moles\n"
                +"3. Moles to Grams\n"
                + "4. Moles to Atoms\n"
                + "5. Atoms to Moles\n"
                + "6. Single Element Info\n"
                +"7. Enter Chemical Equation\n"
                +"8. Manual\n"
                +"9. Moles of an Element from Grams(s)\n"
                +"10. Moles of an Element from Moles\n "
                +"11. Find Missing Variable in Gas Law (PV=nRT)\n"));
        }
        catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null,"Not a valid Option,Exiting...");
         choice = 0;
        }
        switch(choice)
        {
            case 1: JOptionPane.showMessageDialog(null,"This is the Molar Mass:"+ MolarMass+"g");menu();break;
            case 2:JOptionPane.showMessageDialog(null,"This is are the moles"+Moles1());menu();break;
            case 3:Moles2(); menu();break;
            case 4: ChemVariables.Atoms(); menu();break;
            case 5: ChemVariables.Atoms2(); menu(); break;
            case 6: ChemVariables.ElementInfo(); menu();break;
            case 7: GatherInfo();menu();break;
            case 8: Manual();menu();
            case 9: JOptionPane.showMessageDialog(null,ChemVariables.MolesOfElement2(FirstMult,FirstChem,SecondMult,SecondChem,ThirdMult,ThirdChem));menu();break;
            case 10: JOptionPane.showMessageDialog(null, ChemVariables.MolesOfElement(FirstMult,FirstChem,SecondMult,SecondChem,ThirdMult,ThirdChem));menu();break;
            case 11: JOptionPane.showMessageDialog(null,ChemVariables.Gasses());menu();break;
            default: System.out.println("Bye Bye, See you next time :D.");
            System.exit(0);
            
        }
    }
    
    // Gathers the Chemical Equation, and calculates Molar Mass.
    public static void GatherInfo(){
        
         // TODO code application logic here
         FirstMult = 0;
         
        try{
            // this command takes user input in integer form
            FirstMult = Integer.parseInt(JOptionPane.showInputDialog("Enter The first Multiplier of the equation."));
        }
        catch(HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"You didn't enter an integer. I'll make it 1.");
            FirstMult = 1;
        }//End of First Multiplier
        
       
        try{
        // this command takes the user input in string form
        FirstChem = JOptionPane.showInputDialog("Enter First Element");
        
        }
        catch( HeadlessException | NullPointerException e){ 
            
        JOptionPane.showMessageDialog(null,"You didn't enter an element I'll make it Nothing.");
       FirstChem = "nothing";
        }//End of First Chemical
        
        
        
          
        try{
            // this command takes user input in integer form
            SecondMult  = Integer.parseInt(JOptionPane.showInputDialog("Enter the second multiplier of the equation."));
        }
        catch(HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"You didn't enter an integer. I'll make it 1.");
            SecondMult = 1;
        }//End if Second Multipier
        
        
       
        try{
            SecondChem = JOptionPane.showInputDialog("Enter Second Element");
        }
        catch(HeadlessException | NullPointerException e){
            JOptionPane.showMessageDialog(null,"You did not enter an element I'll make it nothing");
            SecondChem = "nothing";
        }// End of Second Chemical
        
        
        
        try {
            ThirdMult = Integer.parseInt(JOptionPane.showInputDialog("Enter Third Multipler"));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"You did not enter an integer. I'll make it 1");
            ThirdMult = 1;
           
        }// End of Third Multipler
        
       
        try{
            ThirdChem = JOptionPane.showInputDialog("Enter Third Element");
         
        }
        catch(HeadlessException | NullPointerException e){
            JOptionPane.showMessageDialog(null,"You did not Enter an element, I'll make it H" );
            ThirdChem =  "nothing";
        }// End of Third Chemical
        
      
        // Out call shows what the user put in.
        System.out.println(FirstMult+FirstChem+SecondMult+SecondChem+ThirdMult+ThirdChem);
        
        
    MolarMass = ChemVariables.Equations(FirstMult,FirstChem,SecondMult,SecondChem,ThirdMult,ThirdChem);
        
    }
    
    
   // Returns Moles from Grams and Molar Mass. changed
    public static double Moles1(){

        
        double Grams = 0;
        try{
            Grams =Double.parseDouble(JOptionPane.showInputDialog("Enter weight in grams of Substance"));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"You did not enter a number, I will make it 0");
            Grams = 0;
        }
        
        double Moles = Grams/MolarMass;
        
        System.out.println("This are the moles "+Moles);
       // menu();
      
        return Moles;
          
        }
    
    
    //Returns Grams from Moles and Molar Mass. changed ( I could always move the display section to the menu section)
    public static double Moles2(){
       
       double Moles = 0;
       try{
             Moles =Double.parseDouble(JOptionPane.showInputDialog("Enter moles "));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"You did not enter a number, I will make it 0");
            Moles = 0;
        }
       
       double Grams = Moles*MolarMass;
       JOptionPane.showMessageDialog(null, "This is how many grams you need "+Grams);
       
        return Grams;
    }
       
  // Needs work.
   public static void Manual(){
       String Manual = "If you do not know how to use this please contact its creator.";
       
       
       JOptionPane.showMessageDialog(null,Manual);
   } 
        
}
   
    







    
    
    
    
    
    
    
