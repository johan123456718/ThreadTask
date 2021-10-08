
/**This class utilizes the Thread class to calculate 
 * the sum of different parts of an array using threads
 * @author John Abdulnoor (johabd@kth.se), Johan Challita (challita@kth.se)
 *
 */
public class SumTask extends Thread{
	private int[] sumArray;
	private int low, high;
	private long sum;
	
	public SumTask(int[] sumArray, int low, int high) {
		super();
		this.sumArray = sumArray;
		this.low = low;
		this.high = high;
		sum = 0;
	}
	
	/** Calculates the sum of parts of an array starting from low and ending at high - 1
	 *
	 */
	@Override
	public void run() {
		for(int i=low; i < high && high <= sumArray.length; i++) {
			sum += sumArray[i];
		}
	}
	
	public long getSum() {
		return sum;
	}
}
