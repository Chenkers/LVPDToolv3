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

import java.io.*;

/**
 *
 * @author Chenko
 */
public class FileManager {
    
    public static final String mainDirectory = System.getProperty("user.home") + "\\Documents\\LVPDTool\\";
    public static final String logPath = mainDirectory + "Logs";
    public static final String logFile = logPath + "\\Log.txt";
    public static final String errorLogFile = logPath + "\\ErrorLog.txt";
    
    
    public static void initFileManager() {
        Logger.Logger("Initializing file manager...");
        File dir = new File(mainDirectory);
        
        if(!dir.isDirectory()) {
            dir.mkdir();
        }
    }
}
