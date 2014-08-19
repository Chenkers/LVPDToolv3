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
        loadCrime("Failure to Provide ID");
        loadCrime("Illegal Shortcut");
        loadCrime("Unlawful Hydraulics");
        loadCrime("Unlawful Nos");
        loadCrime("Reckless Driving");
        loadCrime("Reckless Endangerment");
        loadCrime("Street Racing");
        loadCrime("Driving w/o Due Care");
        
        loadCrime("Verbal Assualt");
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
        loadCrime("Firearm Possession (Katana)");
        loadCrime("Firearm Possession (Silenced)");
        loadCrime("Firearm Possession (Deagle)");
        loadCrime("Firearm Possession (Low Caliber)");
        loadCrime("Firearm Possession (High Caliber)");
        loadCrime("Vehicular Assualt");
        loadCrime("Attempted GTA");
        loadCrime("Grand Theft Auto");
        loadCrime("DUI");
        loadCrime("Narcotics Possession");
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
    
}
