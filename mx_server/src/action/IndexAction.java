package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.IndexService;

@Controller
public class IndexAction {
	
	@Resource
	public IndexService is;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) throws Exception {
		return new ModelAndView("/home/html/index");
	}
}

