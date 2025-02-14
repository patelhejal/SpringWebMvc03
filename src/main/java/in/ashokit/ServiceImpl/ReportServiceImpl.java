package in.ashokit.ServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		Workbook workBook = new HSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workBook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(0).setCellValue("Citizen Name");
		headerRow.createCell(0).setCellValue("Plan Name");
		headerRow.createCell(0).setCellValue("Plan Status");
		headerRow.createCell(0).setCellValue("Plan StartDate");
		headerRow.createCell(0).setCellValue("Plan EndDate");
		headerRow.createCell(0).setCellValue("Benefit Amt");
		
		List<CitizenPlan> records = planRepo.findAll();
		
		int dataRowIndex =1;
		
		for(CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenID());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
			dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			
			dataRowIndex++;
		}
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			workBook.write(outputStream);
			outputStream.close();
		}catch(IOException ioe) {
			ioe.getMessage();
		}
	
		return true;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

}
