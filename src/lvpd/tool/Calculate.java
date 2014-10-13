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

/**
 *
 * @author Chenko
 */
public class Calculate {
    
    public static void Calculate() {
        
        int totalTime = 0, totalFine = 0, totalStrikes = 0, totalCrimes = 0;
        
        for(CrimeObject key : CrimeManager.crimeCheckBoxes.keySet()) {
            if(CrimeManager.crimeCheckBoxes.get(key).isSelected()) {
                
                if(key.crimeGetName().equalsIgnoreCase("Firearm Possession")) {
                    key = CrimeManager.getCrimeObjectByName("Firearm Possession (" + MainGUI.firearmComboBox.getSelectedItem().toString() + ")");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Trafficking")) {
                    key = CrimeManager.getCrimeObjectByName("Trafficking (" + MainGUI.comboBoxTrafficking.getSelectedItem().toString() + ")");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Unlawful Discharge")) {
                    key = CrimeManager.getCrimeObjectByName("Unlawful Discharge (" + MainGUI.comboBoxDischarge.getSelectedItem().toString() + ")");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Attempted Murder") && MainGUI.radioButtonAttemptedMurder.isSelected()) {
                    key = CrimeManager.getCrimeObjectByName("Attempted Murder (of LEO)");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Kidnapping") && MainGUI.radioButtonKidnapping.isSelected()) {
                    key = CrimeManager.getCrimeObjectByName("Kidnapping (of LEO)");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Successful Murder") && MainGUI.radioButtonMurder.isSelected()) {
                    key =  CrimeManager.getCrimeObjectByName("Successful Murder (of LEO)");
                }
                else if(key.crimeGetName().contains("Assault" ) && MainGUI.radioButtonAssault.isSelected()) {
                    key = CrimeManager.getCrimeObjectByName( key.crimeGetName() + " (of LEO)");
                }
                else if(key.crimeGetName().equalsIgnoreCase("Narcotics Possession")) {
                    CrimeObject temp;
                    if(MainGUI.radioButtonCocaine.isSelected()) {
                        temp = CrimeManager.getCrimeObjectByName("Narcotics Possession (Cocaine >= " + roundValue( (int) MainGUI.spinnerCocaine.getValue(), GlobalManager.VALUE_TYPE_COCAINE) + ")");
                        totalTime += temp.crimeGetTime();
                        totalFine += temp.crimeGetFine();
                        totalStrikes += temp.crimeGetStrikes();
                        totalCrimes ++;
                    }
                    if(MainGUI.radioButtonSpeed.isSelected()) {
                        temp = CrimeManager.getCrimeObjectByName("Narcotics Possession (Speed >= " + roundValue( (int) MainGUI.spinnerSpeed.getValue(), GlobalManager.VALUE_TYPE_SPEED) + ")");
                        totalTime += temp.crimeGetTime();
                        totalFine += temp.crimeGetFine();
                        totalStrikes += temp.crimeGetStrikes();
                        totalCrimes ++;
                    }
                    if(MainGUI.radioButtonPot.isSelected()) {
                        temp = CrimeManager.getCrimeObjectByName("Narcotics Possession (Pot >= " + roundValue( (int) MainGUI.spinnerPot.getValue(), GlobalManager.VALUE_TYPE_POT) + ")");
                        totalTime += temp.crimeGetTime();
                        totalFine += temp.crimeGetFine();
                        totalStrikes += temp.crimeGetStrikes();
                        totalCrimes ++;
                    }  
                }
                else if(key.crimeGetName().equalsIgnoreCase("Materials Possession")) {
                    key = CrimeManager.getCrimeObjectByName("Materials Possession ( >= " + roundValue( (int) MainGUI.spinnerMats.getValue(), GlobalManager.VALUE_TYPE_MATS) + ")");
                }
                
                totalTime += key.crimeGetTime();
                totalFine += key.crimeGetFine();
                if(key.crimeGetStrikes() > totalStrikes)
                    totalStrikes = key.crimeGetStrikes();
                totalCrimes ++;
            }
        }
        if(totalTime > GlobalManager.MaxTime) 
            totalTime = GlobalManager.MaxTime;
                
        if(totalFine > GlobalManager.MaxFine) 
            totalFine = GlobalManager.MaxFine;

        if(totalStrikes > GlobalManager.MaxStrikes) 
            totalStrikes = GlobalManager.MaxStrikes;
        
        MainGUI.labelResults.setText("<html><b>Fine:</b> $"+ totalFine +"<br><br><b>Time: </b>" + totalTime +" minutes<br><br><b>Strikes: </b>" + totalStrikes);
        MainGUI.textCommand.setText("/arrest " + MainGUI.spinnerPlayerID.getValue() + " " + totalTime + " " + totalFine + " " + totalStrikes);
        Logger.Logger("Calculated command: " + "/arrest " + MainGUI.spinnerPlayerID.getValue() + " " + totalTime + " " + totalFine + " " + totalStrikes);
        GlobalManager.LifetimeCrimes += totalCrimes;
        GlobalManager.LifetimeTime += totalTime;
        GlobalManager.LifetimeFine += totalFine;
        GlobalManager.LifetimeStrikes += totalStrikes;
        Database.saveGeneral();
    }
    
    public static int roundValue(int value, int value_type) {
        
        switch(value_type) {
            case GlobalManager.VALUE_TYPE_COCAINE:
                if(value >= 141) 
                    value = 141;
                else if(value >= 121) {
                    value = 121;
                }
                else if(value >= 101) {
                    value = 101;
                }
                else if(value >= 81) {
                    value = 81;
                }
                else if(value >= 61) {
                    value = 61;
                }
                else if(value >= 41) {
                    value = 41;
                }
                else if(value >= 21) {
                    value = 21;
                }
                else if(value >= 6) {
                    value = 6;
                }
                else if(value >= 1) {
                    value = 1;
                }
                break;
            case GlobalManager.VALUE_TYPE_MATS:
                if(value >= 301) 
                    value = 301;
                else if(value >= 151) {
                    value = 151;
                }
                else if(value >= 121) {
                    value = 121;
                }
                else if(value >= 91) {
                    value = 91;
                }
                else if(value >= 61) {
                    value = 61;
                }
                else if(value >= 31) {
                    value = 31;
                }
                else if(value >= 11) {
                    value = 11;
                }
                else if(value >= 1) {
                    value = 1;
                }
                break;
            case GlobalManager.VALUE_TYPE_POT:
                if(value >= 201) 
                    value = 201;
                else if(value >= 101) {
                    value = 101;
                }
                else if(value >= 21) {
                    value = 21;
                }
                else if(value >= 1) {
                    value = 1;
                }
                break;
            case GlobalManager.VALUE_TYPE_SPEED:
                if(value >= 201) 
                    value = 201;
                else if(value >= 101) {
                    value = 101;
                }
                else if(value >= 51) {
                    value = 51;
                }
                else if(value >= 21) {
                    value = 21;
                }
                else if(value >= 6) {
                    value = 6;
                }
                else if(value >= 1) {
                    value = 1;
                }
                break;
        }
        
        return value;
    }
}
