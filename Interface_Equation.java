interface Equation {

  Solution CalcEquation(double a, double b, double c);
}


class Solution {
  double x1;
  double x2;
}

public class TrainLambda02 {

  public static void main(String[] args) {

    Equation eq;

    eq = (double a, double b, double c) -> {
      double d = b*b - 4*a*c; 
      if (d>=0) {
        
        Solution roots = new Solution();
        roots.x1 = (-b-Math.sqrt(d))/(2*a);
        roots.x2 = (-b+Math.sqrt(d))/(2*a);
        return roots;
      }
      else
        return null;
    };

    // 3. Solve the quadratic equation 2*x^2 - 8*x + 4 = 0
    Solution roots = eq.CalcEquation(2, -8, 4);
    if (roots==null)
      System.out.println("The solution has no roots.");
    else
    {
      System.out.println("x1 = " + roots.x1); 
	  System.out.println("x2 = " + roots.x2);
	}
  }
}
