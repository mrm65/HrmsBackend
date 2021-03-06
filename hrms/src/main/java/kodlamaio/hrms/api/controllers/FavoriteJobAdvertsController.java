package kodlamaio.hrms.api.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoriteJobAdvertsController {

	private FavoriteJobAdvertService favoriteJobAdvertService;

	@Autowired
	public FavoriteJobAdvertsController(FavoriteJobAdvertService favoriteJobAdvertService) {
		super();
		this.favoriteJobAdvertService = favoriteJobAdvertService;
	}
	
	@GetMapping("/getbycandidateid")
	public DataResult<List<FavoriteJobAdvert>> getByCandidateId(@RequestParam int candidateId){
		return this.favoriteJobAdvertService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/addfavorite")
	public ResponseEntity<?>  addFavorite(@RequestParam int candidateId,@RequestParam int jobAdvertId) {
		Result result = this.favoriteJobAdvertService.addFavorite(candidateId, jobAdvertId);
		if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/removefavorite")
	public Result removeFavorite(@RequestParam int favoriteId) {
		return this.favoriteJobAdvertService.removeFavorite(favoriteId);
	}
	
	
}
