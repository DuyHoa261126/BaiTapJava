package ex8;
public class MyIntStack {
   private int[] contents;
   private int tos;  // Top of the stack

   // Constructor
   public MyIntStack(int capacity) {
      contents = new int[capacity];
      tos = -1;
   }

   public void push(int element) {
      if (isFull()) {
         throw new RuntimeException("Stack is full. Cannot push " + element);
      }
      contents[++tos] = element;
   }

   public int pop() {
      if (isEmpty()) {
         throw new RuntimeException("Stack is empty. Cannot pop.");
      }
      return contents[tos--];
   }

   public int peek() {
      if (isEmpty()) {
         throw new RuntimeException("Stack is empty. Cannot peek.");
      }
      return contents[tos];
   }

   public boolean isEmpty() {
      return tos < 0;
   }

   public boolean isFull() {
      return tos == contents.length - 1;
   }

   public static void main(String[] args) {
      MyIntStack stack = new MyIntStack(3);
      
      // Kiểm tra stack rỗng
      System.out.println("Is empty: " + stack.isEmpty()); // true

      // Thêm phần tử vào stack
      stack.push(10);
      stack.push(20);
      stack.push(30);
      
      // In phần tử trên đỉnh
      System.out.println("Peek: " + stack.peek()); // 30
      
      // Lấy phần tử ra
      System.out.println("Pop: " + stack.pop()); // 30
      System.out.println("Pop: " + stack.pop()); // 20
      
      // Kiểm tra stack còn rỗng không
      System.out.println("Is empty: " + stack.isEmpty()); // false

      // Kiểm tra lỗi pop khi stack rỗng
      stack.pop(); // Lấy 10 ra
      // stack.pop(); // Gây lỗi vì stack rỗng
   }
}
