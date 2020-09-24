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

		model.addAttribute("form", form);

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
