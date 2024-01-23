package CustomDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Snapshot array
public class Problem_01 {
    class SnapshotArray {  
    List<Integer> nodes;
    List<List<Integer>> snap;
    public SnapshotArray(int length) {
      nodes = new ArrayList<Integer>(Collections.nCopies(length,0));
      snap = new ArrayList<>();
    }

    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int state) {
      nodes.set(idx,state);
    }

    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {
      snap.add(new ArrayList<>(nodes));
      return snap.size()-1;
    }

    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {
      if(snapshotId1 < 0)
        return -1;
      return snap.get(snapshotId1).get(idx);
    }
}
}
