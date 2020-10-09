package dynamicProgramming;

public class MinimumCostPath {

	public static void main(String[] args) {
		int arr[][] = { {1,1,1},
						{4,5,2},
						{7,8,9}};
		
		System.out.println(minCostPathR(arr, 0, 0));
		
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];
		System.out.println(minCostPathM(arr, 0, 0, storage));
		System.out.println(minCostPathDP(arr, 0, 0, storage));

	}

	private static int minCostPathDP(int[][] arr, int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;
		
		storage[m-1][n-1] = arr[m-1][n-1];
		
		// fill last row;
		for(int k=n-2; k>=0; k--)
			storage[m-1][k] = arr[m-1][k] + storage[m-1][k+1];
		// fill last column;
		for(int k=m-2; k>=0; k--)
			storage[k][n-1] = arr[k][n-1] + storage[k+1][n-1];
		
		// fill elements expert from the above two ones;
		for(int k=m-2; k>=0; k--) 
			for(int l=n-2; l>=0; l--) 
				storage[k][l] = arr[k][l] + Math.min(storage[k][l+1], Math.min(storage[k+1][l+1], storage[k+1][l]));
		
		return storage[0][0];
	}

	private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;
		
		if(m-1 == i && n-1 == j) {
			storage[i][j] = arr[i][j];
			return storage[i][j];
 		}
		
		if(i >= m || j >= n)
			return Integer.MAX_VALUE;
		
		if(storage[i][j] != 0)
			return storage[i][j];
		
		int p1 = minCostPathM(arr, i, j+1, storage);
		int p2 = minCostPathM(arr, i+1, j+1, storage);
		int p3 = minCostPathM(arr, i+1, j, storage);
		
		storage[i][j] = arr[i][j] + Math.min(p1, Math.min(p2, p3));
		
		return storage[i][j];
	}

	private static int minCostPathR(int[][] arr, int i, int j) {
		int m = arr.length;
		int n = arr[0].length;
		
		if(m-1 == i && n-1 == j)
			return arr[i][j];
		
		if(i >= m || j >= n)
			return Integer.MAX_VALUE;
		
		int p1 = minCostPathR(arr, i, j+1);
		int p2 = minCostPathR(arr, i+1, j+1);
		int p3 = minCostPathR(arr, i+1, j);
		
		return arr[i][j] + Math.min(p1, Math.min(p2, p3));
	}
	
	

}
