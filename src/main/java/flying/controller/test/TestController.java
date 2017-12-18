package flying.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class TestController {

	@GetMapping("/index")
	public String index() {
		return "test";
	}
	
}
