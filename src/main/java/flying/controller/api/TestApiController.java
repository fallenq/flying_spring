package flying.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import flying.entity.sparrow.SparrowTest;
import flying.service.sparrow.dao.nozzle.SparrowTestServiceI;
import flying.service.sparrow.nozzle.SpTestServiceI;

@RestController
public class TestApiController {
	
	@Autowired
	private SpTestServiceI testService;
	
	@RequestMapping("/")
	@ResponseBody
	public Map<String, String> index(HttpServletRequest request) {
//		SparrowTest test = new SparrowTest();
//		System.out.println(testService.getById(1));
		Map<String, String> result = new HashMap<String, String>();
//		HttpSession session = request.getSession();
//		session.setAttribute("test", "world");
		result.put("test", "hello");
		return result;
	}
}
