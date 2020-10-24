import org.junit.Test;
import static org.junit.Assert.*;
public class PayrollTest {
    @Test
    public void testPayroll1() {
        Payroll pr = new Payroll();
        pr.readPayrollInfo("payroll.dat");
        assertEquals(6, pr.numOvertime());
    }
    @Test
    public void testPayroll2() {
        Payroll pr = new Payroll();
        pr.readPayrollInfo("payroll2.dat");
        assertEquals(0, pr.numOvertime());
    }
}
