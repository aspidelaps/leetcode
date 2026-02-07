class FooBar {
    private int n;
    private boolean shouldPrintFoo = true;
    private boolean shouldPrintBar = false;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (!shouldPrintFoo) {
                wait();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            shouldPrintFoo = false;
            shouldPrintBar = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (!shouldPrintBar) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            shouldPrintFoo = true;
            shouldPrintBar = false;
            notifyAll();
        }
    }
}