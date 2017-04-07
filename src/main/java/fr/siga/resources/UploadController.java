package fr.siga.resources;

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
public class UploadController 
{
    private static String UPLOADED_FOLDER = "//home//mkd//Workspace//spring//formaSIGA//src//main//resources//static//images//temp//";

    @RequestMapping(value="upload",method=RequestMethod.POST)
    public String singleFileUpload(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes) 
    {
        if (file.isEmpty()) 
        {
            redirectAttributes.addFlashAttribute("message", "Choisir une image avatar.");
            return "redirect:uploadStatus";
        }

        try
        {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER +"khairi"+file.getContentType().replaceAll("[A-Za-z]*[/]","."));
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message","Votre images a été envoyé avec succès :" + file.getOriginalFilename() + "'");
            System.out.println(path.toString());
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            System.out.println(file.getName());
            System.out.println(file.getSize());
            System.out.println(file.getBytes());
            System.out.println(file.getInputStream());
        } 
        catch (IOException e) 
        {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "redirect:/uploadStatus";
    }
}
