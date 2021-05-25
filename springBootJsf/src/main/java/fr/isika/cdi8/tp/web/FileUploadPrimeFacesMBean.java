package fr.isika.cdi8.tp.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

import lombok.Getter;
import lombok.Setter;
  

@ManagedBean
@RequestScoped
@Getter @Setter
public class FileUploadPrimeFacesMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UploadedFile uploadFile;

	private String other = "other-data";
	
    public void processUpload() throws IOException {
    	System.out.println("FileUploadPrimeFacesMBean.processUpload() called , file="+uploadFile +  ", other=" + other);
    	  if (uploadFile != null) {
    		  System.out.println("fileName="+uploadFile.getFileName());
    		  System.out.println("contentType="+uploadFile.getContentType());
    		  System.out.println("size="+uploadFile.getSize());
    	      FacesMessage message = new FacesMessage("Successful", uploadFile.getFileName() + " is uploaded.");
    	      FacesContext.getCurrentInstance().addMessage(null, message);
    	      try {
    	    	  Path folder = Paths.get("d:\\temp3");
    	    	  String filename = FilenameUtils.getBaseName(uploadFile.getFileName()); 
    	    	  String extension = FilenameUtils.getExtension(uploadFile.getFileName());
    	    	  Path file = Files.createTempFile(folder, filename + "-", "." + extension);
    	    	  try (InputStream input = uploadFile.getInputStream()) {
    	    		    Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
    	    		}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	  }
    
    }  
}  
         
