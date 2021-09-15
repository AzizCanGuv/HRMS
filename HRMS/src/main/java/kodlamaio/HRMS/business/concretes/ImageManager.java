package kodlamaio.HRMS.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.core.adapters.cloudinary.CloudinaryManager;
import kodlamaio.HRMS.core.adapters.cloudinary.CloudinaryService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ImageDao;
import kodlamaio.HRMS.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService) {
		this.imageDao = imageDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
		
	}

	@Override
	public Result add(MultipartFile multipartFile) throws IOException {
		
		var result = cloudinaryService.sendFile(multipartFile);
		return new SuccessResult("Image is uploaded");
		
	}

	
	
	
}
