package anagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public String home() {
		System.out.println("Going home...");
		return "index";
	}

	@RequestMapping("/anagrams")
	public String showForm(Model model) {
		AnagramForm form = new AnagramForm();
//		List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");

		model.addAttribute("form", form);
//		model.addAttribute("professionList", professionList);

		System.out.println("Word is " + form.getWord());

		return "anagram";
	}

	@PostMapping("/anagrams")
	public String submitForm(@ModelAttribute("form") AnagramForm form) {

		System.out.println(form);

		System.out.println("Word is " + form.getWord());

		if (form.getWord().matches("[a-zA-Z]+")) {
			HashSet<String> angs = generateAnagram(form.getWord());

			form.setAnagrams(angs);
		} else {
			form.setMessage("Invalid word!! Only alphabets allowed");
		}

		return "anagram";
	}

//	@RequestMapping(value = "/anagram", method = RequestMethod.GET)
//	public ModelAndView showForm() {
//		return new ModelAndView("anagram", "anagram", new AnagramForm());
//	}

//	@RequestMapping(value = "/anagram", method = RequestMethod.POST)
//	public String submit(@Validated @ModelAttribute("anagram") AnagramForm anagram, BindingResult result,
//			ModelMap model) {
//		if (result.hasErrors()) {
//			return "error";
//		}
//		model.addAttribute("name", anagram.getWord());
//		return "anagramView";
//	}

//	@RequestMapping(value = "/anagram", method = RequestMethod.POST)
//	public void listAnagrams(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam("word") String word) throws ServletException, IOException {
//
//		// Postprocess request: gather and validate submitted data and display the
//		// result in the same JSP.
//
//		// Prepare messages.
//		Map<String, String> messages = new HashMap<String, String>();
//		request.setAttribute("messages", messages);
//
//		// Get and validate name.
//
//		if (word == null || word.trim().isEmpty()) {
//			messages.put("word", "Please enter a word");
//		} else if (!word.matches("\\p{Alnum}+")) {
//			messages.put("word", "Please enter alphanumeric characters only");
//		}
//		request.setAttribute("word", word);
//
//		// No validation errors? Do the business job!
//		if (messages.isEmpty()) {
//			generateAnagram(word);
//
//		}
//		Set t = new HashSet<>(generateAnagram(word));
////		request.setAttribute("anagrams", generateAnagram(name));
//		request.setAttribute("anagrams", t);
//
////		request.getRequestDispatcher("index.jsp").forward(request, response);
//
//	}

	public HashSet<String> generateAnagram(String word) {
		char[] ca = word.toCharArray();
		char tmp = 0;
		String s = "";
		List<String> lst = new ArrayList<String>();
		for (int i = 0; i < ca.length; i++) {
			for (int j = (ca.length - 1); j > 0; j--) {
				tmp = ca[j];
				ca[j] = ca[j - 1];
				ca[j - 1] = tmp;
				for (int k = 0; k < ca.length; k++) {
					s = s + ca[k];
				}
				lst.add(s);
				s = "";
			}
		}

		return new HashSet<String>(lst);
	}

}
