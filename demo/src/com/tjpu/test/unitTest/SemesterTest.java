/**
 * 2015
 * 2015-7-30
 * Administrator
 */
package com.tjpu.test.unitTest;
/**
 * @author ZhangChong

 * @date:2015-7-30 下午12:24:06
 * @version :1.0
 *
 */
/**
 * @author Administrator
 *
 */
public class SemesterTest {
	public static void main(String[] args) {
		String semesters[] = new String[] {"201501","201502","201601"};
		String semesterOrder[] = new String[semesters.length];
		semesterOrder[0] = semesters[0];
		int size = semesters.length;
		if (semesters.length % 2 == 0) {
			size--;
			semesterOrder[size] = semesters[size];
		}
	
		int offset = 1;
		for (int i = 1; i < size; ++i) {
			semesterOrder[i] = semesters[i + offset];
			if (offset > 0) {
				offset -= 2;
			} else {
				offset += 2;
			}
		}
		System.out.println(semesterOrder);
	}
}
