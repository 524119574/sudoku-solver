public class Square {
  private int value;
  private boolean[] pencilMarks;

  public Square() {
    this.value = 0;
    // as it has 9 possible numbers, but we start the array at index1, we'll
    // not use index 0 here;
    this.pencilMarks = new boolean[10];
    for (int i = 1; i < 10; i++) {
      this.pencilMarks[i] = true;
    }
  }

  public Square(int value) {
    assert(value > 0 && value < 10):
      "value should between 0 to 9";
    this.value = value;
    pencilMarks = new boolean[0];
  }

  int value() {
    return value;
  }

  boolean isEmpty() {
    return (this.value == 0) ? true : false;
  }

  boolean hasUniquePMark() {
    int trueCount  = 0;
    for (int i = 1; i < this.pencilMarks.length; i++) {
      if (this.pencilMarks[i] == true) {
        trueCount++;
      }
    }
    return (trueCount == 1) ? true : false;
  }

  int uniquePMark() {
    if (hasUniquePMark()) {
      for (int i = 1; i < this.pencilMarks.length; i++) {
        if (this.pencilMarks[i] == true) {
          return i;
        }
      }
    }
    return -1;
  }

  void removePMarkIfThere(int n) {
    assert (n > 0 && n < 10):
            "integer should be in the range 1 to 9 inclusive";
    if (this.pencilMarks.length > 0) {
      this.pencilMarks[n] = false;
    }
  }

  public String toString() {
    return String.valueOf(this.value);
  }
}
