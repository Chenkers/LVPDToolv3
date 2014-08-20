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
public class Reset {
    public static void Reset() {
        
        for(CrimeObject key : CrimeManager.crimeCheckBoxes.keySet()) {
            CrimeManager.crimeCheckBoxes.get(key).setSelected(false);
        }
        MainGUI.firearmComboBox.setSelectedIndex(0);
        MainGUI.comboBoxDischarge.setSelectedIndex(0);
        MainGUI.comboBoxTrafficking.setSelectedIndex(0);
        MainGUI.radioButtonAttemptedMurder.setSelected(false);
        MainGUI.radioButtonKidnapping.setSelected(false);
        MainGUI.radioButtonMurder.setSelected(false);
        MainGUI.radioButtonCocaine.setSelected(false);
        MainGUI.radioButtonSpeed.setSelected(false);
        MainGUI.radioButtonPot.setSelected(false);
        MainGUI.radioButtonAssault.setSelected(false);
        MainGUI.spinnerCocaine.setValue(0);
        MainGUI.spinnerSpeed.setValue(0);
        MainGUI.spinnerPot.setValue(0);
        MainGUI.spinnerPlayerID.setValue(0);
        MainGUI.spinnerMats.setValue(0);
        MainGUI.textCommand.setText("");
        MainGUI.textFieldName.setText("No underscore");
        MainGUI.labelResults.setText("<html><b>Fine:</b> $0<br><br><b>Time: </b>0 minutes<br><br><b>Strikes: </b>0");
        Logger.Logger("Reset everything.");
    }
}
