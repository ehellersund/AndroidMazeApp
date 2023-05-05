package edu.wm.cs.cs301.gui;

import edu.wm.cs.cs301.generation.Maze;

//Class used to pass around the finished maze to whatever activity needs it
public class MazeObject {
    private static Maze maze;

    public static Maze getMaze() { return maze; }

    public static void setMaze(Maze input) { maze = input; }

}
