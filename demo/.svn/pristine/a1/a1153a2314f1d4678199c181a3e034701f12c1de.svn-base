package com.tjpu.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.*;
import jxl.read.biff.BiffException;

public class LoadExcel {
	public static void main(String[] args) {
		String filePath = "E:/AA.xls";
		try {
			Workbook wb = Workbook.getWorkbook(new File(filePath));
			Sheet[] sheets = wb.getSheets();
			for (Sheet sheet : sheets) {
				int ROWS = sheet.getRows();
				int COLS = sheet.getColumns();
				for (int r = 0; r < ROWS; ++r) {
					List<String> items = new ArrayList<String>();
					for (int c = 0; c < COLS; ++c) {
						Cell cell = sheet.getCell(c, r);
						items.add(cell.getContents());
					}
				}

			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
