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
public class GlobalManager {
    
    public static final String APP_NAME = "LVPD Tool";
    public static final String VERSION = "Ver: BETA";
    public static final String AUTHOR = "Chenko";
    public static final String SUPPORT_URL = "https://streamtip.com/t/russian_dr";
    
    public static final int CAT_VEHICULAR = 1;
    public static final int CAT_LIGHT = 2;
    public static final int CAT_MEDIUM = 3;
    public static final int CAT_HEAVY = 4;
    public static final int CAT_CAPITAL = 5;
    
    public static boolean defaultCursor;
    public static int MaxTime = 0;
    public static int MaxFine = 0;
    public static int MaxStrikes = 0;
    public static int LifetimeCrimes = 0;
    public static int LifetimeTime = 0;
    public static int LifetimeFine = 0;
    public static int LifetimeStrikes = 0;
}