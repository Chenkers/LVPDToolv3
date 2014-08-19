/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lvpd.tool;

/**
 *
 * @author Chenko
 */
public class CrimeObject {
    
    private String cName;
    private int cCategory;
    private int cTime;
    private int cFine;
    private int cStrikes;
    
    public void createCrime(String name) {
        cName = name;
    }
    
    public String crimeGetName() {
        return cName;
    }
    
    public int crimeGetCat() {
        return cCategory;
    }
    
    public int crimeGetTime() {
        return cTime;
    }
    
    public int crimeGetFine() {
        return cFine;
    }
    
    public int crimeGetStrikes() {
        return cStrikes;
    }
    
    public void crimeSetName(String name) {
        cName = name;
    }
    
    public void crimeSetCat(int cat) {
        cCategory = cat;
    }
    
    public void crimeSetTime(int time) {
        cTime = time;
    }
    
    public void crimeSetFine(int fine) {
        cFine = fine;
    }
    
    public void crimeSetStrikes(int strikes) {
        cStrikes = strikes;
    }
}
