public class LightBoard
{
  /** The lights on the board, where true represents on and false represents off.
   */
  private boolean[][] lights;

  /** Constructs a LightBoard object having numRows rows and numCols columns.
   * Precondition: numRows > 0, numCols > 0
   * Postcondition: each light has a 40% probability of being set to on.
   */
  public LightBoard(int numRows, int numCols)
  {
            lights = new boolean[numRows][numCols];
        Random rand = new Random();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                lights[r][c] = rand.nextDouble() < 0.4;
            }
        }
    }

  }

  /** Evaluates a light in row index row and column index col and returns a status
   *  as described in part (b).
   *  Precondition: row and col are valid indexes in lights.
   */
  public boolean evaluateLight(int row, int col)
  {
    int onCount = 0;
    for (int r = 0; r < lights.length; r++) {
        if (lights[r][col]) {
            onCount++;
        }
    }
    if (lights[row][col]) {
        return onCount % 2 == 0;
    } else {
        return onCount % 3 == 0;
    }
   
 
  }
  public boolean[][] getLights()
  {
    return lights;
  }
  //used for testing
  public String toString()
  {
    String s = "";
    for (int r = 0; r < lights.length; r++)
    {
      for (int c = 0; c < lights[0].length; c++)
        if (lights[r][c])
          s += "*";
        else
          s += ".";
      s += "\n";
    }
    return s;
  }
  
}
