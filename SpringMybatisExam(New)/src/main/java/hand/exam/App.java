package hand.exam;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

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
    	

    	
    	int id = -1;
    	int flag = 0;
    	do {
    	  if (flag>0) {
			System.out.println("输入错误，请重新输入Address_id");
		  }else {
		    System.out.println("请输入Address_id");
		  }
    	  flag++;
		  String idStr = scanner.nextLine();
		  try{
			  id = Integer.parseInt(idStr);  
		  }catch(Exception e){
			  continue;
		  }
		} while (!addressService.isAddressIdExist(id));
    	
//        int id = scanner.nextInt();
//
//    	while(!addressService.isAddressIdExist(id)){
//    		System.out.println("输入错误，请重新输入Address_id");
//        	id = scanner.nextInt();
//    	}
    	
    	customer.setAddress_id((short) id);
    	customer.setCreate_date(new Date());
    	
    	customerService.insertAndSelect(customer);
    
    	
    	
//    	System.out.println("请输入要删除的用户id");
//    	int cid = scanner.nextInt();
//    	while (!customerService.isCustomerIdExist(cid)) {
//    		System.out.println("输入id错误，请重新输入要删除的用户id");
//        	cid = scanner.nextInt();
//		}
    	int flag3 = 0;
    do{
           int cid = -1;
           int flag2 = 0;
    	   do {
    		if (flag2>0) {
    			System.out.println("输入id错误，请重新输入要删除的用户id");
			}else{
				System.out.println("请输入要删除的用户id");
			}
    		flag2++;
    		try{
    			String cidStr = scanner.nextLine();
    			cid = Integer.parseInt(cidStr);
    		}catch(Exception e){
    			continue;
    		}
		} while (!customerService.isCustomerIdExist(cid));

         try{
            flag3 = 0;
         	customerService.deleteCustomerById(cid);
         	if (flag3==0) {
            	System.out.println("此用户被成功删除");	
			    break;
            }
         }catch (DataIntegrityViolationException e) {
           System.out.println("此条数据与外表相关联，无法删除，请试着删除刚插入的数据");
           flag3=1;
		}
    }while(flag3!=0);
        

    }
}
