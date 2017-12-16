package flying.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import flying.service.sparrow.nozzle.SpTestServiceI;

@RestController
public class TestApiController {
	
//	@Autowired
//	private SpTestServiceI testService;
	
	@RequestMapping("/")
	@ResponseBody
	public String index(HttpServletRequest request) {
		return "Test";
	}
}
