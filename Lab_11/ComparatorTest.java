import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Customer {
	String Name;
	int Age;

	public Customer(String Name, Integer Age){
		this.Name = Name;
		this.Age = Age;
	}

	public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public Integer getAge() { return Age; }
    public void setAge(Integer Age) { this.Age = Age; }

	public String toString(){
		return "Customer{"+ "Name=" + Name + ", Age=" + Age + '}';
	}
}

class CustomerSortingComparator
	implements Comparator<Customer> {

	public int compare(Customer customer1, Customer customer2)
	{
		int NameCompare = customer1.getName().compareTo(
			customer2.getName());
		int AgeCompare = customer1.getAge().compareTo(
			customer2.getAge());
		return (NameCompare == 0) ? AgeCompare
								: NameCompare;
	}
}

class ComparatorTest {
	public static void main(String[] args)
	{
		List<Customer> al = new ArrayList<>();

		Customer obj1 = new Customer("Ajay", 27);
		Customer obj2 = new Customer("Sneha", 23);
		Customer obj3 = new Customer("Simran", 37);
		Customer obj4 = new Customer("Ajay", 22);
		Customer obj5 = new Customer("Ajay", 29);
		Customer obj6 = new Customer("Sneha", 22);

		al.add(obj1);
		al.add(obj2);
		al.add(obj3);
		al.add(obj4);
		al.add(obj5);
		al.add(obj6);

		Iterator<Customer> custIterator = al.iterator();
        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
			System.out.println(custIterator.next());
		}
        Collections.sort(al,
						new CustomerSortingComparator());

		System.out.println("\n\nAfter Sorting:\n");
        for (Customer customer : al) {
			System.out.println(customer);
		}
	}
}

