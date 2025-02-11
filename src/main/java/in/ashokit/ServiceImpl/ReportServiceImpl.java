package in.ashokit.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	
	public ReportServiceImpl() {
		System.out.println("Object created");
	}
	@Autowired
	private CitizenPlanRepository planRepo;
	
	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return planRepo.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest searchRequest) {
		CitizenPlan entity = new CitizenPlan();
		if(null != searchRequest.getPlanName() && !"".equals(searchRequest.getPlanName())) {
			entity.setPlanName(searchRequest.getPlanName());
		}
		if(null != searchRequest.getPlanStatus() && !"".equals(searchRequest.getPlanStatus())) {
			entity.setPlanStatus(searchRequest.getPlanStatus());
		}
		if(null != searchRequest.getGender() && !"".equals(searchRequest.getGender())) {
			entity.setGender(searchRequest.getGender());
		}
		if(null != searchRequest.getStartDate() && !"".equals(searchRequest.getStartDate())) {
			LocalDate startDate = searchRequest.getStartDate();
			entity.setPlanStartDate(startDate);
		}
		if(null != searchRequest.getEndDate() && !"".equals(searchRequest.getEndDate())) {
			LocalDate endDate = searchRequest.getEndDate();
			entity.setPlanEndDate(endDate);
		}	
		//planRepo.findAll(Example.of(entity));
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel() {
		return false;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

}
