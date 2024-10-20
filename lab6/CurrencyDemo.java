// Java program explaining Currency class methods 
// getInstance(), getCurrencyCode(),getDefaultFractionDigits() 
// getDisplayName(), getSymbol() 
import java.util.*; 
public class CurrencyDemo 
{ 
	public static void main(String[] args) 
	{ 
		Currency c1 = Currency.getInstance("INR"); //Indian Rupee 
		Currency c2 = Currency.getInstance("JPY"); //Japan Yen 
		Currency c3 = Currency.getInstance("USD"); //US Dollar

        System.out.println("***** Indian Rupee *****");
		System.out.println("code : " + c1.getCurrencyCode()); 
		System.out.println("fraction : " + c1.getDefaultFractionDigits()); 
		System.out.println("display name: " + c1.getDisplayName()); 
        System.out.println("symbol: "+ c1.getSymbol());

        System.out.println("***** Japanese Yen *****");
		System.out.println("code : " + c2.getCurrencyCode()); 
		System.out.println("fraction : " + c2.getDefaultFractionDigits()); 
		System.out.println("display name: " + c2.getDisplayName()); 
        System.out.println("symbol: "+ c2.getSymbol());

        System.out.println("***** US Dollar *****");
		System.out.println("code : " + c3.getCurrencyCode()); 
		System.out.println("fraction : " + c3.getDefaultFractionDigits()); 
		System.out.println("display name: " + c3.getDisplayName()); 
        System.out.println("symbol: "+ c3.getSymbol());

	} 
} 

