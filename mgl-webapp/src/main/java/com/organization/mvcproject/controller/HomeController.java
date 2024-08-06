package com.organization.mvcproject.controller;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.ReviewImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ModelAndView review() {

        return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public ModelAndView addReview(ReviewImpl review, ModelMap model) {
        if(review.getAuthor().isEmpty()) {
            review.setAuthor("anonymous");
        }

        return new ModelAndView("reviewDetailPage", "submittedReview", review);
    }

    @RequestMapping(value = "/gamesLibrary", method = RequestMethod.GET)
    public ModelAndView game() {
        return new ModelAndView("gamesPage", "command", new GameImpl());
    }

	@RequestMapping(value="/hello")
    public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
        ModelAndView ret = new ModelAndView("home");
        // Adds an object to be used in home.jsp
        ret.addObject("name", testingMethod());
        
        //logs to console 
        practiceLoop();
        
        return ret;
    }

	
	private String testingMethod() {
        return "testing Method";
    }
    private String practiceLoop() {
        String testString = "";
        for(int i=0; i<=10; i++) {
            System.out.println("i: "+i);
            testString += i;
            System.out.println("testString: " + testString);
        }
        return testString;
    }
}