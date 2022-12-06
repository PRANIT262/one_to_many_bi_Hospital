package one_to_many_bi_Hospital;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HospitalDriver {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pranay");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setHname("apollo");
		hospital.setLoc("nerul");
		

		Branch branch = new Branch();
		branch.setBname("navi mumbai");
		branch.setHospital(hospital);

		Branch branch1 = new Branch();
		branch1.setBname("thane");
		branch.setHospital(hospital);

		Branch branch2 = new Branch();
		branch2.setBname("alibag");
		branch2.setHospital(hospital);

		List<Branch> b = new ArrayList();
		b.add(branch);
		b.add(branch1);
		b.add(branch2);

		hospital.setBranch(b);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();
		System.out.println("zala");

	}
}
