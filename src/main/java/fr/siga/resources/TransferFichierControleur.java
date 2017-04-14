package fr.siga.resources;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class TransferFichierControleur 
{
    private static String UPLOADED_FOLDER = "//home//mkd//Workspace//spring//formaSIGA//src//main//resources//static//images//employe//";
    private static String UPLOADED_BD = "//static//images//employe//";

    @RequestMapping(value="transfer",method=RequestMethod.POST)
    public String TransferSeulFichier(@RequestParam("file")MultipartFile file) 
    {
    	String motifUnique = genererNomImages();
    	
        if (file.isEmpty()) 
        {
            return "";
        }

        try
        {
            byte[] bytes = file.getBytes();

            Path path = Paths.get(UPLOADED_FOLDER + motifUnique + file.getContentType().replaceAll("[A-Za-z]*[/]","."));
            Files.write(path, bytes);
            /*
            System.out.println(path.toString());
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            System.out.println(file.getName());
            System.out.println(file.getSize());
            System.out.println(file.getBytes());
            System.out.println(file.getInputStream());
            */
        } 
        catch (IOException e) 
        {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return UPLOADED_BD + motifUnique + file.getContentType().replaceAll("[A-Za-z]*[/]",".");
    }
    
    synchronized String genererNomImages() 
    {
    	return DateTime.now().toString("yyyyMMddHHmmss");
    }
}
