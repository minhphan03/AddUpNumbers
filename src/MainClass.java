import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		//Given N, count the number of ways to express N as sum of 1, 3 and 4
			int n = 20;
			
			int[] arr = new int[] {1,3,4};
			
			MainClass main = new MainClass();
			List<List<Integer>> sol = main.countWays(arr, n);
			System.out.print(sol);
	}
	
	public List<List<Integer>> countWays(int[] candidates, int n) {
		
		List<List<Integer>> sol = new ArrayList<>();
		
		Arrays.sort(candidates);
		
		List<Integer> comb = new ArrayList<>(); 
		//declare comb outside findComb because comb will recur, hence if declare comb outside
		//it will clear the combination every time we recur
		findComb(sol, comb, n, candidates, 0);
		return sol;
	}
	
	private void findComb(List<List<Integer>> sol, List<Integer> comb,
			int n, int[] candidates, int pos) {
		
		if (n == 0)
		{
			sol.add(new ArrayList<>(comb));
			return;
		}
		

		for (int i = pos; i < candidates.length; i++)
		{
			//if n after subtraction is smaller than the candidate at i
			//break out of the loop because the next candidate is not smaller than this candidate
			//which will proceed to also remove this candidate and try the next candidate for the parent loop 
			if (n < candidates[i])
			{
				break;
			}
			comb.add(candidates[i]);
			findComb(sol, comb, n-candidates[i], candidates, i);
			comb.remove(comb.size()-1); 
			//only remove if it breaks the findComb (exceed the n number) loop (doesn't matter to the solution array)
			//so it can try adding the next number in the loop instead
		}
		
	}
}

