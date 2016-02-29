/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber extends Thread
{
	CustomerQueue queue;
	Gui gui;
	int pos;
	boolean threadRunning;





	/**
	 * Creates a new barber.
	 *
	 * @param queue The customer queue.
	 * @param gui   The GUI.
	 * @param pos   The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) {
		this.queue = queue;
		this.gui = gui;
		this.pos = pos;
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		threadRunning = true;
		start();
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		threadRunning = false;
	}

	public void run() {
		while (threadRunning) {
			try {
				gui.barberIsSleeping(pos);
				sleep((long) (Math.random() * 2 * (Globals.barberSleep)));
				gui.barberIsAwake(pos);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
			queue.removeCustomer();
			try {
				gui.fillBarberChair(pos,new  Customer());
				sleep((long) (Math.random()* 2 * (Globals.barberWork)));
			} catch (InterruptedException a) {
				a.printStackTrace();
			}
			gui.emptyBarberChair(pos);

		}
	}
}
