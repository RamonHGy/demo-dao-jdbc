package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
//		System.out.println(" ==== Test 1 Department insert ====");
//		Department dep = new Department(null, "Music");
//		depDao.insert(dep);
//		System.out.println("Inserted! new Id = " + dep.getId());
		
		System.out.println("\n ===Teste 2: Seller FindById ===");
		Department depFindByID = depDao.findById(3);
		System.out.println(depFindByID);
		
		System.out.println("\n=== Teste 3 Seller update ==== ");
		Department dep = depDao.findById(3);
		dep.setName("Agriculture");
		depDao.update(dep);
		System.out.println("Update completed = " + dep);
		
		System.out.println("\n=== TEST 4: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n ===Teste 3: Seller FindAll ===");
		list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

	}

}
