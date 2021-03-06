package lvpd.tool;


import java.io.*;

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

/**
 *
 * @author Chenko
 */
public class Logger {
    
    public static void initLogger() {
        
        File dir = new File(FileManager.mainDirectory);
        
        if(!dir.isDirectory()) {
            dir.mkdir();
        }
        
        dir = new File(FileManager.logPath);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
        
        dir = new File(FileManager.logFile);
        if(!dir.isFile()) {
            try {
                dir.createNewFile();
            }
            catch (IOException e){
                Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
            }
        }
        
        dir = new File(FileManager.errorLogFile);
        if(!dir.isFile()) {
            try {
                dir.createNewFile();
            }
            catch (IOException e) {
                Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
            }
        }
        
        try {
            System.setOut((new PrintStream(new FileOutputStream(FileManager.logFile))));
            System.setErr((new PrintStream(new FileOutputStream(FileManager.errorLogFile))));
        }
        catch (FileNotFoundException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
        Logger("Logger initialzed.");
    }
    
    public static void Logger(String string) {
        
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = format.format(date);
        String log = "[" + formattedDate + "] " + string;
     
        System.out.println(log);
        
        if(MainGUI.textAreaConsole != null) {
            try {
                MainGUI.textAreaConsole.setText(new java.util.Scanner(new File(FileManager.logFile)).useDelimiter("\\A").next());
            }
            catch (FileNotFoundException e) {
                Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
            }
        }
    }
}
