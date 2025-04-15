import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReporter extends TestListenerAdapter {
    private List<Map<String, String>> testResults = new ArrayList<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        recordResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        recordResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        recordResult(result, "SKIPPED");
    }

    private void recordResult(ITestResult result, String status) {
        Map<String, String> testResult = new HashMap<>();
        testResult.put("Test Name", result.getMethod().getMethodName());
        testResult.put("Status", status);
        testResult.put("Class", result.getTestClass().getName());
        testResults.add(testResult);
    }

    @Override
    public void onFinish(ITestContext context) {
        writeResultsToExcel("TestNG_Report.xlsx");
    }

    private void writeResultsToExcel(String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Test Results");
            Row header = sheet.createRow(0);
            String[] columns = {"Test Name", "Status", "Class"};

            for (int i = 0; i < columns.length; i++) {
                header.createCell(i).setCellValue(columns[i]);
            }

            int rowIndex = 1;
            for (Map<String, String> result : testResults) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(result.get("Test Name"));
                row.createCell(1).setCellValue(result.get("Status"));
                row.createCell(2).setCellValue(result.get("Class"));
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("✅ Excel report exported to: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
