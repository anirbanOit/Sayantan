package feature.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	@GetMapping(value = "/home")
	@ResponseBody
	public String hello(){
		return "Hello I am Sans project";
	}
}
