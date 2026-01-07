package com.example.kiem_thu_phan_mem_23_it5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.example.kiem_thu_phan_mem_23_it5.StudentAnalyzer;
public class StudentAnalyzerTest {

    // Test cho hàm đếm học sinh giỏi
    @Test
    public void testCountExcellentStudents() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Case 1: Bình thường (có giỏi, có dở, có điểm sai)
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));

        // Case 2: Danh sách rỗng
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));

        // Case 3: Toàn điểm giỏi
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.5, 10.0)));

        // Case 4: Không có học sinh giỏi
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(5.0, 6.5, 7.9)));
    }

    // Test cho hàm tính trung bình
    @Test
    public void testCalculateValidAverage() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Case 1: Bình thường (bỏ qua 11.0 và -1.0 -> còn 9.0, 8.5, 7.0. TB = 24.5 / 3 = 8.166...)
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);

        // Case 2: Danh sách rỗng
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);

        // Case 3: Danh sách toàn điểm sai
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-5.0, 15.0)), 0.01);
    }
}