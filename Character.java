import java.io.*;
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Character
{
    private MagicWand wand;
    private String name;
    private double energyPoints;
    private double offensivePoints;
    private double defensivePoints;
    /**
     * Constructor for objects of class Character
     */
    public Character(String name){
        setName(name);
        setEnergyPoints(20.0);
        setOffensivePoints(20.0);
        setDefensivePoints(20.0);
    }
    /**
     * Returns the name of the characters.
     * @return the name of the Character.
     * 
     */
    public String getName(){
        return this.name;
    }
    
    /** 
     * set the name of the character to "name".
     * @param Name of a character to be set.
     */
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * 
     * Returns the wand of the character.
     * @return the wand of the character.
     * 
     */
    public MagicWand getCharacterWand(){
        return this.wand;
    }
    
    /**
     * Returns the base energy points of the character rounded to two decimal places.
     * @return the base energy points of the character.
     */
    public double getEnergyPoints(){
        return (double)Math.round(this.energyPoints*100d)/100d;
    }
    
    /** 
     * set the base energy points of the character to "energyPoints".
     * @param the energy points to be set.
     */
    public void setEnergyPoints(double energyPoints){
        this.energyPoints=energyPoints;
    }
    
    /**
     * Returns the base offensive Points of the character.
     * @return the base offensive Points of the character. 
     */
    public double getOffensivePoints(){
        return this.offensivePoints;
    }
    
    
    /** 
     * set the base offensive points of the character to "offensivePoints".
     * @param the offensive points to be set.
     */
    public void setOffensivePoints(double offensivePoints){
        this.offensivePoints=offensivePoints;
    }
    
    /**
     * Returns the base defensive Points of th character.
     * @return the base defensive Points of the character.
     */
    public double getDefensivePoints(){
        return this.defensivePoints;
    }
    
    /** 
     * set the base defensive points of the character to "defensivePoints".
     * @param the defensive points to be set.
     */
    public void setDefensivePoints(double defensivePoints){
        this.defensivePoints=defensivePoints;
    }
    
    /** 
     * the totalOffensivePoints returned depend of the base energy and offensive points of the character.
     * @return the offensive points of the character while using its MagicWand.
     */
    public double getTotalOffensivePoints(){
        return this.wand.offensive(this.getEnergyPoints(),
                                   this.getOffensivePoints());
    }
    
    /** 
     * the resistancePoints returned depend of the base energy and defensive points of the character.
     * @return the defensive points of the character while using its MagicWand.
     */
    public double getResistancePoints(){
        return this.wand.defensive(this.getEnergyPoints(),
                                   this.getDefensivePoints());     
    }
    
    /** 
     * This method makes the current character(this) and a "attacked character" c1 fight,
     *  if the Totaloffensive points of the current character are higher than the resistance points of the "attacked character"
     *  we substract the diference between the offensive adn defensive points to the energy points of the attcked character.
     *  
     *  @param the character to be attacked.
     *  @param printWriter to write in a text file
     */
    public void Fight(Character c1,PrintWriter pw){
        double aux;
        
        displayB(c1);
        printB(c1,pw);
        if(this.getTotalOffensivePoints()>c1.getResistancePoints()){
            aux=c1.getEnergyPoints()-(this.getTotalOffensivePoints()-c1.getResistancePoints());
            if(aux>=0){
                c1.setEnergyPoints(aux);
            }
            else
                c1.setEnergyPoints(0);
        }
        display(c1);
        print(c1,pw);
    }    
    
    /**  
     * Assign the specified MagiWand to the character.
     * @param the MagicWand to be assigned to the current character.
     */
    public void assignWand(MagicWand W){
        this.wand=W;
    }
    
    /**
     * Displays the name and the totalOffensivePoints of a character. It is shown in the format specified for the project.
     * @param character who is defending
     */
    public void displayB(Character c1){
        System.out.println("attack points of <"+this.getName()+"> are: <"+this.getTotalOffensivePoints()+">"); 
        System.out.println("resistance points of <"+c1.getName()+"> are: <"+c1.getResistancePoints()+">");
    }
    
    /**
     * Prints the name and the totalOffensivePoints of a character. It is shown in the format specified for the project.
     * @param character who is defending
     * @param printWriter to write in a text file
     */
    public void printB(Character c1, PrintWriter pw){
        pw.println("attack points of <"+this.getName()+"> are: <"+this.getTotalOffensivePoints()+">"); 
        pw.println("resistance points of <"+c1.getName()+"> are: <"+c1.getResistancePoints()+">");
    }
    
    /**
     * Displays the name and the energyPoints of a character. It is shown in the format specified for the project.
     * @param character
     */
    public void display(Character c1){
        System.out.println("the remaining energy of <"+ c1.getName() + "> after the duel are: <" + c1.getEnergyPoints() + ">"+"\n");
    }
    
    /**
     * Prints the name and the energyPoints of a character. It is shown in the format specified for the project.
     * @param character
     * @param printWriter to write in a text file
     */
    public void print(Character c1, PrintWriter pw){
        pw.println("the remaining energy of <"+ c1.getName() + "> after the duel are: <" + c1.getEnergyPoints() + ">"+"\n");
    }
    
    
}