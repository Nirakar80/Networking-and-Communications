
public class Problem {

	public static void main(String[] args) {

		float[] SampleRTT = {106, 120, 140, 90, 115};
		double alpha = 0.125;
		double beta = 0.25;
		
		float EstimatedRTT_old = 100;
		float DevRTT_old = 5;
		float EstimatedRTT;
		float DevRTT;
		float timeout;
		
		for (int i = 0; i < 5; i++)
		{
			EstimatedRTT = (float) (((1-alpha)*EstimatedRTT_old) + alpha*SampleRTT[i]);
			DevRTT = (float) ((1-beta)*DevRTT_old + beta*(SampleRTT[i]-EstimatedRTT_old));
			timeout = EstimatedRTT + 4*DevRTT;
			
			System.out.println("For SampleRTT: " + SampleRTT[i] +"[ms]");
			System.out.println("EstimatedRTT = " + EstimatedRTT + "[ms]");
			System.out.println("DevRTT = " + DevRTT + "[ms]");
			System.out.println("Timeout = " + timeout + "[ms]");
			System.out.println();
			
			EstimatedRTT_old = EstimatedRTT;
			DevRTT_old = DevRTT;
		}
		
	}

}
