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

import static java.awt.Cursor.*;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Chenko
 */
public class ActionManager {
    
    public static void OnAction(ActionEvent evt) {
        MainGUI gui = new MainGUI();
        Logger.Logger("Action manager called: " + evt.getActionCommand());
        
        String action = evt.getActionCommand();
        
        switch(action) {
            case "Close":
                if(evt.getSource() == gui.closeAboutDialog) {
                    gui.aboutDialog.setVisible(false);
                }
                break;
            case "Exit":
                Database.saveGeneral();
                System.exit(0);
                break;
            case "Toggle Custom Cursor": 
                if(GlobalManager.defaultCursor == false) {
                    Frame[] frames = MainGUI.getFrames();
                    for (Frame frame : frames) {
                        frame.setCursor(getDefaultCursor());
                    }
                    GlobalManager.defaultCursor = true;
                }
                else {
                    Frame[] frames = MainGUI.getFrames();
                    for (Frame frame : frames) {
                        frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("resources/images/Cursor.png")), new Point(MainGUI.mainPanel.getX(), MainGUI.mainPanel.getY()), "img"));
                    }
                    GlobalManager.defaultCursor = false;
                }
                break;
            case "About the LVPD Tool":
                gui.aboutDialog.setVisible(true);
                break;
            case "Support the Dev":
                try {
                    URL support = new URL(GlobalManager.SUPPORT_URL);
                    java.awt.Desktop.getDesktop().browse(support.toURI());
                }
                catch (IOException | URISyntaxException e) {
                    Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
                }
                break;
        }
    }
}