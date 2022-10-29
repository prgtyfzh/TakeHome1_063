/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.TakeHome1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */

@Controller
public class myController {
    
    @RequestMapping("/mainpage")

    public String hal(
    @RequestParam(value = "nama") String isinama,
            @RequestParam(value = "lokasi") String isilokasi,
            @RequestParam(value = "gambar") String isigambar,
            Model kiriman
    ){
        kiriman.addAttribute("paketnama", isinama);
        kiriman.addAttribute("paketlokasi", isilokasi);
        kiriman.addAttribute("paketgambar", isigambar);
        
        return "viewpage";
    }
    
}
