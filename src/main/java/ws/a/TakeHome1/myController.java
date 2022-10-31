/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.TakeHome1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */

@Controller
public class myController {
    
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";
    
    @RequestMapping("/mainpage")
    public String hal(
    @RequestParam(value = "nama") String isinama,
            @RequestParam(value = "lokasi") String isilokasi,
         @RequestParam(value = "gambar") MultipartFile file,
            Model kiriman)
            throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        kiriman.addAttribute("msg", file.getOriginalFilename());
        kiriman.addAttribute("paketnama", isinama);
        kiriman.addAttribute("paketlokasi", isilokasi);
        
        return "viewpage";
    }
    
}
