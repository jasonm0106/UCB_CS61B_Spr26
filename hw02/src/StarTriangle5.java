public class StarTriangle5 {
   /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle5() {
       StringBuilder sb = new StringBuilder(5);
       for (int i = 1; i <= 5; i++) {
           for (int j = 1; j <= 5 - i; j++) {
               sb.append(" ");
           }
           for (int j = 1; j <= i; j++) {
               sb.append("*");
           }
           System.out.println(sb.toString());
           sb.setLength(0);
       }
   }
   
   public static void main(String[] args) {
      starTriangle5();
   }
}