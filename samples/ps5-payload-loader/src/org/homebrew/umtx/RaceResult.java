package org.homebrew.umtx;

public class RaceResult {
    public int returnCode;
    public int numTries;
    public int lookupFd;
    public int reclaimFd;

    public RaceResult(int returnCode) {
        this.returnCode = returnCode;
    }

    public RaceResult(int numTries, int lookupFd, int reclaimFd) {
        this.returnCode = 0;
        this.numTries = numTries;
        this.lookupFd = lookupFd;
        this.reclaimFd = reclaimFd;
    }
}
