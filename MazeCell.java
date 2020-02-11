package hw3;

import java.awt.Point;
import maze.Status;
import java.util.ArrayList;


/**
 * Implementation of MazeCell that has a location in a 2D plane.
 */
public class MazeCell 
{
  /**
   * the maze to which this MazeCell belongs. 
   */
  private Maze owner;
  /**
   * Status of this cell.
   */
  private Status status;
  private MazeCell parent;
  private int Row;
  private int Column;
  private ArrayList<MazeCell> neighbors;
  private int timeStamp;
  private Point location;
  
  
  
  /**
   * Constructs a MazeCell 
   * @param row
   * 	Row the MazeCell is in 
   * @param col
   * 	Column the MazeCell is in
   */
  public MazeCell(int row, int col) 
  {
	  parent = null;
	  neighbors = new ArrayList<MazeCell>();
	  status = Status.WALL;
	  Row = row;
	  Column = col;
	  timeStamp = 0;
	  location = new Point(row, col);
  }
    
 

  
  /**
   * Adds an observer for changes in this cell's status.
   * @param obs
   */
  public void setOwner(Maze maze)
  {
    owner = maze;    
  }
  
  
  /**
   * Update the status of this cell and notifies the owner that this current cell's status has changed 
   * @param cell
   */
  public void setStatus(Status s)
  {
    status = s;
    if (owner != null)
    {
      owner.updateStatus(this);
    }
  }

  /**
   * return the status of the current the status
   * @return status
   */
  public Status getStatus()
  {
    return status;
  }

  
 /**
  * Returns a string with the points in (x,y) form
  */
public String toString()
{	
	 return "(" + Row + "," + Column + ")";
}

 

 /**
  * Adds a Neighbor to the Cell
  * @param m
  * 	MazeCell to be added to neighbor list
  */
 public void addNeighbor(MazeCell m) 
 {
	 neighbors.add(m);
 }
  
 
 
 /**
  * returns the distance between two points
  * @param other
  * 	MazeCell to find distance between
  * @return
  * 	Distance between the two Cells
  */
 public int distance(MazeCell other) 
 {

	 Point temp = other.getLocation();
	
	 int distance = (Row - temp.x)  + (Column - temp.y) ;
	 
	 return Math.abs(distance);	
 }
 
 /**
  * Returns the locations of the MazeCell in a Point
  * @return
  * 	Location of a Cell as a Point
  */
 public Point getLocation() 
 {
	 return location;
 }
  
  
 /**
  * List of all the neighbors the cell has
  * @return
  * 	The ArrayList of all neighbors
  */
public ArrayList<MazeCell> getNeighbors()
{
	return neighbors;
}
  

/**
 * Returns parent of the Cell
 * @return
 * 		Parent of the Cell
 */
public MazeCell getParent() 
{	
	return parent;
}
  

/**
 * Gets the timestamp
 * @return
 * 		Timestamp
 */
public int getTimeStamp() 
{	
	return timeStamp;
}

/**
 * Sets the parent of the Cell
 * @param rent
 * 		MazeCell to be the parent 
 */
public void setParent(MazeCell rent) 
{
	parent = rent;	
}


/**
 * Sets the timeStamp
 * @param x
 * 		Timestamp 
 */
public void setTimeStamp(int x) 
{
	timeStamp = x;
}






}






