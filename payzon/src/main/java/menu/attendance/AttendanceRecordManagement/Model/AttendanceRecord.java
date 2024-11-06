package menu.attendance.AttendanceRecordManagement.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AttendanceRecord {

	private int kintai_kiroku_id; // 근태 기록 ID
	private int shain_id; // 사원 ID
	private int kintai_id; // 근태 항목 ID
	private Date kintai_bi; // 근태 일자
	private int kinngaku; // 금액
	private int kintai_zikan; // 근태 시간
	private String bikou; // 비고

	private String shain_name; // 사원 이름
	private String department; // 부서
	private String employment_type; // 고용 형태
	private String yakushoku; // 직위
	private String kintai_shurui; // 근태 항목 종류 (Attendance Popup Test)

	// 휴가 현황 관련 항목 (Leave Status Test)
	private String kyuuka_shurui; // 휴가 항목
	private int kyuuka_nissuu; // 전체 휴가 일수
	private int shiyou_kyuuka_nissuu; // 사용 휴가 일수
	private int nokori_kyuuka_nissuu; // 잔여 휴가 일수
	
	 public AttendanceRecord() {
	    }
	 
	 public AttendanceRecord(int kintai_kiroku_id, int shain_id, int kintai_id, Date kintai_bi, int kinngaku, 
             int kintai_zikan, String bikou, String shain_name, String employment_type, 
             String department, String yakushoku, String kintai_shurui) {
this.kintai_kiroku_id = kintai_kiroku_id;
this.shain_id = shain_id;
this.kintai_id = kintai_id;
this.kintai_bi = kintai_bi;
this.kinngaku = kinngaku;
this.kintai_zikan = kintai_zikan;
this.bikou = bikou;
this.shain_name = shain_name;
this.employment_type = employment_type;
this.department = department;
this.yakushoku = yakushoku;
this.kintai_shurui = kintai_shurui;
}


	// Getters and Setters
	public int getKintai_kiroku_id() {
		return kintai_kiroku_id;
	}

	public void setKintai_kiroku_id(int kintai_kiroku_id) {
		this.kintai_kiroku_id = kintai_kiroku_id;
	}

	public int getShain_id() {
		return shain_id;
	}

	public void setShain_id(int shain_id) {
		this.shain_id = shain_id;
	}

	public int getKintai_id() {
		return kintai_id;
	}

	public void setKintai_id(int kintai_id) {
		this.kintai_id = kintai_id;
	}

	public Date getKintai_bi() {
		return kintai_bi;
	}

	public void setKintai_bi(Date kintai_bi) {
		this.kintai_bi = kintai_bi;
	}

	public int getKinngaku() {
		return kinngaku;
	}

	public void setKinngaku(int kinngaku) {
		this.kinngaku = kinngaku;
	}

	public int getKintai_zikan() {
		return kintai_zikan;
	}

	public void setKintai_zikan(int kintai_zikan) {
		this.kintai_zikan = kintai_zikan;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public String getShain_name() {
		return shain_name;
	}

	public void setShain_name(String shain_name) {
		this.shain_name = shain_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployment_type() {
		return employment_type;
	}

	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}

	public String getYakushoku() {
		return yakushoku;
	}

	public void setYakushoku(String yakushoku) {
		this.yakushoku = yakushoku;
	}

	public String getKintai_shurui() {
		return kintai_shurui;
	}

	public void setKintai_shurui(String kintai_shurui) {
		this.kintai_shurui = kintai_shurui;
	}

	public String getKyuuka_shurui() {
		return kyuuka_shurui;
	}

	public void setKyuuka_shurui(String kyuuka_shurui) {
		this.kyuuka_shurui = kyuuka_shurui;
	}

	public int getKyuuka_nissuu() {
		return kyuuka_nissuu;
	}

	public void setKyuuka_nissuu(int kyuuka_nissuu) {
		this.kyuuka_nissuu = kyuuka_nissuu;
	}

	public int getShiyou_kyuuka_nissuu() {
		return shiyou_kyuuka_nissuu;
	}

	public void setShiyou_kyuuka_nissuu(int shiyou_kyuuka_nissuu) {
		this.shiyou_kyuuka_nissuu = shiyou_kyuuka_nissuu;
	}

	public int getNokori_kyuuka_nissuu() {
		return nokori_kyuuka_nissuu;
	}

	public void setNokori_kyuuka_nissuu(int nokori_kyuuka_nissuu) {
		this.nokori_kyuuka_nissuu = nokori_kyuuka_nissuu;
	}
	
	@Override
	public String toString() {
	    return "AttendanceRecord{" +
	            "kintai_kiroku_id=" + kintai_kiroku_id +
	            ", shain_id=" + shain_id +
	            ", kintai_id=" + kintai_id +
	            ", kintai_bi=" + kintai_bi +
	            ", kinngaku=" + kinngaku +
	            ", kintai_zikan=" + kintai_zikan +
	            ", bikou='" + bikou + '\'' +
	            ", shain_name='" + shain_name + '\'' +
	            ", department='" + department + '\'' +
	            ", employment_type='" + employment_type + '\'' +
	            ", yakushoku='" + yakushoku + '\'' +
	            ", kintai_shurui='" + kintai_shurui + '\'' +
	            ", kyuuka_shurui='" + kyuuka_shurui + '\'' +
	            ", kyuuka_nissuu=" + kyuuka_nissuu +
	            ", shiyou_kyuuka_nissuu=" + shiyou_kyuuka_nissuu +
	            ", nokori_kyuuka_nissuu=" + nokori_kyuuka_nissuu +
	            '}';
	}

	private AttendanceRecord convertAttendanceRecord(ResultSet rs) throws SQLException {
	    return new AttendanceRecord(
	        rs.getInt("kintai_kiroku_ID"),
	        rs.getInt("shain_ID"),
	        rs.getInt("kintai_ID"),
	        rs.getDate("kintai_bi"),
	        rs.getInt("kinngaku"),
	        rs.getInt("kintai_zikan"),
	        rs.getString("bikou"),
	        rs.getString("shain_name"),
	        rs.getString("employment_type"),
	        rs.getString("department"),
	        rs.getString("yakushoku"),
	        rs.getString("kintai_shurui")
	    );
	}

	

}
