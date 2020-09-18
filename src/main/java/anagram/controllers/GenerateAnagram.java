//package anagram.controllers;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/anagram")
//public class GenerateAnagram extends HttpServlet {
//
//	public static char[] charArray;
//	private ArrayList<String> anagrams = new ArrayList<>();
//	
//	private HashMap<String, List<String>> ang= new HashMap<String, List<String>>();
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Preprocess request: we actually don't need to do any business stuff, so just
//		// display JSP.
////		request.setAttribute("anagrams", anagrams);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Postprocess request: gather and validate submitted data and display the
//		// result in the same JSP.
//
//		// Prepare messages.
//		Map<String, String> messages = new HashMap<String, String>();
//		request.setAttribute("messages", messages);
//
//		// Get and validate name.
//		String name = request.getParameter("word");
//		if (name == null || name.trim().isEmpty()) {
//			messages.put("word", "Please enter a word");
//		} else if (!name.matches("\\p{Alnum}+")) {
//			messages.put("word", "Please enter alphanumeric characters only");
//		}
//		request.setAttribute("word", name);
//
//		// No validation errors? Do the business job!
//		if (messages.isEmpty()) {
//			generateAnagram(name);
//			
//		}
//		Set t = new HashSet<>(generateAnagram(name));
////		request.setAttribute("anagrams", generateAnagram(name));
//		request.setAttribute("anagrams", t);
//	
//		
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//	}
//	
//	public List<String> generateAnagram(String word) {
//		char[] ca = word.toCharArray();
//		char tmp = 0;
//		String s = "";
//		List<String> lst = new ArrayList<String>();
//		for (int i = 0; i < ca.length; i++) {
//			for (int j = (ca.length - 1); j > 0; j--) {
//				tmp = ca[j];
//				System.out.println("i "+i + " cai " + ca[i]);
//				System.out.println("j "+j + " caj " + ca[j]);
//				ca[j] = ca[j-1];
//				ca[j-1] = tmp;
//				for (int k = 0; k < ca.length; k++) {
//					s = s + ca[k];
//				}
//				System.out.println(s);
//				lst.add(s);
//				s = "";
//			}
//		}
//		
//		return lst;
//	}
//
//
//}