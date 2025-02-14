package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	
	private ReportService reportService;

        
	public ReportController() {
		System.out.println("0 PARAM - Constructor is called");
	}
	@Autowired
	public ReportController(ReportService reportService) {
		System.out.println("Arg - Constructor is called");
        this.reportService = reportService;
    }
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model) {
		List<CitizenPlan> plans = reportService.search(search);
		model.addAttribute("plans",plans);
		init( model);
		return "index";
	}
	
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octct-stream");
		response.addHeader("Content-Disposition", "attachement;filename=plans.xls");
		reportService.exportExcel(response);
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest searchObj = new SearchRequest();
		model.addAttribute("search", searchObj);
		init( model);
		return "index";
	}
	
	private void init(Model model) {
		model.addAttribute("names", reportService.getPlanNames());
		model.addAttribute("status", reportService.getPlanStatuses());
	}
	
	

}
