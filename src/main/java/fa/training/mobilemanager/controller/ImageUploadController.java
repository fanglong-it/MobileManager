package fa.training.mobilemanager.controller;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 11/10/21, 7:14 AM
 *
 *
 */

@Controller
@RequestMapping("get_image")
public class ImageUploadController {


    @GetMapping("show/{photo}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable(name = "photo") String photo) {
        if (!photo.equals("") || photo != null) {
            try {
                Path filename = Paths.get("uploads", photo);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("images/png"))
                        .body(byteArrayResource);

            } catch (Exception e) {

            }
        }
        return ResponseEntity.badRequest().build();
    }
}
