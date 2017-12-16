package flying.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("test", "hello1");
		return (String) session.getAttribute("test");
	}
}
