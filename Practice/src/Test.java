import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public void prime(int num) {
		int temp;
		boolean isPrime = true;
		for (int i = 2; i <=num/2; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime) {
			System.out.println(num + "number is prime");
		}

		else {
			System.out.println(num + "number is not a prime");
		}

	}
	
	public void reverseString(String test)
	{
		String reverse="";
		for(int i=test.length()-1;i>=0;i--)
		{
			System.out.println(reverse+test.charAt(i));
		}
		
	}
	
	public void reverseNumber(int no)
	{
		//1234
		int rem=0,reverse=0;
		while(no!=0)
		{
		rem=no%10;
		reverse=reverse*10+rem;
		no=no/10;
		
	}
		System.out.println(reverse);
	}
	public void fibonacci(int limit)
	{
		int a=0; 
		int b=0;
		int c=1;
		//System.out.println(a +" "+b);
		for(int i =2;i<=limit;i++)
		{
			a=b;
			b=c;
			c=a+b;
			System.out.println(a );
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		//t.prime(5);
		//t.reverseString("aishu");
		t.reverseNumber(1234);
		t.fibonacci(9);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "Saket");
		map.put(25, "Saurav");
		map.put(12, "HashMap");
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry me = (Entry) itr.next();
			// System.out.println(me.getKey()+" "+me.getValue());
		}
		String test = "aishwarya";
		char[] arr = test.toCharArray();
		Map<Character, Integer> testMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (testMap.containsKey(arr[i])) {
				int count = testMap.get(arr[i]);

				testMap.put(arr[i], count + 1);
			} else {
				testMap.put(arr[i], 1);
			}
		}
		// System.out.println(testMap);
	}
}
