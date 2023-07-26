package com.kopo.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kopo.domain.Webtoon;
import com.kopo.service.WebtoonService;

//컨트롤러는 서비스계층과 연결되야함
@Controller
//@RequestMapping("/webtoons")
public class WebtoonController {

	@Autowired //서비스계층과 연결
	private WebtoonService webtoonService;
	
	
	@GetMapping("/webtoons")
	//@RequestMapping(value="/webtoons",method = RequestMethod.GET)
	public String requestWebtoonList(Model model) {
	List<Webtoon>list = webtoonService.getAllWebtoonList();
	
	model.addAttribute("webtoonList", list);
	
	return "webtoons";
	
	}
	
	//경로 변수 활용
	@GetMapping("/{genre}")
	public String requestWebtoonByGenre(@PathVariable("genre")String webtoonGenre,Model model) {
		
		List<Webtoon> list= webtoonService.getWebtoonListByGenre(webtoonGenre);
		model.addAttribute("webtoonList", list);
		
		return "webtoons";
	}

	@GetMapping("/filter/{webtoonfilter}")
	
	public String requestWebtoonByFilter(@MatrixVariable(pathVar="webtoonfilter")Map<String,List<String>> webtoonfilter,Model model){
		
		Set<Webtoon> webtoonByFilter = webtoonService.getWebtoonListByFilter(webtoonfilter);
		model.addAttribute("webtoonList",webtoonByFilter );
		
		return "webtoons";
	}
	
	// http://localhost/test/home/exam13?id=1234
	@GetMapping("/webtoon")
	public String requestWebtoonName(@RequestParam("name")String webtoonName,Model model) {
		Webtoon webtoon = webtoonService.getWebtoonByName(webtoonName);
		model.addAttribute("webtoon", webtoon);
		return "webtoon";
	}

	@GetMapping("/admin/add")
	public String requestAddWebtoonForm(@ModelAttribute("NewWebtoon")Webtoon webtoon) {
		
		return "addWebtoon";
	}
	
	
	@PostMapping("/admin/add")
	public String submitForm(@ModelAttribute("NewWebtoon")Webtoon webtoon,HttpServletRequest request,HttpSession session) {
		UUID uuid = UUID.randomUUID();  //중복방지를 위한 uuid 적용
		String temp =webtoon.getImgFile().getOriginalFilename().replaceAll(" ", "");
		String filename = webtoon.getName()+uuid.toString()+"_"+temp;  //MultipartFile 메서드-> getOriginalFileName() : 업로드파일의 이름
		//String filename = webtoon.getName()+uuid.toString()+"_"+webtoon.getImgFile().getOriginalFilename();  //MultipartFile 메서드-> getOriginalFileName() : 업로드파일의 이름
	
		try {
			webtoon.getImgFile().transferTo(new File("C:\\SpringWorkspace\\WebtoonPage02\\src\\main\\webapp\\resources\\img\\"+filename));  //MultipartFile 메서드-> transferTo(File file) : 파일을  저장 
			webtoon.setImgPath(filename);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		webtoonService.setNewWebtoon(webtoon);
		//webtoonService.setNewWebtoon(webtoon, filename);
		
		return "redirect:/webtoons"; //파일 전송 성공 시 출력됨
	}

}

/* path-> tomcat에 server.xml에 /controller로 저장해둠 */
/*<annotation-driven enable-matrix-variables="true"></annotation-driven>=>매트릭스 변수 이용하기 위해 추가해줘야함*/