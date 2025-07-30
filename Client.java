import java.util.Collections;
/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
     private Hogwarts h;
    /**
     * Constructor for objects of class Client
     */
    public Client(){
        h=h.getInstance();
        InitData();
        //InitData2();
    }
    
    public void InitData(){
        //inilializacion Gryffindor
        
        MagicWand Wand1 = new OffensiveHawthorn("Ivy");
        MagicWand Wand2 = new OffensiveHawthorn("Larch");
        MagicWand Wand3 = new HollyDefensive("Rowan");
        MagicWand Wand4 = new OffensiveHawthorn("Yew");
        MagicWand Wand5 = new OffensiveHawthorn("Hazel");
        MagicWand Wand6 = new OffensiveHawthorn("Pine");
        MagicWand Wand7 = new HollyDefensive("Tamarack");
        MagicWand Wand8 = new OffensiveHawthorn("Spruce");
        MagicWand Wand9 = new OffensiveHawthorn("Pear");
        MagicWand Wand10 = new OffensiveHawthorn("Laurel");
        
        h.addReplacements(Wand1);
        h.addReplacements(Wand2);
        h.addReplacements(Wand3);
        h.addReplacements(Wand4);
        h.addReplacements(Wand5);
        h.addReplacements(Wand6);
        h.addReplacements(Wand7);
        h.addReplacements(Wand8);
        h.addReplacements(Wand9);
        h.addReplacements(Wand10);
        
        Collections.sort(h.getReplacementList(),new ComparatorNameWand());
        
        House gryffindor = new House("Griffyndor");
        
        Character Harry = new Offensive("Harry Potter");
        Character Ron = new Defensive("Ron Weisley");
        Character Hermione = new Defensive("Hermione Granger");
        Character Neville = new Defensive("Neville Longbottom");
       
        MagicWand RonW = new OffensiveHawthorn("RonW");
        MagicWand HermioneW = new HollyDefensive("HermioneW");
        MagicWand NevilleW = new OffensiveHawthorn("NevilleW");
        MagicWand HarryW = new OffensiveHawthorn("HarryW");
         
        Harry= new FelixFelicis(Harry);   
        Harry= new Invigoration(Harry);
        Hermione= new Invigoration(Hermione);
        Ron= new FelixFelicis(Ron);
                
        Harry.assignWand(HarryW);
        Ron.assignWand(RonW);
        Hermione.assignWand(HermioneW);
        Neville.assignWand(NevilleW);
        
        gryffindor.addCharacter(Harry);
        gryffindor.addCharacter(Ron);
        gryffindor.addCharacter(Hermione);
        gryffindor.addCharacter(Neville);
             
        h.addHouse("Gryffindor",gryffindor);
        
        Collections.sort(gryffindor.getWizardsList(),new ComparatorDefensivePoints());
 
        House hufflepuff = new House("Hufflepuff");
        
        Character Cedric = new Defensive("Cedric Diggory");
        Character Nymphadora = new Defensive("Nymphadora Tonks");
        Character Pomona = new Offensive("Pomona Sprout");
        Character Rolf = new Defensive("Rolf Scamander");
       
        MagicWand CedricW = new OffensiveHawthorn("CedricW");
        MagicWand NymphadoraW = new OffensiveHawthorn("NymphadoraW");
        MagicWand PomonaW = new OffensiveHawthorn("PomonaW");
        MagicWand RolfW= new OffensiveHawthorn("RolfW");
        
        Cedric= new Invigoration(Cedric);
        Pomona= new FelixFelicis(Pomona); 
        
        Cedric.assignWand(CedricW);
        Nymphadora.assignWand(NymphadoraW);
        Pomona.assignWand(PomonaW);
        Rolf.assignWand(RolfW);
               
        hufflepuff.addCharacter(Cedric);
        hufflepuff.addCharacter(Nymphadora);
        hufflepuff.addCharacter(Pomona);
        hufflepuff.addCharacter(Rolf);
        
        h.addHouse("Hufflepuff",hufflepuff);
        
        Collections.sort(hufflepuff.getWizardsList(),new ComparatorOffensivePoints());
        
        //inicializacion de Slytherin
        House slytherin = new House("Slytherin");
        
        Character Draco = new Defensive("Draco Malfoy");
        Character Pansy = new Offensive("Pansy Parkinson");
        Character Dolores = new Offensive("Dolores Umbridge");
        Character Albus = new Offensive("Albus Severus Potter");
        
        MagicWand DracoW= new HollyDefensive("DracoW");
        MagicWand PansyW= new OffensiveHawthorn("PansyW");
        MagicWand DoloresW = new HollyDefensive("DoloresW");
        MagicWand AlbusW = new HollyDefensive("AlbusW"); 
        
        
        Pansy= new FelixFelicis(Pansy);
        
        Draco.assignWand(DracoW);
        Pansy.assignWand(PansyW);
        Dolores.assignWand(DoloresW);
        Albus.assignWand(AlbusW);
               
        slytherin.addCharacter(Draco);
        slytherin.addCharacter(Pansy);
        slytherin.addCharacter(Dolores);
        slytherin.addCharacter(Albus);
        
        h.addHouse("Slytherin",slytherin);
        
        Collections.sort(slytherin.getWizardsList(),Collections.reverseOrder(new ComparatorOffensivePoints()));
      
        h.game();
    }
    
    public void InitData2(){
        //inilializacion Gryffindor
        
        MagicWand Wand1 = new OffensiveHawthorn("Ivy");
        MagicWand Wand2 = new OffensiveHawthorn("Larch");
        MagicWand Wand3 = new HollyDefensive("Rowan");
        MagicWand Wand4 = new OffensiveHawthorn("Yew");
        MagicWand Wand5 = new OffensiveHawthorn("Hazel");
        MagicWand Wand6 = new OffensiveHawthorn("Pine");
        MagicWand Wand7 = new HollyDefensive("Tamarack");
        MagicWand Wand8 = new OffensiveHawthorn("Spruce");
        MagicWand Wand9 = new OffensiveHawthorn("Pear");
        MagicWand Wand10 = new OffensiveHawthorn("Laurel");
        MagicWand Wand11 = new HollyDefensive("Cypress");
        MagicWand Wand12 = new HollyDefensive("Ebony");
        MagicWand Wand13 = new OffensiveHawthorn("Reed");
        MagicWand Wand14 = new HollyDefensive("Aspen");
        MagicWand Wand15 = new OffensiveHawthorn("Walnut");
        
        h.addReplacements(Wand1);
        h.addReplacements(Wand2);
        h.addReplacements(Wand3);
        h.addReplacements(Wand4);
        h.addReplacements(Wand5);
        h.addReplacements(Wand6);
        h.addReplacements(Wand7);
        h.addReplacements(Wand8);
        h.addReplacements(Wand9);
        h.addReplacements(Wand10);
        h.addReplacements(Wand11);
        h.addReplacements(Wand12);
        h.addReplacements(Wand13);
        h.addReplacements(Wand14);
        h.addReplacements(Wand15);
        
        Collections.sort(h.getReplacementList(),new ComparatorNameWand());
        
        House gryffindor = new House("Griffyndor");
        
        Character Harry = new Offensive("Harry Potter");
        Character Ron = new Offensive("Ron Weisley");
        Character Hermione = new Offensive("Hermione Granger");
        
        MagicWand HarryW = new HollyDefensive("HarryW");
        MagicWand RonW = new HollyDefensive("RonW");
        MagicWand HermioneW = new HollyDefensive("HermioneW");
       
        
        Harry= new Invigoration(Harry); 
        Harry= new FelixFelicis(Harry); 
        Hermione= new FelixFelicis(Hermione);
        Hermione= new Invigoration(Hermione);
        Ron= new FelixFelicis(Ron);
                
        Harry.assignWand(HarryW);
        Ron.assignWand(RonW);
        Hermione.assignWand(HermioneW);
        
        gryffindor.addCharacter(Harry);
        gryffindor.addCharacter(Ron);
        gryffindor.addCharacter(Hermione);
        
        Collections.sort(gryffindor.getWizardsList(),new ComparatorDefensivePoints());
        
        h.addHouse("Gryffindor",gryffindor);
        
        House hufflepuff = new House("Hufflepuff");
        
        Character Cedric = new Defensive("Cedric Diggory");
        Character Nymphadora = new Defensive("Nymphadora Tonks");
        Character Pomona = new Defensive("Pomona Sprout");
        Character Rolf = new Defensive("Rolf Scamander");
        Character Silvanus= new Defensive("Silvanus Kettlebrun");
        Character Susan= new Defensive("Susan Bones");
        Character Newton= new Defensive("Newton Scamander");
        Character Hannah= new Defensive("Hannah Abbot");
        
        MagicWand CedricW = new OffensiveHawthorn("CedricW");
        MagicWand NymphadoraW = new OffensiveHawthorn("NymphadoraW");
        MagicWand PomonaW = new OffensiveHawthorn("PomonaW");
        MagicWand RolfW= new OffensiveHawthorn("RolfW");
        MagicWand SilvanusW= new OffensiveHawthorn("SilvanusW");
        MagicWand SusanW= new OffensiveHawthorn("SusanW");
        MagicWand NewtonW= new OffensiveHawthorn("NewtonW");
        MagicWand HannahW= new OffensiveHawthorn("HannaW");
                      
        Cedric= new Invigoration(Cedric);
        Pomona= new FelixFelicis(Pomona); 
        Silvanus= new FelixFelicis(Silvanus);
        Hannah= new FelixFelicis(Hannah);
        
        Cedric.assignWand(CedricW);
        Nymphadora.assignWand(NymphadoraW);
        Pomona.assignWand(PomonaW);
        Rolf.assignWand(RolfW);
        Silvanus.assignWand(SilvanusW);
        Susan.assignWand(SusanW);
        Newton.assignWand(NewtonW);
        Hannah.assignWand(HannahW);
        
        hufflepuff.addCharacter(Cedric);
        hufflepuff.addCharacter(Nymphadora);
        hufflepuff.addCharacter(Pomona);
        hufflepuff.addCharacter(Rolf);
        hufflepuff.addCharacter(Silvanus);
        hufflepuff.addCharacter(Susan);
        hufflepuff.addCharacter(Newton);
        hufflepuff.addCharacter(Hannah);
        
        h.addHouse("Hufflepuff",hufflepuff);
        
        Collections.sort(hufflepuff.getWizardsList(),new ComparatorOffensivePoints());
        
        //inicializacion de Slytherin
        House slytherin = new House("Slytherin");
        
        Character Draco = new Defensive("Draco Malfoy");
        MagicWand DracoW= new HollyDefensive("DracoW");
        Draco=new FelixFelicis(Draco);
        Draco.assignWand(DracoW);
        
        slytherin.addCharacter(Draco);
        
        Collections.sort(slytherin.getWizardsList(),Collections.reverseOrder(new ComparatorOffensivePoints()));
        h.addHouse("Slytherin",slytherin);
        
       
        
        h.game();
	}
}