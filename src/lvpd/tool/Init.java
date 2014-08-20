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
public class Init {
    public static void main(String args[]) {
        Logger.initLogger();
        Logger.Logger("Loading application...");
        FileManager.initFileManager();
        SplashScreen.splashInit();
        Database.initDatabase();
        CrimeManager.initCrimeManager();
        MainGUI.initGui();
        SplashScreen.splashExit();
        
        
        int count = 0;
        for(CrimeObject key : CrimeManager.crimeCheckBoxes.keySet()) {
            if(key != null) {
                count ++;
                CrimeManager.crimeCheckBoxes.get(key).setToolTipText("<html><b>" + key.crimeGetName() + "</b><br><br><b>Time: </b>" + key.crimeGetTime() + " minutes<br><b>Fine: </b>$" + key.crimeGetFine() + "<br><b>Strikes:</b> " + key.crimeGetStrikes() + "</html>");
            }
        }
        Logger.Logger("Counted " + count + " values in crimeCheckBoxes Hashmap");
        
        MainGUI.textMaxTime.setText(Integer.toString(GlobalManager.MaxTime));
        MainGUI.textMaxFine.setText(Integer.toString(GlobalManager.MaxFine));
        MainGUI.textMaxStrikes.setText(Integer.toString(GlobalManager.MaxStrikes));
        
        Logger.Logger("Application loaded.");
    }
}
