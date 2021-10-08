import java.util.Random;

public class Sum{	
	public static int[] intArray;
	public static long normalCalcTime, threadCalcTime;
	
	public static void main(String[] args) throws Exception {
		
		Random rand = new Random();
		intArray = new int[100000000];
		for(int i=0; i < intArray.length; i++) {
			intArray[i] = rand.nextInt((99) + 1);
		}
		
		long threadSum = SumWithThreads();
		long normalSum = SumWithoutThreads();
		
		System.out.println("Result is the same for both calculations? " + (normalSum == threadSum));
		
		System.out.println("Thread calculation time: " + threadCalcTime + "ms");
		System.out.println("Normal calculation time: " + normalCalcTime + "ms");
		
	}
	
	/** Initiates 4 threads to calculate the sum of the pre-defined array integer elements
	 *  by dividing the array into 4 parts and assigning each part to a SumTask
	 * @return the sum of all the elements in the array
	 * @throws InterruptedException
	 */
	private static long SumWithThreads() throws InterruptedException{
		SumTask[] sum = new SumTask[4];
		sum[0] = new SumTask(intArray, 0, intArray.length/4);
		sum[1] = new SumTask(intArray, intArray.length/4, intArray.length/2);
		sum[2] = new SumTask(intArray, intArray.length/2, 75000000);
		sum[3] = new SumTask(intArray, 75000000, intArray.length);
		
		long timeBeforeThreadSum = System.currentTimeMillis();
		
		sum[0].start();
		sum[1].start();
		sum[2].start();
		sum[3].start();
		sum[0].join();
		sum[1].join();
		sum[2].join();
		sum[3].join();
		
		long threadSum = sum[0].getSum() + sum[1].getSum() + sum[2].getSum() + sum[3].getSum();;
		
		long timeAfterThreadSum = System.currentTimeMillis();
		
		threadCalcTime = timeAfterThreadSum - timeBeforeThreadSum;
		return threadSum;
	}
	
	/** Calculates the sum the pre-defined array of integer elements
	 *  using a for-loop without threads 
	 * @return the sum of all the elements in the array
	 */
	private static long SumWithoutThreads() {
		long normalSum = 0;
		long timeBeforeNormSum = System.currentTimeMillis();
		for(long i=0; i < intArray.length; i++) {
			normalSum += intArray[(int)i];
		}
		
		long timeAfterNormSum = System.currentTimeMillis();
		
		normalCalcTime = timeAfterNormSum - timeBeforeNormSum;
		return normalSum;
	}
}
