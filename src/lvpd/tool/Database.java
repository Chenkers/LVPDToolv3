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

import java.sql.*;

/**
 *
 * @author Chenko
 */
public class Database {
    
    public static Connection main_db = null;
    private static Statement stmt = null;
    
    public static void initDatabase() {
        Logger.Logger("Initializing database...");
        try {
            Class.forName("org.sqlite.JDBC");
            main_db = DriverManager.getConnection("jdbc:sqlite:"+ FileManager.mainDirectory + "main.db");
            
            stmt = main_db.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS 'Crimes' " +
                         "(Name TEXT NOT NULL, Category INTEGER, Time INTEGER, Fine INTEGER, Strikes INTEGER)";
            Logger.Logger("RUNNING QUERY: " + sql);
            stmt.executeUpdate(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS 'General' (CursorStatus INTEGER, MaxFine INTEGER, MaxTime INTEGER, MaxStrikes INTEGER, LifetimeCrimes INTEGER, LifetimeTime INTEGER, LifetimeFine INTEGER, LifetimeStrikes INTEGER)";
            Logger.Logger("RUNNING QUERY: " + sql);
            stmt.executeUpdate(sql);
            stmt.close(); 
        }
        catch (SQLException | ClassNotFoundException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
        Logger.Logger("Opened database succesfully.");
        loadGeneral();
    }
    
    public static void loadCrime(CrimeObject crime) {
        try {
            stmt = main_db.createStatement();
            String sql = "SELECT * FROM Crimes WHERE Name = '" + crime.crimeGetName() + "'";
            Logger.Logger("RUNNING QUERY: " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!rs.next()) { //If the crime doesnt exist in the database then create it.
                try {
                    sql = "INSERT INTO Crimes (Name) VALUES ('"+ crime.crimeGetName() + "')";
                    Logger.Logger("RUNNING QUERY: " + sql);
                    stmt.executeUpdate(sql);
                    Logger.Logger("Inserted crime " + crime.crimeGetName() + " into the database.");
                }
                catch (SQLException e) {
                    Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
                }
            }
            else {
                crime.crimeSetCat(rs.getInt("Category"));
                crime.crimeSetTime(rs.getInt("Time"));
                crime.crimeSetFine(rs.getInt("Fine"));
                crime.crimeSetStrikes(rs.getInt("Strikes"));
                Logger.Logger("Loaded crime " + crime.crimeGetName() + " from the database.");
            }
            
            stmt.close();
        }
        catch (SQLException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    
    public static void saveCrime(CrimeObject crime) {
        try {
            stmt = main_db.createStatement();
            String sql = "UPDATE Crimes SET Category = '" + crime.crimeGetCat() + "', Time = '"+ crime.crimeGetTime() + "', Fine = '" + crime.crimeGetFine() + "', Strikes = '" + crime.crimeGetStrikes() + "' WHERE Name = '" + crime.crimeGetName() + "'";
            Logger.Logger("RUNNING QUERY: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch (SQLException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    
    public static void loadGeneral() {
        try {
            stmt = main_db.createStatement();
            String sql = "SELECT * FROM General";
            Logger.Logger("RUNNING QUERY: " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                
                int num = rs.getInt("CursorStatus");
                if(num == 0)
                    GlobalManager.defaultCursor = false;
                else GlobalManager.defaultCursor = true;
                
                GlobalManager.MaxTime = rs.getInt("MaxTime");
                GlobalManager.MaxFine = rs.getInt("MaxFine");
                GlobalManager.MaxStrikes = rs.getInt("MaxStrikes");
                GlobalManager.LifetimeCrimes = rs.getInt("LifetimeCrimes");
                GlobalManager.LifetimeTime = rs.getInt("LifetimeTime");
                GlobalManager.LifetimeFine = rs.getInt("LifetimeFine");
                GlobalManager.LifetimeStrikes = rs.getInt("LifetimeStrikes");
            }
            stmt.close();
        }
        catch (SQLException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    
    public static void saveGeneral() {
        try {
            stmt = main_db.createStatement();
            String sql = "UPDATE General SET MaxTime = '" + GlobalManager.MaxTime + "', MaxFine = '" + GlobalManager.MaxFine + "', MaxStrikes = '" + GlobalManager.MaxStrikes + "', LifetimeCrimes = '" + GlobalManager.LifetimeCrimes + "', LifetimeTime = '" + GlobalManager.LifetimeTime + "', LifetimeFine = '" + GlobalManager.LifetimeFine + "', LifetimeStrikes = '" + GlobalManager.LifetimeStrikes +"'";
            Logger.Logger("RUNNING QUERY: " + sql);
            int rows = stmt.executeUpdate(sql);
            
            if(rows == 0) {
                sql = "INSERT INTO General (MaxTime) VALUES (123)";
                Logger.Logger("RUNNING QUERY: " + sql);
                stmt.executeUpdate(sql);
                sql = "UPDATE General SET MaxTime = '" + GlobalManager.MaxTime + "', MaxFine = '" + GlobalManager.MaxFine + "', MaxStrikes = '" + GlobalManager.MaxStrikes + "', LifetimeCrimes = '" + GlobalManager.LifetimeCrimes + "', LifetimeTime = '" + GlobalManager.LifetimeTime + "', LifetimeFine = '" + GlobalManager.LifetimeFine + "', LifetimeStrikes = '" + GlobalManager.LifetimeStrikes +"'";
                Logger.Logger("RUNNING QUERY: " + sql);
                stmt.executeUpdate(sql);
            }
            stmt.close();
        }
        catch (SQLException e) {
            Logger.Logger( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
