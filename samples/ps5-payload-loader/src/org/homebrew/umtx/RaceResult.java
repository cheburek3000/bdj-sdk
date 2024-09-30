package org.homebrew.umtx;

public class RaceResult {
    public int returnCode;
    public int numTries;
    public int lookupFd;
    public int winnerFd;

    public RaceResult(int returnCode) {
        this.returnCode = returnCode;
    }

    public RaceResult(int numTries, int lookupFd, int winnerFd) {
        this.returnCode = 0;
        this.numTries = numTries;
        this.lookupFd = lookupFd;
        this.winnerFd = winnerFd;
    }
}
