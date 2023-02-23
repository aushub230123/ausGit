package com.dss;

import com.dss.entity.AdminEntity;
import com.dss.exception.AdminAlreadyExistException;
import com.dss.exception.InvalidInputException;
import com.dss.exception.PhoneNumberAlreadyInUseException;
import com.dss.repository.AdminRepository;
import com.dss.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class Dss3MsLoginV1ApplicationTests {

	@MockBean
	private AdminRepository adminRepository;

	@Autowired
	private AdminService adminService;

	@Test
	void registerSuccess(){

		AdminEntity adminToDb = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				, "P@ssw0rd");

		AdminEntity adminFromDb = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				, "P@ssw0rd1");
		Mockito.when(adminRepository.save(adminToDb)).thenReturn(adminFromDb);

		Assertions.assertEquals(adminFromDb, adminService.save(adminToDb));

	}

	@Test
	void registerFailedNullValues(){
		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, null
				,"09999999999"
				, "P@ssw0rd");

		Assertions.assertThrows(InvalidInputException.class, () -> adminService.save(admin));
	}
	@Test
	void registerFailedNameHasSpecialCharacters(){
		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "@developer"
				, "@ndTester"
				,"09999999999"
				, "P@ssw0rd");

		Assertions.assertThrows(InvalidInputException.class, () -> adminService.save(admin));

	}
	@Test
	void registerFailedPasswordFormat(){

		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				//does not contain special character
				, "Passw0rd");

		Assertions.assertThrows(InvalidInputException.class, () -> adminService.save(admin));
	}

	@Test
	void registerFailedAdminAlreadyExist(){

		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09123456789"
				, "P@ssw0rd");

		Mockito.when(adminService.findByEmailId(admin.getEmailId())).thenReturn(admin);

		AdminEntity adminForm = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				, "P@ssw0rd");

		Assertions.assertThrows(AdminAlreadyExistException.class, () -> adminService.save(adminForm));

	}

	@Test
	void registerFailedPhoneAlreadyExist(){

		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09123456789"
				, "P@ssw0rd");

		Mockito.when(adminRepository.findByPhoneNumber(admin.getPhoneNumber())).thenReturn(admin);

		AdminEntity adminForm = new AdminEntity("adeveloper2@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09123456789"
				, "P@ssw0rd");

		Assertions.assertThrows(PhoneNumberAlreadyInUseException.class, () -> adminService.save(adminForm));

	}

	@Test
	void loginSuccessful(){
		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				, "161ebd7d45089b3446ee4e0d86dbcf92");

		Mockito.when(adminService.findByEmailIdAndPassword(admin.getEmailId(),admin.getPassword())).thenReturn(admin);
		Assertions.assertEquals("Successfully logged in", adminService.login("adeveloper@gmail.com","P@ssw0rd"));

	}
	@Test
	void loginFailedWrongCredentials(){
		AdminEntity admin = new AdminEntity("adeveloper@gmail.com"
				, "Adeveloper"
				, "AndTester"
				,"09999999999"
				, "161ebd7d45089b3446ee4e0d86dbcf92");

		Mockito.when(adminService.findByEmailIdAndPassword(admin.getEmailId(),admin.getPassword())).thenReturn(admin);
		Assertions.assertEquals("Wrong Username / Password", adminService.login("wrong@gmail.com","wrongP@ssw0rd"));

	}
	@Test
	void loginFailedNullPointer(){
		Assertions.assertThrows(InvalidInputException.class, () -> adminService.login(null,null));
	}

}
