package edu.remad.springconfig.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.remad.springconfig.models.TutorLessionItem;
import edu.remad.springconfig.models.TutorLessionList;

@Controller
@RequestMapping("/sessionattributes")
@SessionAttributes("tutorLessions")
public class TutorLessionControllerWithSessionAttributes {

	@ModelAttribute("tutorLessions")
	public TutorLessionList tutorLessions() {
		System.out.println("invoked tutorLessions");
	    return new TutorLessionList();
	}
	
	@GetMapping("/form")
	public String showForm(
	  Model model,
	  @ModelAttribute("tutorLessions") TutorLessionList tutorLessions) {
		System.out.println("invoked showForm()");
		
	    if (!tutorLessions.isEmpty()) {
	        model.addAttribute("tutorLessionItem", tutorLessions.peekLast());
	    } else {
	        model.addAttribute("tutorLessionItem", new TutorLessionItem());
	    }
	    
	    return "tutorLessionsForm";
	}
	
	@PostMapping("/form")
	public String create(
	  @ModelAttribute TutorLessionItem tutorLessionItem, 
	  @ModelAttribute("tutorLessions") TutorLessionList tutorLessions, 
	  RedirectAttributes attributes) {
		System.out.println("ivoked create)");
	    tutorLessionItem.setLessionDate(LocalDateTime.now());
	    tutorLessions.add(tutorLessionItem);
	    attributes.addFlashAttribute("tutorLessions", tutorLessions);
	    
	    return "redirect:/sessionattributes/tutorLessions";
	    		//new RedirectView("sessionattributes/tutorLessions");
	}
	
	@GetMapping("/tutorLessions")
    public String list(
            Model model, 
            @ModelAttribute("tutorLessions") TutorLessionList tutorLessions) {
		System.out.println("invoked list()");
        model.addAttribute("tutorLessions", tutorLessions);
        
        return "session-attributes-tutorlessions";
    }
}
