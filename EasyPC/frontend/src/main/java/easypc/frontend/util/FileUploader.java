package easypc.frontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	
	private static final String absPath = "G:\\frontend\\src\\main\\webapp\\assets\\images\\";
	private static String realPath="";
	private static final Logger lgr = LoggerFactory.getLogger(FileUploader.class);
	
	
	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code) {
		
		// getting real path
		realPath= req.getSession().getServletContext().getRealPath("/assets/images/");
		lgr.info(realPath);
		
		//checking for directory presence -
		if(!new File(absPath).exists()){
			//creating directories
			new File(absPath).mkdirs();
		}
		if(!new File(realPath).exists()){
			//creating directories
			new File(realPath).mkdirs();
		}
		
	try{
		//server upload
		file.transferTo(new File(realPath + code + ".jpg"));
		//project directory upload
		file.transferTo(new File(absPath + code + ".jpg"));
	}
	catch(IOException e){}	
		
	}
	
	
	
}
