package com.wesotero.xonomy.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	public void store(MultipartFile multipartFile) {
		try {
			// TODO: Find a good way for the user to define file location settings
			multipartFile.transferTo(new File("E:\\images_bucket\\xonomy\\images\\" + multipartFile.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void store(MultipartFile multipartFile, String species,  String specimenName) {
		try {
			StringBuilder path = new StringBuilder("E:\\images_bucket\\xonomy\\images");
			path.append("\\" + species + "\\");
			StringBuilder fileName = new StringBuilder(specimenName + ".jpg");
			File directory = new File(path.toString());
			if(!directory.exists()) {
				directory.mkdir();
			}	
			multipartFile.transferTo(new File(path + "\\" + fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
