import java.util.Calendar; 
public class CalenderDemo { 
    public static void main(String[] args) 
    { 
        // creating Calendar object 
        Calendar calendar = Calendar.getInstance(); 
        System.out.println("The Current Date is:" + calendar.getTime()); 
          
        // Demonstrate Calendar's get()method 
        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR)); 
        System.out.println("Current Calendar's Day: " + calendar.get(Calendar.DATE));
        System.out.println("Current Calendar's Month: " + calendar.get(Calendar.MONTH)); 
        System.out.println("Current Calendar's Hour: " + calendar.get(Calendar.HOUR_OF_DAY)); 
        System.out.println("Current MINUTE: " + calendar.get(Calendar.MINUTE)); 
        System.out.println("Current SECOND: " + calendar.get(Calendar.SECOND)); 
    } 
} 