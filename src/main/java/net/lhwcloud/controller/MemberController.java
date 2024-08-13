package net.lhwcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.MemberVO;
import net.lhwcloud.service.MemberService;

@Controller // 스프링이 컨트롤러 역할을 제공
@Log4j2
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {

	private MemberService service;

	@PostMapping("/registerMember")
	public String register(MemberVO member, RedirectAttributes rttr) {
		log.info("registerMember");
		service.registerMember(member);

		rttr.addFlashAttribute("result", member.getId());
		return "redirect:/member";
	}

	@GetMapping("/getMember")
	public void getMember(String id, Model model) {
		log.info("getMember");
		model.addAttribute("member", service.getMember(id));
	}

	@PostMapping("/modifyMember")
	public String modifyMember(MemberVO member, RedirectAttributes rttr) {
		log.info("modifyMember");
		if (service.modifyMember(member)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member";
	}

	@PostMapping("/removeMember")
	public String removeMember(MemberVO member, RedirectAttributes rttr) {
		log.info("removeMember");
		if (service.removeMember(member.getId())) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member";
	}

}
