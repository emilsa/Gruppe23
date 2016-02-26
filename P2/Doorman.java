//import com.sun.javaws.Globals;

/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman extends Thread {

	boolean threadRunning;
	CustomerQueue queue;
	Gui gui;
	Customer customer;
	//private CustomerList customerList;

	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.

	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) {
		this.queue = queue;
		this.gui = gui;

	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		threadRunning = true;
		start();
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		threadRunning = false;
	}

	public void run(){
		while(threadRunning){
			try {
				sleep((long) (Math.random() * (Globals.doormanSleep)));
			}catch(InterruptedException b){
				b.printStackTrace();
			}
			queue.addCustomer(new Customer());
		}
	}
}
