package Labs;

import java.util.EmptyStackException;
import java.util.Scanner;

public class MyStack<T> implements Stack <T>{

	public int top;
	protected T[] stack;
	protected T[] clonestack;

	@SuppressWarnings("unchecked")
	public MyStack(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");
		stack = (T[]) new Object[initialCapacity];
		top = -1;
	}

	public MyStack() { 
		this(10);
	}

	public boolean empty() {
		return top == -1;
	}

	public int size() {
		MyStack s = new MyStack();
		
		int t = 0;
		while(!this.empty()) {
			s.push(this.pop());
			t++;
		}
		while(!s.empty()) {
			this.push(s.pop());
			
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if (empty())
			throw new EmptyStackException();
		return stack[top];
	}

	@SuppressWarnings("unchecked")
	public void push(Object theElement) {
		if (top == stack.length - 1)
			System.out.println("Stack is Full You can't add more data");

		stack[++top] = (T) theElement;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (empty())
			throw new EmptyStackException();
		T topElement = stack[top];
		stack[top--] = null;
		return topElement;
	}

	public static void menu() {
		System.out.println("Цэс: \t1. isEmpty " + "\n\t2. Push" + "\n\t3. Peek" + "\n\t4. Pop" + "\n\t5. Size "
				+ "\n\t6. Menu " + "\n\t0. Exit");
	}

	public static void main(String[] args) {
		MyStack <String> stack2 = new MyStack<String>(10);
		MyStack<Integer> stack = new MyStack<Integer>(10);

		Scanner sc = new Scanner(System.in);
		MyStack.menu();

		while (true) {

			System.out.println("\nЦЭСНИЙ ДУГААР ОРУУЛАХ: ");
			try {
				int songolt = sc.nextInt();

				switch (songolt) {
				case 1: {
					if (stack.empty())
						System.out.println("\t Энэ лист хоосон байна");
					else
						System.out.println("\t Энэ лист хоосон биш байна" + stack.toString());
				}
					break;
				case 2: {
					try {
						System.out.print("Нэмэх утгыг оруулана уу: ");
						int elements = sc.nextInt();
						stack.push(elements);
						System.out.println("\t Оройд элемент нэмэв: " + elements);
					} catch (Exception e) {
						System.out.println("Stack зөвхөн int утга авна!!!");
					}
				}
					break;
				case 3: {
					if (stack.empty()) {
						System.out.println("\t Stack одоогоор хоосон байна");

					} else {
						System.out.println("\t Оройн элемент: " + stack.peek());

					}
				}
					break;
				case 4: {
					if (stack.empty()) {
						System.out.println("\t Stack одоогоор хоосон байна");

					} else {
						System.out.println("\t " + stack.pop() + " гэсэн утгыг устгалаа");

					}

				}
					break;
				case 5: {
					System.out.println("\t Size of Stack:" + stack.size());
				}
					break;
				case 6: {
					MyStack.menu();
					break;
				}
				case 0: {
					System.out.print("Системээс гарав");
					sc.close();
					System.exit(1);
				}
					break;
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Бүхэл тоон утга оруулна уу! " + e);
			}
		}

	}

}
