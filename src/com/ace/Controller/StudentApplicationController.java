package com.ace.Controller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ace.entity.Student;
import com.ace.service.StudentService;

@Controller
public class StudentApplicationController {
	private static final Logger log = Logger
			.getLogger(StudentApplicationController.class.getName());
	private static final String UPLOAD_DIRECTORY = "/uploadXML";

	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Student Online Application");
		return "index";

	}
	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView getStudentFromXml(
			@RequestParam CommonsMultipartFile file, HttpSession session) {
		System.out.println("Inside Controller");
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();

		System.out.println(path + " " + fileName);

		this.studentService.getStudentFromXml(fileName);
		return new ModelAndView("uploadform", "filesuccess",
				"File successfully saved!");
	}

	public static void main(String[] args) {
		// ExecutorService executor = Executors.newFixedThreadPool(5);

		try {

			File newFile = new File("C:\\file.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(newFile);
			log.log(Level.INFO, "Student Info " + student);

		} catch (JAXBException e) {
			log.log(Level.SEVERE, "Error Occourred " + e.getMessage());

		}

	}

}
