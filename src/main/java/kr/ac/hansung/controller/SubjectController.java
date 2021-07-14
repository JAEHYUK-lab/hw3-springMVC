package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/subjects")
	public String showSubjects(Model model) {

		List<Subject> subjects = subjectService.getCurrent();
		model.addAttribute("subjects", subjects);

		return "subjects";
	}

	@RequestMapping("/subjectslist")
	public String showSubjectsList(Model model) {

		List<Subject> subjects = subjectService.getCurrentList();
		model.addAttribute("subjects", subjects);

		return "subjectslist";
	}
	
	@RequestMapping("/newsubjectslist")
	public String showNewSubjectsList(Model model) {

		List<Subject> subjects = subjectService.getNewCurrentList();
		model.addAttribute("subjects", subjects);

		return "newsubjectslist";
	}

	@RequestMapping("/subjectslistwithsemester")
	public String showSubjectsListWithSemester(Model model, HttpServletRequest request) {
		String strYear = request.getParameter("year");
		String strSemester = request.getParameter("semester");
		int year = Integer.valueOf(strYear);
		int semester = Integer.valueOf(strSemester);
		List<Subject> subjects = subjectService.getCurrentListWithSemetser(year, semester);
		model.addAttribute("subjects", subjects);

		return "subjectslistwithsemester";

	}
	
	@RequestMapping("/createsubject")
	public String createSubject(Model model) {

		model.addAttribute("subject", new Subject()); // new Subject() 없으면 exception

		return "createsubject";
	}

	@RequestMapping("/dosubject")
	public String doCreate(Model model, @Valid Subject subject, BindingResult result) {

		// System.out.println(offer); Controller -> Service -> Dao

		if (result.hasErrors()) {
			System.out.println("== Form data does not validated ==");

			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "createsubject";
		}

		subjectService.insert(subject);

		return "subjectcreated";
	}

}
