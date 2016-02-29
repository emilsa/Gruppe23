/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	Customer[] customerList;
	int waitingQueue;
	int maxLength;
	int queueLength;
	Gui gui;
	Customer customer;
	//List<customer> queue = new ArrayList<customer>();

	/*GUI ref*/

	/**
	 * Creates a new customer queue.
	 *
	 * @param queueLength The maximum length of the queue.
	 * @param gui         A reference to the GUI interface.
	 */
	public CustomerQueue(int queueLength, Gui gui) {
		//costumer = new Customer[queueLength];
		this.queueLength = queueLength;
		this.gui = gui;
		maxLength = queueLength;
		customerList = new Customer[maxLength];


		//gui.fillLoungeChair( int pos, customer);
	}

	public boolean checkEmpty() {
		for (int i = 0; i < customerList.length; i++) {
			if (customerList[i] != null) {
				return false;
			}


		}
		return true;
	}

	public boolean checkFull() {
		for (int i = 0; i < customerList.length; i++) {
			if (customerList[i] == null) {
				return false;
			}



		}
		return true;
	}

	public synchronized void addCustomer(Customer customer) {
		while (checkFull()) {
			//Sjekker om venterommet er fullt
			gui.println("Det er fullt");
			try {
				//Venter på ledig plass
				wait();
			} catch (InterruptedException e) {
				gui.println("Ledig plass!");
			}
		}
		for (int i = 0; i < customerList.length; i++) {
			if (customerList[i] == null) {
				customerList[i] = customer;
				gui.fillLoungeChair(i, customer);

				break;
			}
		}
		//Inkrementerer ventekøen
		waitingQueue++;
		if (waitingQueue == 1) {
			notifyAll();
		}
		gui.println("La til en kunde lol");
	}

	public synchronized Customer removeCustomer() {
		while (checkEmpty()) {
			gui.println("frisør venter på nye gjester");
			try {
				wait();
			} catch (InterruptedException e) {
				gui.println("Frisør har fått gjest #blabla");
			}
		}
		int seatNr = 0;
		int waitedLongest = 0;
		for (int i = 0; i < customerList.length; i++) {
			if (customerList[i] != null) {
				if (waitedLongest == 0) {
					waitedLongest = customerList[i].getCustomerID();
					seatNr = i;
				}
				if (customerList[i].getCustomerID() < waitedLongest) {
					waitedLongest = customerList[i].getCustomerID();
					seatNr = i;
				}
			}
		}
		gui.println("Kunde hentet fra lounge");
		gui.emptyLoungeChair(seatNr);

		waitingQueue--;

		if (waitingQueue == customerList.length - 1) {
			notifyAll();


		}


		Customer customer = customerList[seatNr];
		customerList[seatNr] = null;
		return customer;
	}

}

