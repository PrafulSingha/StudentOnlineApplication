package com.ace.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ace.StudentException.ControllerException;
import com.ace.StudentException.ServiceException;
import com.ace.service.StudentService;

@Controller
public class StudentApplicationController {
	private static final Logger log = Logger
			.getLogger(StudentApplicationController.class.getName());
	private static final String UPLOAD_DIRECTORY = "";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;

	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return "index";

	}

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}
	
	@RequestMapping("index")
	public ModelAndView goToHome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("searchFile")
	public ModelAndView searchForm() {
		return new ModelAndView("searchFile");
	}

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/*
	 * This method gets data from uploaded xml , create database entry and json files
	 * 
	*/
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView getStudentFromXml(
			@RequestParam CommonsMultipartFile file, HttpSession session) throws ControllerException {
		log.log(Level.INFO, "Inside Controller ");
		String result="Congrats ... File was successfully Uploaded!";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletContext context = session.getServletContext();

		String uploadPath = context.getRealPath(UPLOAD_DIRECTORY)
				+ File.separator + file.getOriginalFilename();

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream;
		try {
			stream = new BufferedOutputStream(
					new FileOutputStream(new File(uploadPath)));
		
		stream.write(bytes);
		stream.flush();
		stream.close();
		
		log.log(Level.INFO, "File uploaded " + file.getName());
		log.log(Level.INFO, "UploadPath " + uploadPath);
		this.studentService.getStudentFromXml(uploadPath);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error Occourred in Controller while getting Student From Xml " + file.getName());
			result="Error occurred while uploading";
			throw new ControllerException("Error Occourred in Controller while getting Student From Xml " + e.getMessage());
			
		}
		return new ModelAndView("output", "output",
				result);
	}
	
	
	/*
	 * This method gets checks if report is present for particular id
	 * 
	*/
	@RequestMapping(value="/searchJsonFile",method = RequestMethod.POST)
	public ModelAndView searchFile(@RequestParam("id") String id) throws ControllerException {
		String jsonfile;
		try {
			jsonfile=this.studentService.getJsonFiles(id);
		} catch (ServiceException e) {
			throw new ControllerException("Error Occourred in search file Controller  " + e.getMessage()); 
		}
		if(jsonfile!=null){
			return new ModelAndView("output", "output", jsonfile);
		}else{
			return new ModelAndView("output", "output", "File not found with id "+id);
		}
		
	}

}
