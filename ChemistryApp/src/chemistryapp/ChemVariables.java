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
public class ChemVariables {
    
    /* This equation Takes the User input and dooes the math needed to figure out the molar mass
    It returns Molas Mass
    */  
    
    //Returns Molar Mass.
    public static double Equations(int Mult1,String Chem1,int Mult2, String Chem2,int Mult3, String Chem3){
        
    
    
        
    // this is the name of the elements
    String[] Elements = {
        "H","He",
        "Li","Be","B","C","N","O","F","Ne",
        "Na","Mg","Al","Si","P","S","Cl","Ar",
        "K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr",
        "Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe",
        "Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
            "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn",
        "Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No",
             "Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg",
             "nothing"// This nothing is for when there is nothing ( work!!)
            
            
    
         };
    
    //Masses of the elements( same order as names, must be in the same order)
    double[] ElementMasses = {
        1.008, 4.003,6.941,9.012,10.812,12.011,14.007,15.999,18.998,20.180,
        22.990,24.305,26.982,28.086,30.974,32.066,35.453,39.948,
        39.098,40.078,44.956,47.867,50.942,51.996,54.938,55.845,58.933,58.693,63.546,65.38,69.723,72.64,74.992,78.96,79.904,83.798,
        85.456,87.62,88.906,91.224,92.906,95.96,98,101.07,102.906,106.42,107.868,112.412,114.818,118.711,121.760,127.60,126.904,131.294,
        132.905,137.328,138.905,140.116,140.908,144.242,145,150.36,151.964,157.25,158.925,162.500,164.930,167.259,168.934,173.055,
            174.967,178.49,180.948,183.84,186.207,190.23,192.217,195.085,196.967,200.59,204.383,207.2,208.980,209,210,222,
        223,226,227,232.038,231.036,238.029,237,244,243,247,247,251,252,257,258,259,
            262,267,268,271,272,270,276,281,280, // Ends with Rg
            0//The 0 is nothing for when nothing is there
    };
    
 
    // Sorting in order to find index of Letter to their number counterparts
    int ElementIndex1 = 111;
    int ElementIndex2  = 111;
    int ElementIndex3 = 111;
    // keep these as 111 beacause if they enter something that is not in the array it spits this value.
    
    
    for(int ctr1=0;ctr1<Elements.length;ctr1++){
        
        if(Chem1.equals(Elements[ctr1])){
            
            ElementIndex1 = ctr1;
            System.out.println("ELement 1 Index "+ElementIndex1);
            // The index prints out the smallest index first.
        }
        if(Chem2.equals(Elements[ctr1])){
            ElementIndex2 = ctr1;
            System.out.println("Element 2 Index "+ElementIndex2);
            
        }
        if(Chem3.equals(Elements[ctr1])){
            ElementIndex3 = ctr1; 
            System.out.println("Element 3 Index "+ElementIndex3);
        }
    }
    
    
    
    //Math Section for Molar Mass
    double Element1Mass = ElementMasses[ElementIndex1];
    System.out.println("Element 1 Mass "+Element1Mass);
    double Element2Mass = ElementMasses[ElementIndex2];
    System.out.println("Element 2 Mass "+Element2Mass);
    double Element3Mass= ElementMasses[ElementIndex3];
    System.out.println("Elemment 3 Mass "+Element3Mass);
    
    double MolarMass = (Mult1*Element1Mass)+(Mult2*Element2Mass)+(Mult3*Element3Mass);
        System.out.println("This is the Molar Mass"+MolarMass+" g");
        return MolarMass;
    
    //End of Molar Mass Section
    
    
    
    }// End of Molar Mass data sifting and Math
    
    
    // This function takes moles and converts it to atoms, returns nothing.( null no work prob), returns to menu
    public static void Atoms(){
        
        double Moles,
             Atoms;
        
        Moles = 0;
        try{
           Moles = Double.parseDouble(JOptionPane.showInputDialog("Enter Moles present"));
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"You did not enter the Moles, going back to menu."); 
         ChemistryApp.menu();
            
        }
        
        Atoms = 6.023E23*Moles;
        
        JOptionPane.showMessageDialog(null, Atoms,"Number of Atoms present:", 
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Number of Atoms: "+Atoms);
        
    }
    
    // This function will Conver Atoms to Moles ( does not work with nulls....), reuturns to menu
    public static void Atoms2(){
        double Moles,
             Atoms;
        
        Atoms = 0;
        try{
           Atoms = Double.parseDouble(JOptionPane.showInputDialog("Enter number of Atoms present"));
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"You did not enter the moles, going back to menu."); 
         ChemistryApp.menu();
            
        }
        
        Moles = Atoms / 6.023E23;
        
        JOptionPane.showMessageDialog(null, Moles,"This is the amount of Moles present", 
           JOptionPane.PLAIN_MESSAGE);
        System.out.println("Number of Moles Present: "+Moles);
    }
    
    
    //This function does not return anything and can display the Atomic Number and Mass of 1 element.
    public static void ElementInfo(){
        
        String Element1 = "nothing";
        int Index;
        
        
        try{
             Element1 = JOptionPane.showInputDialog("Enter Element in question");
            
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            JOptionPane.showMessageDialog(null,"You did not input an element.");
            Element1 = "nothing";
        }
        
       
       
        String[] Elements = {
        "H","He",
        "Li","Be","B","C","N","O","F","Ne",
        "Na","Mg","Al","Si","P","S","Cl","Ar",
        "K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As","Se","Br","Kr",
        "Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe",
        "Cs","Ba","La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
            "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn",
        "Fr","Ra","Ac","Th","Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No",
             "Lr","Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg",
             "nothing"// For when there is nothing
         };// end of elements array
    
    //Masses of the elements( same order as names, must be in the same order)
    double[] ElementMasses = {
        1.008, 4.003,6.941,9.012,10.812,12.011,14.007,15.999,18.998,20.180,
        22.990,24.305,26.982,28.086,30.974,32.066,35.453,39.948,
        39.098,40.078,44.956,47.867,50.942,51.996,54.938,55.845,58.933,58.693,63.546,65.38,69.723,72.64,74.992,78.96,79.904,83.798,
        85.456,87.62,88.906,91.224,92.906,95.96,98,101.07,102.906,106.42,107.868,112.412,114.818,118.711,121.760,127.60,126.904,131.294,
        132.905,137.328,138.905,140.116,140.908,144.242,145,150.36,151.964,157.25,158.925,162.500,164.930,167.259,168.934,173.055,
            174.967,178.49,180.948,183.84,186.207,190.23,192.217,195.085,196.967,200.59,204.383,207.2,208.980,209,210,222,
        223,226,227,232.038,231.036,238.029,237,244,243,247,247,251,252,257,258,259,
            262,267,268,271,272,270,276,281,280, // Ends with Rg
            0//The 0 is nothing for when nothing is there
    };// End of array
    
    
    Index = 111;
    for( int ctr1=0;ctr1<Elements.length;ctr1++ ){
        if(Element1.equals(Elements[ctr1])){
        Index = ctr1;
        
         System.out.println("This is the Index shown: "+Index);
        }
        
    } 
        
    // Element Manipulation Section.
    double ElementMass = ElementMasses[Index];
    int ElementAtomicNumber = Index + 1;
    
    System.out.println("This is the Lements Mass: "+ElementMass);
    System.out.println("This is the Elements atomic number: "+ElementAtomicNumber);
    
    String Output = "Element Mass: " + String.valueOf(ElementMass) + "\n"
            + "Element Atomic Number: " + String.valueOf(ElementAtomicNumber);
    
    JOptionPane.showMessageDialog(null,Output,"ElementInfo",
            JOptionPane.PLAIN_MESSAGE);
     // It is possible to add charge and protons/neutrons
    
        
    }// End of Element Info class
    
    //Finds the Moles of an Specific Element from moles, returns the mole of a single element.
    public static double MolesOfElement(int Mult1,String Chem1,int Mult2, String Chem2,int Mult3, String Chem3){
        
        String Element1 = "nothing";
        double SingleMole = 0;
        int Multiplier;
        double TotalMoles =0;
        try{
             TotalMoles= Double.parseDouble(JOptionPane.showInputDialog("Enter Moles of Compound"));
         }catch( NumberFormatException | NullPointerException e){
             JOptionPane.showMessageDialog(null,"You did not enter the moles");
             TotalMoles = 0;
             ChemistryApp.menu();
         }
        
        
        try{
             Element1 = JOptionPane.showInputDialog("Enter Element in question");
         }catch(HeadlessException | NullPointerException e){
             JOptionPane.showMessageDialog(null,"You did not enter an element.");
             Element1 = "nothing"; //(technically not needed)
             ChemistryApp.menu();
         }
        
       if(Element1.equals(Chem1)){
           Multiplier = Mult1;
           
       }else if(Element1.equals(Chem2)){
           Multiplier = Mult2;
           
       }else if(Element1.equals(Chem3)){
           Multiplier = Mult3;
       }else{
           Multiplier =0;
       }
        
        SingleMole = TotalMoles*Multiplier;
        
        return SingleMole;
    }

    //Here they give me the grams of the substance, returns the mole of a single element
    public static double MolesOfElement2(int Mult1,String Chem1,int Mult2, String Chem2,int Mult3, String Chem3){
        double SingleMole = 0;
        double TotalMoles = ChemistryApp.Moles1();
       String Element1 = "nothing";
        int Multiplier;
        try{
             Element1 = JOptionPane.showInputDialog("Enter Element in question");
         }catch(HeadlessException | NullPointerException e){
             JOptionPane.showMessageDialog(null,"You did not enter an element.");
             Element1 = "nothing"; //(technically not needed)
             ChemistryApp.menu();
         }
        
       if(Element1.equals(Chem1)){
           Multiplier = Mult1;
           
       }else if(Element1.equals(Chem2)){
           Multiplier = Mult2;
           
       }else if(Element1.equals(Chem3)){
           Multiplier = Mult3;
       }else{
           Multiplier =0;
       }
        
        return SingleMole;
    }
    //+++++++++++++++++++++
    
    //Method not used, needs info and change name...
    public static void Sulfates(){
        
  
        
    }
    
    
    //Method not used Needs info.
    public static void Acids(){
        
        
    }
    
    //Method not used, needs info
    public double Molarity(){
        
        
        
        
        return 0;
    }
    
    public static double Gasses(){
        
        double[] vars;
        vars = new double[6];
        vars[1] = 0;//P
        vars[2] = 0;//V
        vars[3] = 0;//n
        vars[4]=0.082;//R
        vars[5]  = 0;//T
        double answer = 0;
        
        int MissIndx = 0,
            Counter = 0;    
                
        
        String[] Names;
        Names = new String[6];
        Names[1] = "Pressure";
        Names[2] = "Volume";
        Names[3] = "Number of Moles";
        Names[4] = "R";
        Names[5] = "Tempeature";
        
        String LResult  = "nothing";
                
        MessageGui("Here we will be USing PV=nRT to find a missing variable, Place a 0 in variable that you want found.");
        vars[1] = NumGui("Enter The pressure in atm");
        vars[2] = NumGui("Enter the Volume in Liters");
        vars[3] = NumGui("Enter the number of moles");
        vars[5] = NumGui("Enter the Temperature in Kelvin");
        

       
       for(int x=1;x<vars.length;x++){
      if(vars[x]==0){
          MissIndx = x;
          Counter++;
        }
      }
       if(Counter>1){
           MessageGui("you entered more than 1 missing variable, going back to menu");
           ChemistryApp.menu(); 
       }
       
       System.out.println("Missing Value:"+Names[MissIndx]); // !!!!!       
      
       switch(MissIndx){
       case 1: answer = ((vars[3]*vars[4]*vars[5])/vars[2]);break; // finds pressure
       case 2: answer  = ((vars[3]*vars[4]*vars[5])/vars[1]);break; // finds volume 
       case 3: answer  = ((vars[1]*vars[2])/(vars[4]*vars[5]));break; // finds number of moles
       case 5: answer  = ((vars[1]*vars[2])/(vars[3]*vars[4])); break; // finds tempeature.
       default: System.out.println("Error.");ChemistryApp.menu();
    }
        JOptionPane.showMessageDialog(null,"Your Missing Variable was"+ Names[MissIndx]+" and your answer is"+answer);
        
        
        
        return answer;
    }//
    
    
    
    //returns false, cause stuff...
    public static boolean MessageGui(String Usin){ // method for creating number only Guis.
        String Result = "";
       
        JOptionPane.showMessageDialog(null, Usin); // can be changed
        return false;
       
    }
    
   // returns a string
     public static String StrGui(String Usin){ // method for creating  String Guis.
        String Result = "";
        try{
           Usin = JOptionPane.showInputDialog(null, Usin);
        }catch(NullPointerException | HeadlessException | UnknownError e ){
           Usin = "Error Message, Code 1.";    
    }
     return Usin;
    }
     
      public static Double NumGui(String Usin){ // method for creating number only Guis.
        double Result = 0;
        try{
           Result =Double.parseDouble(JOptionPane.showInputDialog(null, Usin));
        }catch(NullPointerException | HeadlessException | UnknownError | NumberFormatException e ){
           Result = 0;    
    }
     return Result;
    }
    


} // End of Class Chem Variables

    
    
    

