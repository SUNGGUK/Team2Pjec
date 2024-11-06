package menu.payroll.PayrollLedger.Model;

import java.math.BigDecimal;

public class PayrollLedgerInfo {
    private int salaryRound;       // 급여 차수 (給与回数)
    private String yearMonth;      // 귀속 연월 (帰属年月)
    private BigDecimal totalSalary; // 지급 총액 (支給総額)
    private BigDecimal totalDeduction; // 공제 총액 (控除総額)
    private BigDecimal netPayment;  // 실지급액 (実支給額)
    private int employeesCount;     // 인원 수 (人数)

    // Getter 및 Setter 메서드 (ゲッターおよびセッター)
    public int getSalaryRound() { return salaryRound; } // 급여 차수 반환 (給与回数を返す)
    public void setSalaryRound(int salaryRound) { this.salaryRound = salaryRound; } // 급여 차수 설정 (給与回数を設定する)

    public String getYearMonth() { return yearMonth; } // 귀속 연월 반환 (帰属年月を返す)
    public void setYearMonth(String yearMonth) { this.yearMonth = yearMonth; } // 귀속 연월 설정 (帰属年月を設定する)

    public BigDecimal getTotalSalary() { return totalSalary; } // 지급 총액 반환 (支給総額を返す)
    public void setTotalSalary(BigDecimal totalSalary) { this.totalSalary = totalSalary; } // 지급 총액 설정 (支給総額を設定する)

    public BigDecimal getTotalDeduction() { return totalDeduction; } // 공제 총액 반환 (控除総額を返す)
    public void setTotalDeduction(BigDecimal totalDeduction) { this.totalDeduction = totalDeduction; } // 공제 총액 설정 (控除総額を設定する)

    public BigDecimal getNetPayment() { return netPayment; } // 실지급액 반환 (実支給額を返す)
    public void setNetPayment(BigDecimal netPayment) { this.netPayment = netPayment; } // 실지급액 설정 (実支給額を設定する)

    public int getEmployeesCount() { return employeesCount; } // 인원 수 반환 (人数を返す)
    public void setEmployeesCount(int employeesCount) { this.employeesCount = employeesCount; } // 인원 수 설정 (人数を設定する)
}
