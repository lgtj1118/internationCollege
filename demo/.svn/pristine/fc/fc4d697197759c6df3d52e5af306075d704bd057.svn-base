package com.tjpu.test.unitTest;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @author ZhangChong

 * @date:2015-8-8 上午11:01:14
 * @version :1.0
 *
 */

public class jacob {
	/*public static void main(String[] args) {
		ComThread.InitSTA();
		ActiveXComponent xl = new ActiveXComponent("Excel.Application");
		try {
			// System.out.println("version=" + xl.getProperty("Version"));
			// 不打开文档
			Dispatch.put(xl, "Visible", new Variant(true));
			Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
			// 打开文档
			Dispatch excel = Dispatch.call(workbooks, "Open", "D:/txt.xls").toDispatch();
			// 开始打印
			Dispatch.get(excel, "PrintOut");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 始终释放资源
			ComThread.Release();
		}
	}*/
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        printWord("D:/txt.doc");
    //  printExcel("D:/提醒通知明细通用模板.xlsx");
    }
 
    public static void printExcel(String filePath) {
        /**
         * 功能:实现打印工作
         */
        ComThread.InitSTA();
        ActiveXComponent xl = new ActiveXComponent("Excel.Application");
        try {
            // System.out.println("version=" + xl.getProperty("Version"));
            // 不打开文档
            Dispatch.put(xl, "Visible", new Variant(true));
            Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
            // 打开文档
            Dispatch excel = Dispatch.call(workbooks, "Open", filePath).toDispatch();
            // 开始打印
            Dispatch.call(excel, "PrintOut");
            xl.invoke("Quit", new Variant[] {});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 始终释放资源
            ComThread.Release();
        }
    }
 
    public static void printWord(String filePath) {
        ComThread.InitSTA();
        ActiveXComponent wd = new ActiveXComponent("Word.Application");
        try {
            // 不打开文档
            Dispatch.put(wd, "Visible", new Variant(true));
            Dispatch document = wd.getProperty("Documents").toDispatch();
            // 打开文档
            Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method,
                    new Object[] { filePath }, new int[1]).toDispatch();
            // 开始打印
            Dispatch.callN(doc, "PrintOut");
            wd.invoke("Quit", new Variant[] {});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 始终释放资源
            ComThread.Release();
        }
    }
     
    // 获得文件后缀名
    public static String getPostfix(String inputFilePath) {
        String[] p = inputFilePath.split("\\.");
        if (p.length > 0) {// 判断文件有无扩展名
            // 比较文件扩展名
            return p[p.length - 1];
        } else {
            return null;
        }
    }
 
}

