package com.csvRead.Controllers;

import com.csvRead.Entities.FileObject;
import com.csvRead.Services.ReadWithoutAnnotation.ReadWithoutAnnotation;
import com.csvRead.Services.SaveFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class ReadIntoBeanWithoutAnnotation {
    @Autowired
    SaveFileService saveFileService;
    @Autowired
    @Qualifier("ReadBeanWithoutAnnotation")
    ReadWithoutAnnotation read;

    @GetMapping(value = "/ReadIntoBeanWithoutAnnotation")
    public String singleFileUploadForm(ModelMap model) {
        FileObject multipartFile = new FileObject();
        model.addAttribute("multipartFile", multipartFile);
        return "ReadIntoBeanWithoutAnnotation";
    }


    @PostMapping(value = "/ReadIntoBeanWithoutAnnotation")
    public String singleFileUpload(@ModelAttribute("multipartFile") FileObject multipartFile, BindingResult result, ModelMap model) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }

        File uploadedFile = saveFileService.saveMultipartToFile(multipartFile.getFile(), multipartFile.getFile().getOriginalFilename());
        read.read(uploadedFile);
        model.addAttribute("fileName", uploadedFile.getName());
        return "fileUploadFileDetailsView";
    }


}
