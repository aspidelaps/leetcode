class H2O {
    

    public Semaphore semH = new Semaphore(2);
    public Semaphore semO = new Semaphore(0);
    
    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire();
        releaseHydrogen.run();
        semO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire(2);
        releaseOxygen.run();
        semH.release(2);
    }
}