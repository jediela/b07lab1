public class Polynomial {
	
	double[] coefficients;
	
	// Constructor that sets to 0
	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	
	// Constructor that sets coefficients accordingly
	public Polynomial(double s[]) {
		this.coefficients = s;
	}
	
	// Add 2 polynomials together
	public Polynomial add(Polynomial p) {
		
		// Get biggest degree polynomial
		int max_degree = Math.max(this.coefficients.length, p.coefficients.length);
		
		// New array for sum of coefficients 
		double[] result = new double[max_degree];
		
		// Get value of first polynomial (Current)
		for(int i = 0; i < coefficients.length; i++) {
			
			result[i] = coefficients[i];
		}
		
		// Add second polynomial (Argument)
		for(int i = 0; i < p.coefficients.length; i++) {
			
			result[i] += p.coefficients[i];
		}
		
	
		return new Polynomial(result);
	}
	
	// Evaluate method 
	public double evaluate(double x) {
		
		double sum = 0;
		
		for(int i = 0; i < coefficients.length; i++) {
			sum += coefficients[i]*Math.pow(x, i);
		}
		
		return sum;
	}
	
	// Has root method
	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
}