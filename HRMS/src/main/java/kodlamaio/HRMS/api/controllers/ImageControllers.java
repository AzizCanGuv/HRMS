package kodlamaio.HRMS.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.core.adapters.cloudinary.CloudinaryService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;
import kodlamaio.HRMS.entities.concretes.Image;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images")
public class ImageControllers {

	
	private ImageService imageService;

	@Autowired
	public ImageControllers(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestPart(name="file") MultipartFile file) throws IOException {
		
		return this.imageService.add(file);
		
	}
	
	
	
}
