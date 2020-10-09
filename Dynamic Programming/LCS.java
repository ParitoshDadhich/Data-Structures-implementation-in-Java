package dynamicProgramming;

public class LCS {

	public static void main(String[] args) {
		String str1 = "ei";
		String str2 = "egi";
		
		int m = str1.length();
		int n = str2.length();
		int storage[][] = new int[m+1][n+1];
		
		// initially fill all the positions to -1 because;
		// if string are not common then lcs would be 0; 
		// to note a difference initialize with -1 first;
		
		for(int i=0; i<=m; i++)
			for(int j=0; j<=n; j++)
				storage[i][j] = -1;
		
		System.out.println(lcsM(str1, str2, storage)); // time o(mn);
		System.out.println(lcsR(str1, str2)); // time o(2^n);
		System.out.println(lcsDP(str1, str2));

	}

	private static int lcsDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int storage[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++)
			for(int j=0; j<=n; j++)
				storage[i][j] = -1;
		
		for(int j=0; j<=n; j++)
			storage[0][j] = 0;
		
		for(int i=0; i<=m; i++)
			storage[i][0] = 0;
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
// Here in the below line of code instead of simply i and j, I did n-i and m-i. The reason is when the value of i and j increases then
// the length of string str1 and str2 decreases.
// Basically my aim is to compare the first character of strings, it means I have to compare from last
// suppose the value of i is 4 and str1 is ab so it's impossible to compare now but I can compare by writing (m-i);
				
				if(str1.charAt(m - i) == str2.charAt(n - j))
					storage[i][j] = 1 + storage[i-1][j-1];
				else
					storage[i][j] = Math.max(storage[i][j-1], storage[i-1][j]);
					
			}
		}
		
		return storage[m][n];
	}

	private static int lcsM(String str1, String str2, int storage[][]) {
		int m = str1.length();
		int n = str2.length();
		
		if(storage[m][n] != -1)
			return storage[m][n];
		
		if(m==0 || n==0) {
			storage[m][n]  = 0;
			return storage[m][n];
		}
		
		if(str1.charAt(0) == str2.charAt(0))
			storage[m][n] = 1 + lcsM(str1.substring(1), str2.substring(1), storage);
		else {
			int op1 = lcsM(str1, str2.substring(1), storage);
			int op2 = lcsM(str1.substring(1), str2, storage);
			storage[m][n] = Math.max(op1, op2);
		}
		
		return storage[m][n];
	}

	private static int lcsR(String str1, String str2) {
		
		if(str1.length() == 0 || str2.length() == 0)
			return 0;
		
		if(str1.charAt(0) == str2.charAt(0))
			return 1 + lcsR(str1.substring(1), str2.substring(1));
		else {
			int op1 = lcsR(str1, str2.substring(1));
			int op2 = lcsR(str1.substring(1), str2);
			//int op3 = lcsR(str1.substring(1), str2.substring(1));
			
			// if you dry run this problem then you will find if you don't write op3 still you will get the correct answer
			// because implicitly during the recursively call in op1 and op3 you get the calls of op3 
			// you simply repeats the same call if you do recursively call through op3 and in doing calls in op3 we simply gets a bad 
			// solution which is not good in terms of time complexity and internal use of stack in recursive calls;
			
			//so should simply comment the op3 and we again gets the same answer;
			
			return Math.max(op1, op2);
		}
		
	}

}
