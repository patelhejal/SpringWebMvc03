package in.ashokit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "CITIZEN_PLANS_INFO")
public class CitizenPlan {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenID;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmt;
	private String denialReason;
	private LocalDate terminationDate;
	private String terminationReason;

	public String toString() {
		return "CitizenPlan(citizenID=" + this.getCitizenID() + ", citizenName=" + this.getCitizenName() + ", gender=" + this.getGender() + ", planName=" + this.getPlanName() + ", planStatus=" + this.getPlanStatus() + ", planStartDate=" + this.getPlanStartDate() + ", planEndDate=" + this.getPlanEndDate() + ", benefitAmt=" + this.getBenefitAmt() + ", denialReason=" + this.getDenialReason() + ", terminationDate=" + this.getTerminationDate() + ", terminationReason=" + this.getTerminationReason() + ")";
	}

	public Integer getCitizenID() {
		return this.citizenID;
	}

	public String getCitizenName() {
		return this.citizenName;
	}

	public String getGender() {
		return this.gender;
	}

	public String getPlanName() {
		return this.planName;
	}

	public String getPlanStatus() {
		return this.planStatus;
	}

	public LocalDate getPlanStartDate() {
		return this.planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return this.planEndDate;
	}

	public Double getBenefitAmt() {
		return this.benefitAmt;
	}

	public String getDenialReason() {
		return this.denialReason;
	}

	public LocalDate getTerminationDate() {
		return this.terminationDate;
	}

	public String getTerminationReason() {
		return this.terminationReason;
	}

	public void setCitizenID(Integer citizenID) {
		this.citizenID = citizenID;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}

	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}
}
