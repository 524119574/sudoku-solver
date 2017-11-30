public class Grid {
  private Square[][] gridTable = new Square[9][9];

  public void print() {
    for (Square[] row : this.gridTable) {
      System.out.print("|");
      for (Square square : row) {
        System.out.print(square);
        System.out.print("|");
      }
      System.out.print("\n");
//      System.out.print("\n------------------\n");
    }
  }

  boolean hasFreeSpace() {
    for (int i = 0; i < this.gridTable.length; i++) {
      for (int j = 0; j < this.gridTable[0].length; j++) {
        if (gridTable[i][j].isEmpty()) {
          return true;
        }
      }
    }
    return false;
  }

  boolean isGoodMove(int row, int col) {
    return this.gridTable[row][col].hasUniquePMark();
  }

  void makeMove(int row, int col) {
    if (isGoodMove(row,col)) {
      this.gridTable[row][col] = new Square(this.gridTable[row][col].uniquePMark());
    }
  }

  void removePMarks(int row, int col) {
    //search row
    for (int i = 0; i < this.gridTable[row].length; i++) {
      if (!this.gridTable[row][i].isEmpty()) {
        this.gridTable[row][col].removePMarkIfThere(this.gridTable[row][i].value());
      }
    }

    //search column
    for (int j = 0; j < this.gridTable.length; j++) {
      if (!this.gridTable[j][col].isEmpty()) {
        this.gridTable[row][col].removePMarkIfThere(this.gridTable[j][col].value());
      }
    }

    //search 3 by 3 square
    for (int i = row - 2; i < row +3; i++) {
      for (int j = col - 2; j < col + 3; j++) {
        if (i >= 0 && j >= 0 && i <= 8 && j <= 8 && this.gridTable[i][j].value() != 0 && (i/3) == (row/3) && (j/3) == (col/3)) {
          this.gridTable[row][col].removePMarkIfThere(this.gridTable[i][j].value());
        }
      }
    }
  }

//  void makeAdvancedMove(int row, int col) {
//    //search row
//    int[] possibilities = new int[10];
//
//    for (int i = 0; i < this.gridTable[row].length; i++) {
//      if (this.gridTable[row][i].isEmpty()) {
//        for (int j = 0; j < this.gridTable)
//
//      }
//    }
//
//
//
//
//    //search column
//    //search 3*3 block
//  }

//  // check if there is only one cell in a row where n is possible
//  private boolean checkRow(int row, int n) {
//
//  }
//  // check if there is only one cell in a column where n is possible
//  private boolean checkColumn(int col, int n) {
//
//  }
//  // check if there is only one cell in a block where n is possible
//  private boolean checkBlock(int row, int col, int n) {
//
//  }

  public Grid(int[][] numTable) {
    assert (numTable.length == 9 && numTable[0].length == 9) :
            "dimension not match";
    for (int i = 0; i < numTable.length; i++) {
      for (int j = 0; j < numTable[0].length; j++) {
        if (numTable[i][j] == 0) {
          this.gridTable[i][j] = new Square();
        } else {
          this.gridTable[i][j] = new Square(numTable[i][j]);
        }
      }
    }
  }
}
