package com.adv.arithms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.stereotype.Service;

import com.adv.arithms.dto.AddressDto;
import com.adv.arithms.dto.StudentDto;
import com.adv.arithms.service.StudentService;
import org.springframework.web.bind.annotation.RequestBody;

@Service(value = "studentsServiceImpl")
public class StudentServiceImpl implements StudentService {

	private Logger log = LogManager.getLogger(StudentServiceImpl.class);

//Get All
	public StudentDto[] getStudents() {
		StudentDto[] studentDtos = new StudentDto[10];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
						.executeQuery("SELECT st.id as student_id, st.name, st.section, st.standard, st.mobile, ad.id as address_id, ad.district, ad.pincode FROM students02 st inner join address02 ad on st.address_id=ad.id");
			int i = 0;
			// Iterate Resultset
			while (rs.next()) {
				int studentId = rs.getInt("student_id");
				String name = rs.getString("name");
				String section = rs.getString("section");
				String standard = rs.getString("standard");
				String mobile = rs.getString("mobile");

				int addressId = rs.getInt("address_id");
				String district = rs.getString("district");
				int pincode = rs.getInt("pincode");

				AddressDto addressDto = new AddressDto();
				addressDto.setDistrict(district);
				addressDto.setPincode(pincode);
				addressDto.setId(addressId);
				log.info(addressDto);

				StudentDto studentDto = createStudentsDto(studentId, name, section, standard, mobile, addressDto);
				studentDtos[i++] = studentDto;

			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		log.info(studentDtos);
		return studentDtos;
	}

	private StudentDto createStudentsDto(int id, String name, String section, String standard,
				String mobile, AddressDto addressDto) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(id);
		studentDto.setName(name);
		studentDto.setMobile(mobile);
		studentDto.setStandard(standard);
		studentDto.setSection(section);
		studentDto.setAddress(addressDto);
		return studentDto;
	}

//Get Particular data 
	@Override
	public StudentDto getParticularStudent(int studentId) {
		StudentDto studentDto2 = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
						.executeQuery("SELECT st.id as student_id, st.name, st.section, st.standard, st.mobile, ad.id as address_id, ad.district, ad.pincode"
									+ " FROM students02 st inner join address02 ad on st.address_id=ad.id where st.id ="
									+ studentId);
			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("name");
				String section = rs.getString("section");
				String standard = rs.getString("standard");
				String mobile = rs.getString("mobile");
				int addressId = rs.getInt("address_id");
				String district = rs.getString("district");
				int pincode = rs.getInt("pincode");
				
				AddressDto addressDto = new AddressDto();
				addressDto.setDistrict(district);
				addressDto.setPincode(pincode);
				addressDto.setId(addressId);
				
				StudentDto studentDto1 = new StudentDto();
				studentDto1.setId(id);
				studentDto1.setName(name);
				studentDto1.setMobile(mobile);
				studentDto1.setStandard(standard);
				studentDto1.setSection(section);
				studentDto1.setAddress(addressDto);
				studentDto2 = studentDto1;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		log.info("studentDto -> " + studentDto2);
		return studentDto2;
	}

//Post 
	public void createStudent(@RequestBody StudentDto studentDto) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			PreparedStatement pStmt = connection
						.prepareStatement("INSERT INTO student_det.address02 (id, district, pincode) VALUES (?,?,?)");
			pStmt.setInt(1, studentDto.getAddress().getId());
			pStmt.setString(2, studentDto.getAddress().getDistrict());
			pStmt.setInt(3, studentDto.getAddress().getPincode());
			boolean insertStatus = pStmt.execute();
			log.info("Address Creation Status = " + insertStatus);
			PreparedStatement pStmt1 = connection
						.prepareStatement("insert into students02 (name, section, standard, mobile,address_id) values (?, ?, ?, ?,?)");
			ResultSet resSet = pStmt.executeQuery("select max(id) from student_det.address02");
			int id = 0;
			while (resSet.next()) {
				 id = resSet.getInt(1);
			}
//			PreparedStatement pStmt = connection
//						.prepareStatement("Begin;insert into students01 (name, section, standard, mobile) values (?, ?, ?, ?)insert into address (id,district,pincode)values(?,?,?);COMMIT");
			pStmt1.setString(1, studentDto.getName());
			pStmt1.setString(2, studentDto.getSection());
			pStmt1.setString(3, studentDto.getStandard());
			pStmt1.setString(4, studentDto.getMobile());
			pStmt1.setInt(5, id);
//			pStmt.setString(6, studentDto.getAddress().getDistrict());
//			pStmt.setInt(7, studentDto.getAddress().getPincode());
			boolean insertStatus1 = pStmt1.execute();
			log.info("Student Creation Status = " + insertStatus1);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		log.info("studentDto -> " + studentDto);

	}

//Put
	public void updateStudent(int studentId, StudentDto studentDto) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			int addId=getParticularStudent(studentId).getAddress().getId();
			PreparedStatement pStmt = connection
						.prepareStatement("update students02 set name=?, section=?, standard=?, mobile=? where id=?");
			pStmt.setString(1, studentDto.getName());
			pStmt.setString(2, studentDto.getSection());
			pStmt.setString(3, studentDto.getStandard());
			pStmt.setString(4, studentDto.getMobile());
			pStmt.setInt(5, studentId);
			// Execute Query
			boolean updateStatus = pStmt.execute();
			log.info("Student PUT Status = " + updateStatus);
			PreparedStatement pStmt1 = connection
						.prepareStatement("update address02 set district=?, pincode=? where id=?");
			pStmt1.setInt(3, addId);
			pStmt1.setString(1, studentDto.getAddress().getDistrict());
			pStmt1.setInt(2, studentDto.getAddress().getPincode());
			boolean insertStatus1 = pStmt1.execute();
			log.info("Address PUT Status = " + insertStatus1);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		log.info("StudentDTO updated successfully ---------");
	}

//Patch
	@Override
	public void selUpdStudent(int studentId, StudentDto studentDto) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			StudentDto studentDtoFromDb = dataFromIpToDB(studentId, studentDto);
			int addId=getParticularStudent(studentId).getAddress().getId();
			PreparedStatement pStmt = connection
						.prepareStatement("update students02 set name=?, section=?, standard=?, mobile=? where id=?");
			pStmt.setString(1, studentDtoFromDb.getName());
			log.info("Patch Db :: "+studentDtoFromDb.getName());
			pStmt.setString(2, studentDtoFromDb.getSection());
			pStmt.setString(3, studentDtoFromDb.getStandard());
			pStmt.setString(4, studentDtoFromDb.getMobile());
			pStmt.setInt(5, studentDtoFromDb.getId());
			log.info("Patch Db :: "+studentDtoFromDb);
			log.info("StudentDTO patch updated successfully ---------");
			boolean updateStatus = pStmt.execute();
			log.info("Student Creation Status = " + updateStatus);
			PreparedStatement pStmt1 = connection
						.prepareStatement("update address02 set district=?, pincode=? where id=?");
			pStmt1.setInt(3, addId);
			pStmt1.setString(1, studentDtoFromDb.getAddress().getDistrict());
			pStmt1.setInt(2, studentDtoFromDb.getAddress().getPincode());
			log.info("Patch Db add :: "+studentDtoFromDb.getAddress());
			boolean insertStatus1 = pStmt1.execute();
			log.info("Address PUT Status = " + insertStatus1);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

	private StudentDto dataFromIpToDB(int studentId, StudentDto studentDto) {
		StudentDto studentDtoFromDb = getParticularStudent(studentId);
		if (studentDto.getName() != null) {
			studentDtoFromDb.setName(studentDto.getName());
		}
		if (studentDto.getMobile() != null) {
			studentDtoFromDb.setMobile(studentDto.getMobile());
		}
		if (studentDto.getSection() != null) {
			studentDtoFromDb.setSection(studentDto.getSection());
		}
		if (studentDto.getStandard() != null) {
			studentDtoFromDb.setStandard(studentDto.getStandard());
		}
		if (studentDto.getAddress().getDistrict() != null) {
			studentDtoFromDb.getAddress().setDistrict(studentDto.getAddress().getDistrict());
		}
		if (studentDto.getAddress().getPincode() != 0) {
			studentDtoFromDb.getAddress().setPincode(studentDto.getAddress().getPincode());
		}
		return studentDtoFromDb;
	}

//Delete	
	public void DeleteStudent(int studentId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/student_det", "root", "ajay");
			
			int addId=getParticularStudent(studentId).getAddress().getId();
			log.info("address id :: " +addId);
			PreparedStatement pStmt = connection
						.prepareStatement("delete from address02 where id="+addId);
			boolean updateStatus = pStmt.execute();
			log.info("Student Deletetion Status = " + updateStatus);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		log.info(studentId + " has deleted successfully ---------");
	}
}
