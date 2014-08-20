/*
 * Copyright (C) 2014 Chenko
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package lvpd.tool;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chenko
 */
public class CrimeManager {
    
    public static Map<String, CrimeObject> crimeObjects = new HashMap<String, CrimeObject>();
    public static Map<CrimeObject, javax.swing.JCheckBox> crimeCheckBoxes = new HashMap<CrimeObject, javax.swing.JCheckBox>();
    
    public static void initCrimeManager() {
        Logger.Logger("Initializing crime manager...");
        
        loadCrime("Illegal Parking");
        loadCrime("Failure to Provide Reg");
        loadCrime("Illegal Shortcut");
        loadCrime("Unlawful Hydraulics");
        loadCrime("Unlawful Nos");
        loadCrime("Reckless Driving");
        loadCrime("Reckless Endangerment");
        loadCrime("Street Racing");
        loadCrime("Driving w/o Due Care");
        
        loadCrime("Verbal Assault");
        loadCrime("Loitering");
        loadCrime("Trespassing");
        loadCrime("Indecent Exposure");
        loadCrime("Lewd Gesture");
        loadCrime("Vandalism");
        loadCrime("Affray");
        loadCrime("Misuse of 911");
        loadCrime("Failure to Provide License");
        loadCrime("Resisting Arrest");
        loadCrime("Evading Arrest (Foot)");
        loadCrime("Evading Arrest (Veh)");
        loadCrime("Disorderly Conduct");
        loadCrime("Failure to Pay Ticket");
        loadCrime("Aiding & Abetting (Light)");
        
        loadCrime("Firearm Possession");
        loadCrime("Firearm Possession (Katana / Brass Knuckles)");
        loadCrime("Firearm Possession (Silenced)");
        loadCrime("Firearm Possession (Deagle)");
        loadCrime("Firearm Possession (Low Caliber)");
        loadCrime("Firearm Possession (High Caliber)");
        loadCrime("Vehicular Assault");
        loadCrime("Attempted GTA");
        loadCrime("Grand Theft Auto");
        loadCrime("DUI");
        loadCrime("Narcotics Possession");
        loadCrime("Narcotics Possession (Cocaine >= 1)");
        loadCrime("Narcotics Possession (Cocaine >= 6)");
        loadCrime("Narcotics Possession (Cocaine >= 21)");
        loadCrime("Narcotics Possession (Cocaine >= 41)");
        loadCrime("Narcotics Possession (Cocaine >= 61)");
        loadCrime("Narcotics Possession (Cocaine >= 81)");
        loadCrime("Narcotics Possession (Cocaine >= 101)");
        loadCrime("Narcotics Possession (Cocaine >= 121)");
        loadCrime("Narcotics Possession (Cocaine >= 141)");
        loadCrime("Narcotics Possession (Pot >= 1)");
        loadCrime("Narcotics Possession (Pot >= 21)");
        loadCrime("Narcotics Possession (Pot >= 101)");
        loadCrime("Narcotics Possession (Pot >=  201)");
        loadCrime("Narcotics Possession (Speed >= 1)");
        loadCrime("Narcotics Possession (Speed >= 6)");
        loadCrime("Narcotics Possession (Speed >= 21)");
        loadCrime("Narcotics Possession (Speed >= 51)");
        loadCrime("Narcotics Possession (Speed >= 101)");
        loadCrime("Narcotics Possession (Speed >= 201)");
        loadCrime("Impersonating LEO");
        loadCrime("Obstruction");
        loadCrime("Conspiracy");
        loadCrime("Hit & Run");
        loadCrime("Trafficking");
        loadCrime("Trafficking (Materials)");
        loadCrime("Trafficking (Firearms)");
        loadCrime("Trafficking (Narcotics)");
        loadCrime("Harassment");
        loadCrime("Unlawful Discharge");
        loadCrime("Unlawful Discharge (Single)");
        loadCrime("Unlawful Discharge (Multiple)");
        loadCrime("Public Endangerment");
        loadCrime("Fraud");
        loadCrime("Lying to an LEO");
        loadCrime("Driving whilst Suspended");
        loadCrime("Aiding & Abetting (Med)");
        loadCrime("Materials Possession");
        loadCrime("Materials Possession ( >= 1)");
        loadCrime("Materials Possession ( >= 11)");
        loadCrime("Materials Possession ( >= 31)");
        loadCrime("Materials Possession ( >= 61)");
        loadCrime("Materials Possession ( >= 91)");
        loadCrime("Materials Possession ( >= 121)");
        loadCrime("Materials Possession ( >= 151)");
        loadCrime("Materials Possession ( >= 301)");
        loadCrime("Attempted Murder");
        loadCrime("Attempted Murder (of LEO)");
        loadCrime("Instigating Anarchy");
        loadCrime("Kidnapping");
        loadCrime("Kidnapping (of LEO)");
        loadCrime("Racketeering");
        loadCrime("Armed Robbery");
        loadCrime("Illegal Gambling");
        loadCrime("Bribery");
        loadCrime("Assault");
        loadCrime("Assault & Battery");
        loadCrime("Assault w/ Deadly Weapon");
        loadCrime("Assault (of LEO)");
        loadCrime("Assault & Battery (of LEO)");
        loadCrime("Assault w/ Deadly Weapon (of LEO)");
        loadCrime("Extortion");
        loadCrime("Scamming");
        loadCrime("Arson");
        loadCrime("Aiding & Abetting (Heavy)");
        loadCrime("Robbery");
        
        loadCrime("Terrorism");
        loadCrime("Successful Murder");
        loadCrime("Successful Murder (of LEO)");
        loadCrime("Mass Murder");
        loadCrime("Police Corruption");
        loadCrime("Piracy (Sea)");
    }
    
    private static void loadCrime(String name) {
        CrimeObject obj = new CrimeObject();
        obj.createCrime(name);
        crimeObjects.put(name, obj);
        Database.loadCrime(obj);
    }
    
    public static CrimeObject getCrimeObjectByName(String name) {
        CrimeObject obj = null;
        for(String key : crimeObjects.keySet()) {
            if(key.equalsIgnoreCase(name)) {
                obj = crimeObjects.get(key);
                break;
            }
        }
        return obj;
    }
    
    public static void addCheckBox(CrimeObject obj, javax.swing.JCheckBox box) {
        crimeCheckBoxes.put(obj, box);
    }
    
    public static javax.swing.JCheckBox getCrimeCheckBoxByName(String name) {
        CrimeObject obj = getCrimeObjectByName(name);
        return crimeCheckBoxes.get(obj);
    }
    
    public static void updateToolTip(CrimeObject obj) {
        for(CrimeObject key : crimeCheckBoxes.keySet()) {
            if(key == obj) {
                CrimeManager.crimeCheckBoxes.get(key).setToolTipText("<html><b>" + key.crimeGetName() + "</b><br><br><b>Time: </b>" + key.crimeGetTime() + " minutes<br><b>Fine: </b>$" + key.crimeGetFine() + "<br><b>Strikes:</b> " + key.crimeGetStrikes() + "</html>");
            }
        }
    }
}
