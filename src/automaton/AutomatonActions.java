/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

/**
 * Acties omzetten naar 
 * @author Tom Mahieu
 */
public enum AutomatonActions {
    DRAGON,
    SWORD,
    ARC,
    RIVER,
    KEY,
    GATE,
    TREASURE,
    EMPTY;
    
    /**
     * Karakter die in de file staat wordt omgezet tot een actie.
     * @param c karakter die in de file staat wordt omgezet tot een actie.
     * @return actie die een traject heeft.
     * @throws java.lang.Exception als het karakter niet herkent word.
     */
    public static AutomatonActions getAction(char c) throws Exception{
        switch(c){
            case 'D':
            case 'd':
                return DRAGON;
            case 'S':
            case 's':
                return SWORD;
            case 'A':
            case 'a':
                return ARC;
            case 'R':
            case 'r':
                return RIVER;
            case 'K':
            case 'k':
                return KEY;
            case 'G':
            case 'g':
                return GATE;
            case 'T':
            case 't':
                return TREASURE;
            case '$':
                return EMPTY;
        } throw new Exception("File not formatted right!");
    }
    
    /**
     * Get the print value of an automaton action.
     * @param a An action the automaton can have, this is an enum.
     * @return A letter to print out.
     */
    public static String getPrintValue(AutomatonActions a){
        switch(a){
            case DRAGON:
                return "D";
            case SWORD:
                return "S";
            case ARC:
                return "A";
            case RIVER:
                return "R";
            case KEY:
                return "K";
            case GATE:
                return "G";
            case TREASURE:
                return "T";
            case EMPTY:
            default:
                return "$";
        }
    }
}
