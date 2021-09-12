    package com.wesotero.xonomy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wesotero.xonomy.model.Specimen;
import com.wesotero.xonomy.service.StorageService;

@Controller
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200/")
public class FileUploadController {
	
	private final StorageService storageService;
	
	@Autowired
	public FileUploadController(StorageService storageService) {
		super();
		this.storageService = storageService;
	}

	@PostMapping("/upload")
	public ResponseEntity<Void> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("species") String species,  @RequestParam("specimenName") String specimenName) {
		storageService.store(file, species, specimenName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
