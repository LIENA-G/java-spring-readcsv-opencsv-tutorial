package com.csvRead.Controllers;

import com.csvRead.Entities.FileObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/fileUpload")
    public String mainForm(ModelMap model) {
        FileObject multipartFile = new FileObject();
        model.addAttribute("multipartFile", multipartFile);
        return "mainUploadView";
    }

}
