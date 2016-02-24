/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman extends Thread {

	private boolean threadRunning;
	private CustomerQueue queue;
	private Gui gui;
	private Customer customer;
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
			Customer customer = new Customer();
			queue.addCustomer(customer);
			try {
				sleep((long) (Math.random() * (Globals.doormanSleep)));
			}catch(InterruptException e){
				e.printStackTrace();
			}
		}
	}
}
