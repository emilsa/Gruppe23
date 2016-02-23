/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	public Customer[] customerList;
	private int maxLength;
	/*customer = new Customer;
	List<customer> queue = new ArrayList<customer>();*/

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
		//customerQueue.length = 0;

		maxLength = queueLength;
		//gui.fillLoungeChair( int pos, customer);
	}

	public boolean checkEmpty(customerList customerList)

	{
		if (customerList.size = 0) {
			return true;
		}
		return false;
	}

	public boolean checkFull(customerList customerList){
		if (customerList.size = queueLength) {
			return true;
		}
		return false;
	}

	public synchronized void addCustomer (customerList customerList, customer customer){
		if(!queue.checkFull){
			Customer customer = new customer();
			customerList.add(customer);
			gui.println("La til en kunde lol");

		}
		else{
			gui.println("Det er fullt");
		}

	}





		/*for(i=0,i<queue.length, i++){
			if(q[i]!=null)
				return false;
		}
		return true;
	}*/

	// Add more methods as needed
}

