package flying.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import flying.entity.sparrow.SparrowTest;
import flying.service.sparrow.dao.impl.SparrowTestServiceImpl;
import flying.service.sparrow.nozzle.SpTestServiceI;

@RestController
public class TestApiController {
	
	@Autowired
	private SparrowTestServiceImpl testService;
	
	@RequestMapping("/")
	@ResponseBody
	public Map<String, String> index(HttpServletRequest request) {
//		SparrowTest test = testService.selectById(1);
//		System.out.println(test);
		Map<String, String> result = new HashMap<String, String>();
		result.put("test", "hello");
		return result;
	}
}
