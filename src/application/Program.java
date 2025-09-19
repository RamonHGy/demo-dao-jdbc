package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: Seller findbyID =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Teste 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n ===Teste 3: Seller FindAll ===");
		list = sellerDao.findAll();
		for (Seller obj2 : list) {
			System.out.println(obj2);
		}
		
		System.out.println("\n=== Teste 4 Seller insert ==== ");
		Seller testSeller	 = new Seller(null, "Hornet silva", "hornet@gmail.com", new Date(), 1250.00, department);
		sellerDao.insert(testSeller);
		System.out.println("Inserted! new id = " + testSeller.getId());
		
		
		System.out.println("\n=== Teste 5 Seller update ==== ");
		seller = sellerDao.findById(1);
		seller.setName("Lionel messi");
		sellerDao.update(seller);
		System.out.println("Update completed = " + seller);
	}
}
