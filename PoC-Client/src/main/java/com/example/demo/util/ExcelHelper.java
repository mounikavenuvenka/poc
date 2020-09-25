package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Job;
import com.example.demo.entity.User;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "availability", "country", "experience", "job_description", "job_title",
			"pay_rate", "reply_rate", "skills", "state", "user_name_id", "job_type", "language" };

	static String SHEET = "Worksheet";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Job> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Job> jobs = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Job job = new Job();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						job.setId((int) currentCell.getNumericCellValue());
						break;

					case 1:
						job.setAvailability(currentCell.getStringCellValue());
						break;

					case 2:
						job.setCountry(currentCell.getStringCellValue());
						break;

					case 3:
						job.setExperience((int) currentCell.getNumericCellValue());
						break;
					case 4:
						job.setJobDescription(currentCell.getStringCellValue());
						break;
					case 5:
						job.setJobTitle(currentCell.getStringCellValue());
						break;
					case 6:
						job.setPayRate((int) currentCell.getNumericCellValue());
						break;
					case 7:
						job.setReplyRate((int) currentCell.getNumericCellValue());
						break;
					case 8:
						job.setSkills(currentCell.getStringCellValue());
						break;
					case 9:
						job.setState(currentCell.getStringCellValue());
						break;
					case 10:
						User user = new User();
						int id = (int) currentCell.getNumericCellValue();
						user.setId(id);
						job.setUserName(user);
						break;
					case 11:
						job.setJobType(currentCell.getStringCellValue());
						break;
					case 12:
						job.setLanguage(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}
				jobs.add(job);
			}

			workbook.close();

			return jobs;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}