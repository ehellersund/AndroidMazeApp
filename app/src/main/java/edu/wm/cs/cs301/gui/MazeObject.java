package edu.wm.cs.cs301.gui;

import edu.wm.cs.cs301.generation.Maze;

//Class used to pass around the finished maze to whatever activity needs it
public class MazeObject {
    private static Maze maze;
    public static Maze getMaze() { return maze; }
    public static void setMaze(Maze input) { maze = input; }
    //-----
    private static String driver = null;
    public static String getDriver() { return driver; }
    public static void setDriver(String inDriver) { driver = inDriver; }
    //-----
    private static String quality;
    public static String getQuality() { return quality; }
    public static void setQuality(String inQuality) { quality = inQuality; }
    //-----
    private static float battery;
    public static float getBattery() { return battery; }
    public static void setBattery(float inBat) { battery = inBat; }
    //-----
    private static int distance;
    public static int getDistance() { return distance; }
    public static void setDistance(int inDis) { distance = inDis; }
    //-----
    public static boolean botOn = true;
    public static void roboToggle() { botOn = !botOn; }
}
