public class test {
    class Main {
        public static void reverse(String s) {
          if(s.length() == 0)
              return;
          else {
            reverse(s.substring(1));
            System.out.println(s.charAt(0));
          }
        }
      
        public static int sum(int n) {
          return n + sum(n-1);
        }

        public static void main(String[] args) {
          System.out.println("Hello world!");
          reverse("hello");
          int result = sum(123);
          System.out.println(result);
        }
    }
    }

