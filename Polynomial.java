import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Polynomial {
	
	// Array for non-zero coefficients
	double[] coefficients;
	
	// Array for exponents
	int[] exponents;
	
	// Constructor that sets to 0
	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		exponents = new int[1];
		exponents[0] = 0;
	}
	
	// Constructor that sets coefficients & exponents accordingly
	public Polynomial(double coefficients[], int exponents[]) {
		this.coefficients = coefficients;
		this.exponents = exponents;
	}
	
	// Constructor that sets polynomial based on contents of file
	public Polynomial(File file) throws FileNotFoundException {
		
		Scanner input = new Scanner(file);
		
		// Read file contents and store 
		String polynomial = input.nextLine();
		
		 // SPLIT
		 String[] array = polynomial.split("[+-]");
		 
		 int size = array.length;
		 
		 int[] exponents = new int[size];
		 double[] coef = new double[size];
		 
		 String[] temp;
		 
		 
		 for(int i = 0; i < array.length; i++)
		 {
			if(!array[i].contains("x")) {
				exponents[0] = 0;
				coef[0] = Double.parseDouble(array[i]);
			}
			else {
				
				temp = array[i].split("x");
				
				if(temp.length == 1) {
					exponents[i] = 1;
					coef[i] = Double.parseDouble(temp[0]);
					
				}
				else if((temp.length == 2 && temp[0] == "")) {
					exponents[i] = Integer.parseInt(temp[1]);
					coef[i] = 1;
				}
				
				else if(temp.length == 0) {
					exponents[i] = 1;
					coef[i] = 1;
				}
				else {
					exponents[i] = Integer.parseInt(temp[1]);
					coef[i] = Double.parseDouble(temp[0]);
				}
				
			}
			
		 }
		 
		
		input.close();
	}
	
	// Add 2 polynomials together
	public Polynomial add(Polynomial poly) {
	    int max_degree = Math.max(exponents[exponents.length - 1] + 1, poly.exponents[poly.exponents.length - 1] + 1);
	    double[] resultCoefficients = new double[max_degree];
	    int[] resultExponents = new int[max_degree];

	    for (int i = 0; i < coefficients.length; i++) {
	        resultCoefficients[exponents[i]] += coefficients[i];
	        resultExponents[exponents[i]] = exponents[i];
	    }

	    for (int i = 0; i < poly.coefficients.length; i++) {
	        resultCoefficients[poly.exponents[i]] += poly.coefficients[i];
	        resultExponents[poly.exponents[i]] = poly.exponents[i];
	    }

	    return new Polynomial(resultCoefficients, resultExponents);
    }
	
	
	// Evaluate method 
	public double evaluate(double x) {
		
		double sum = 0;
		
		for(int i = 0; i < coefficients.length; i++) {
			sum += coefficients[i]*Math.pow(x, exponents[i]);
		}
		
		return sum;
	}
	
	// Has root method
	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
	
	// Multiply method
	public Polynomial multiply(Polynomial poly) {
	    int max_degree = exponents[exponents.length - 1] + poly.exponents[poly.exponents.length - 1] + 1;
	    double[] resultCoefficients = new double[max_degree];
	    int[] resultExponents = new int[max_degree];

	    for (int i = 0; i < coefficients.length; i++) {
	        for (int j = 0; j < poly.coefficients.length; j++) {
	            int exponent = exponents[i] + poly.exponents[j];
	            double coefficient = coefficients[i] * poly.coefficients[j];
	            resultCoefficients[exponent] += coefficient;
	            resultExponents[exponent] = exponent;
	        }
	    }

	    return new Polynomial(resultCoefficients, resultExponents);
	}
	
	// Save polynomial in textual format
    public void saveToFile(String fileName) throws IOException{
        FileWriter writer = new FileWriter(fileName);

        writer.close();
    }
}