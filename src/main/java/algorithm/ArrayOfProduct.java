
package algorithm;

public class ArrayOfProduct {

	public int[] getProduct(int[] inputs) {
		
		if(inputs == null || inputs.length == 0 || inputs.length == 1)
			return new int[0];
		
		int product=1, N=inputs.length;
		int[] productArray = new int[N];
		for(int i=0;i<N;i++){
			productArray[i]=product;
			product *= inputs[i];
		}
		
		product=1;
		int[] outArray = new int[N];
		for(int i=N-1; i>=0; i--){
			outArray[i]=productArray[i]*product;
			product *= inputs[i];
		}
		return outArray;
	}

}
