package com.csvRead.Controllers;
/*
Note:
Retrieve eachRecord as string array can be done in several ways:
1-read as string array.
2-read all lines.
3-read by iterator.
all of these services implements ReadWithoutAnnotation interface to apply dependency injection.
here @Autowired is used to wire ReadWithoutAnnotation and  @Qualifier("readByIterator") is used to select the implementation.

* */

import com.csvRead.Entities.FileObject;
import com.csvRead.Services.SaveFileService;
import com.csvRead.Services.ReadWithoutAnnotation.ReadWithoutAnnotation;
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
public class RetrieveEachRecordAsStringArray {
    @Autowired
    SaveFileService saveFileService;
    @Autowired
    @Qualifier("readByIterator")
    ReadWithoutAnnotation read;

    @GetMapping(value = "/retrieveEachRecordAsStringArray")
    public String singleFileUploadForm(ModelMap model) {
        FileObject multipartFile = new FileObject();
        model.addAttribute("multipartFile", multipartFile);
        return "RetrieveEachRecordAsStringArray";
    }


    @PostMapping(value = "/retrieveEachRecordAsStringArray")
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
