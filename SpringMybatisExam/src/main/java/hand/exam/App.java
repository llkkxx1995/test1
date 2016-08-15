package hand.exam;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hand.exam.mapper.AddressMapper;
import hand.exam.pojo.Customer;
import hand.exam.service.AddressService;
import hand.exam.service.CustomerService;
import hand.exam.service.StoreService;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	ApplicationContext ac = new FileSystemXmlApplicationContext("src\\main\\java\\applicationContext.xml");
    	
    	AddressService addressService = ac.getBean(AddressService.class);
    	CustomerService customerService = ac.getBean(CustomerService.class);
    	StoreService storeService = ac.getBean(StoreService.class);
   
    
    	Customer customer = new Customer();
    	customer.setStore_id((short) 1);
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("请输入First_Name");
    	String first_name = scanner.nextLine();
    	customer.setFirst_name(first_name);
    	
    	System.out.println("请输入Last_Name");
    	String last_name = scanner.nextLine();
    	customer.setLast_name(last_name);
    	
    	System.out.println("请输入Email");
    	String email = scanner.nextLine();
    	customer.setEmail(email);
    	
    	System.out.println("请输入Address_id");
    	int id = scanner.nextInt();
    	while(!addressService.isAddressIdExist(id)){
    		System.out.println("输入错误，请重新输入Address_id");
        	id = scanner.nextInt();
    	}
    	customer.setAddress_id((short) id);
    	customer.setCreate_date(new Date());
    	
    	customerService.insertAndSelect(customer);
    
    	System.out.println("请输入要删除的用户id");
    	int cid = scanner.nextInt();
    	while (!customerService.isCustomerIdExist(cid)) {
    		System.out.println("输入id错误，请重新输入要删除的用户id");
        	cid = scanner.nextInt();
		}
    	customerService.deleteCustomerById(cid);
    	System.out.println("此用户被成功删除");
    }
}
