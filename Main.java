package basic;

import java.util.*;


public class Main
{
public static void main(String[] args) {
	
//Array List
List<String> Name = new ArrayList<>();

Name.add("Ashraf");
Name.add("Vishanth");
Name.add("Dinesh");
Name.add("vishnu"); 
System.out.println("List :"+Name);


//Set
Set<Integer> s = new HashSet<>();
s.add(10);
s.add(30);
s.add(40);
s.add(5);
System.out.println("Set :"+s);


//Queue
Queue<String> queue = new LinkedList<>();
queue.add("Task1");
queue.add("Task2");
queue.add("task3");
queue.add("Task4");
System.out.println("Queue :"+queue);

//Stack
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);
stack.push(40);
System.out.println("Stack :"+stack);
stack.pop();
System.out.println("Stack :"+stack);

List shop = new ArrayList<>();

shop.add("milk $10");
shop.add("masala $20");
shop.add("Dinesh $1000");
shop.add("vishnu $1/4");
shop.add(10);


System.out.println("List :"+shop);



//Bit Manipulation

int a = 6&7;
int b = 6|7;
int c = 6^7;


System.out.println(a);
System.out.println(b);
System.out.println(c);


int d = 5;
int e = 10;

System.out.println("Before Swap: d = " + d + ", e = " + e);

// Swap using XOR
d = d ^ e; 
e = d ^ e; 
d = d ^ e; 

System.out.println("After Swap: d = " + d + ", e = " + e);

//Find the Even or Odd using AND gate. 
int num = 7;

if ((num & 1) == 0) {
    System.out.println(num + " is Even");
} else {
    System.out.println(num + " is Odd");
}

//Direct Recursion
System.out.println("Direct Recursion");
fun(10);

//Indirect Recursion
System.out.println("Indirect Recursion");
funA(5);

System.out.println("TailRecursion");
funC(10);

System.out.println("HeadRecursion");
 funD(10);
 
System.out.println("TreeRecursion");
funE(10);

System.out.println("Sum of Natural Numbers :" + funF(5));
System.out.println("factorial :"+factorial(10));
System.out.println("Power Value :"+power(2,2));
System.out.println("Taylor Exp : "+taylorExp(8,15));
System.out.println();


}

//Direct Recursion
static void fun (int n) {
	if (n > 0){
			System.out.println(n);
			fun (n-1);
		}
	}
//Indirect Recursion
static void funA(int n) {
    if (n > 0) {
        System.out.println("A: " + n);
        funB(n - 1);
    }
}
static void funB(int n) {
    if (n > 0) {
        System.out.println("B: " + n);
        funA(n / 2);
    }
}

//TailRecursion
static void funC(int n) {
    if (n == 0) return;
    System.out.println(n);
    fun(n - 1); 
}

//HeadRecursion
static void funD(int n) {
    if (n == 0) return;
    fun(n - 1); // recursive call first
    System.out.println(n);
}
//TreeRecursion
static void funE(int n) {
    if (n > 0) {
        System.out.println(n);
        fun(n - 1); // first recursive call
        fun(n - 1); // second recursive call
    }
}

//Sum of Natural Numbers
static int funF(int n) {
	if(n == 0) {
		return 0;
	}
	else 
		return n + funF(n-1);
	
}

//Factorial Number
public static long factorial(int n) {
    if (n == 0 || n == 1) { 
        return 1;
    }
    return n * factorial(n - 1); 
}

// Power Value
static double power (double x, int n) {
	if (n ==0 ) return 1;
	return x*power(x, n-1);
}

//Talor Exp
static double taylorExp(double x, int n) {
	if (n == 0) return 1;
	return (power(x, n)/factorial(n))+taylorExp(x, n-1);
}

}
