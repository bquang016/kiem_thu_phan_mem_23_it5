package com.example.kiem_thu_phan_mem_23_it5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // ============================================================================
    // PHẦN 1: DECISION TABLE TESTING (DT) - 10 Test Cases
    // Bao phủ TẤT CẢ các rule nghiệp vụ có thể xảy ra
    // ============================================================================

    @Test
    @DisplayName("DT-Rule1: Input = NULL -> Kết quả = 0")
    public void testDT_Rule1_InputNull() {
        assertAll("Xử lý NULL",
                () -> assertEquals(0, analyzer.countExcellentStudents(null),
                        "countExcellentStudents(null) phải trả về 0"),
                () -> assertEquals(0.0, analyzer.calculateValidAverage(null), 0.001,
                        "calculateValidAverage(null) phải trả về 0.0")
        );
    }

    @Test
    @DisplayName("DT-Rule2: Input = EMPTY -> Kết quả = 0")
    public void testDT_Rule2_InputEmpty() {
        assertAll("Xử lý danh sách rỗng",
                () -> assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()),
                        "countExcellentStudents([]) phải trả về 0"),
                () -> assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001,
                        "calculateValidAverage([]) phải trả về 0.0")
        );
    }

    @Test
    @DisplayName("DT-Rule3: Toàn INVALID -> Count=0, Avg=0.0")
    public void testDT_Rule3_AllInvalid() {
        List<Double> scores = Arrays.asList(-5.0, 15.0, -0.001, 10.001, 100.0);
        assertAll("Danh sách toàn invalid (tránh chia cho 0)",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Không có phần tử valid -> count = 0"),
                () -> assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001,
                        "Không có phần tử valid -> average = 0.0")
        );
    }

    @Test
    @DisplayName("DT-Rule4: Toàn VALID nhưng KHÔNG CÓ AI GIỎI -> Count=0, Avg>0")
    public void testDT_Rule4_AllValidNoExcellent() {
        List<Double> scores = Arrays.asList(3.0, 5.5, 7.0, 7.99);
        assertAll("Toàn valid nhưng không ai đạt >= 8.0",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Không có ai >= 8.0 -> count = 0"),
                () -> assertEquals(5.8725, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (3+5.5+7+7.99)/4 = 5.8725")
        );
    }

    @Test
    @DisplayName("DT-Rule5: Toàn VALID và TOÀN GIỎI -> Count=size, Avg>=8.0")
    public void testDT_Rule5_AllValidAllExcellent() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0, 8.5);
        assertAll("Toàn valid và toàn giỏi",
                () -> assertEquals(4, analyzer.countExcellentStudents(scores),
                        "Tất cả >= 8.0 -> count = 4"),
                () -> assertEquals(8.875, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (8+9+10+8.5)/4 = 8.875")
        );
    }

    @Test
    @DisplayName("DT-Rule6: Toàn VALID, CÓ GIỎI + KHÔNG GIỎI -> 0<Count<size")
    public void testDT_Rule6_AllValidMixedExcellence() {
        List<Double> scores = Arrays.asList(5.0, 8.0, 7.0, 9.5);
        assertAll("Mix giỏi và không giỏi",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "Có 2 người >= 8.0 (8.0 và 9.5)"),
                () -> assertEquals(7.375, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (5+8+7+9.5)/4 = 7.375")
        );
    }

    @Test
    @DisplayName("DT-Rule7: INVALID + VALID KHÔNG GIỎI -> Count=0, Avg chỉ tính valid")
    public void testDT_Rule7_MixedInvalidValidNoExcellent() {
        List<Double> scores = Arrays.asList(-10.0, 5.0, 20.0, 7.0, -1.0);
        assertAll("Mix invalid và valid không giỏi",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Không ai >= 8.0 -> count = 0"),
                () -> assertEquals(6.0, analyzer.calculateValidAverage(scores), 0.001,
                        "Average chỉ tính 5.0 và 7.0 -> (5+7)/2 = 6.0")
        );
    }

    @Test
    @DisplayName("DT-Rule8: INVALID + VALID GIỎI -> Count>0, Avg chỉ tính valid")
    public void testDT_Rule8_MixedInvalidValidWithExcellent() {
        List<Double> scores = Arrays.asList(-10.0, 9.0, 20.0, 8.5, 5.0);
        assertAll("Mix invalid và valid có giỏi",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "Có 2 người giỏi (9.0 và 8.5)"),
                () -> assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (9+8.5+5)/3 = 7.5")
        );
    }

    @Test
    @DisplayName("DT-Rule9: 1 PHẦN TỬ VALID GIỎI -> Count=1, Avg=chính nó")
    public void testDT_Rule9_SingleValidExcellent() {
        List<Double> scores = Arrays.asList(8.5);
        assertAll("Danh sách 1 phần tử giỏi",
                () -> assertEquals(1, analyzer.countExcellentStudents(scores)),
                () -> assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.001)
        );
    }

    @Test
    @DisplayName("DT-Rule10: 1 PHẦN TỬ VALID KHÔNG GIỎI -> Count=0, Avg=chính nó")
    public void testDT_Rule10_SingleValidNotExcellent() {
        List<Double> scores = Arrays.asList(5.0);
        assertAll("Danh sách 1 phần tử không giỏi",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores)),
                () -> assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001)
        );
    }

    // ============================================================================
    // PHẦN 2: BOUNDARY VALUE ANALYSIS (BVA) - 12 Test Cases
    // Kiểm tra TẤT CẢ các biên: Data values + Structural boundaries
    // ============================================================================

    // --- 2.1: BIÊN DATA VALUES cho countExcellentStudents ---

    @Test
    @DisplayName("BVA-Data1: Min valid = 0.0 (ON-POINT dưới)")
    public void testBVA_Data1_MinValidZero() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)),
                "Điểm 0.0 là valid nhưng không giỏi");
    }

    @Test
    @DisplayName("BVA-Data2: Just below min = -0.000001 (OFF-POINT dưới)")
    public void testBVA_Data2_JustBelowMin() {
        List<Double> scores = Arrays.asList(-0.000001, 8.5);
        assertEquals(1, analyzer.countExcellentStudents(scores),
                "Điểm âm bị lọc, chỉ tính 8.5");
    }

    @Test
    @DisplayName("BVA-Data3: Just below threshold = 7.999999 (OFF-POINT ngưỡng)")
    public void testBVA_Data3_JustBelowThreshold() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.999999)),
                "7.999999 < 8.0 -> không giỏi");
    }

    @Test
    @DisplayName("BVA-Data4: Exact threshold = 8.0 (ON-POINT ngưỡng)")
    public void testBVA_Data4_ExactThreshold() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)),
                "8.0 đúng bằng ngưỡng -> giỏi");
    }

    @Test
    @DisplayName("BVA-Data5: Just above threshold = 8.000001 (OFF-POINT ngưỡng)")
    public void testBVA_Data5_JustAboveThreshold() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.000001)),
                "8.000001 > 8.0 -> giỏi");
    }

    @Test
    @DisplayName("BVA-Data6: Max valid = 10.0 (ON-POINT trên)")
    public void testBVA_Data6_MaxValid() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)),
                "Điểm 10.0 là valid và giỏi");
    }

    @Test
    @DisplayName("BVA-Data7: Just above max = 10.000001 (OFF-POINT trên)")
    public void testBVA_Data7_JustAboveMax() {
        List<Double> scores = Arrays.asList(10.000001, 8.5);
        assertEquals(1, analyzer.countExcellentStudents(scores),
                "Điểm >10 bị lọc, chỉ tính 8.5");
    }

    // --- 2.2: BIÊN DATA VALUES cho calculateValidAverage ---

    @Test
    @DisplayName("BVA-Data8: Average với min và max valid (0.0, 10.0)")
    public void testBVA_Data8_AverageMinMax() {
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.001,
                "Average của 0.0 và 10.0 = 5.0");
    }

    @Test
    @DisplayName("BVA-Data9: Average lọc các giá trị ngoài biên")
    public void testBVA_Data9_AverageFilterOutOfBounds() {
        List<Double> scores = Arrays.asList(-0.1, 5.0, 10.1, 7.0);
        assertEquals(6.0, analyzer.calculateValidAverage(scores), 0.001,
                "Chỉ tính 5.0 và 7.0 -> (5+7)/2 = 6.0");
    }

    // --- 2.3: BIÊN STRUCTURAL (Kích thước danh sách) ---

    @Test
    @DisplayName("BVA-Struct1: Size = 0 (Empty)")
    public void testBVA_Struct1_SizeZero() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()),
                "List rỗng -> count = 0");
    }

    @Test
    @DisplayName("BVA-Struct2: Size = 1 (Minimum non-empty)")
    public void testBVA_Struct2_SizeOne() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(9.0)),
                "List 1 phần tử giỏi -> count = 1");
    }

    @Test
    @DisplayName("BVA-Struct3: Size lớn (Performance test với 1000 phần tử)")
    public void testBVA_Struct3_LargeSize() {
        // Tạo list 1000 phần tử: 500 giỏi (8.0-10.0), 500 không giỏi (0.0-7.9)
        Double[] scores = new Double[1000];
        for (int i = 0; i < 500; i++) {
            scores[i] = 8.0 + (i % 3); // 8.0, 9.0, 10.0 lặp lại
        }
        for (int i = 500; i < 1000; i++) {
            scores[i] = 0.0 + (i % 8); // 0.0 đến 7.0
        }

        List<Double> scoreList = Arrays.asList(scores);

        long startTime = System.currentTimeMillis();
        int result = analyzer.countExcellentStudents(scoreList);
        long endTime = System.currentTimeMillis();

        assertAll("Performance test với 1000 phần tử",
                () -> assertEquals(500, result, "Phải đếm đúng 500 sinh viên giỏi"),
                () -> assertTrue(endTime - startTime < 100,
                        "Phải xử lý < 100ms (Actual: " + (endTime - startTime) + "ms)")
        );
    }

    // ============================================================================
    // PHẦN 3: EQUIVALENCE PARTITIONING (EP) - 10 Test Cases
    // Kiểm tra TỪNG LỚP riêng biệt + Kết hợp + Edge cases đặc biệt
    // ============================================================================

    // --- 3.1: Test TỪNG LỚP riêng biệt ---

    @Test
    @DisplayName("EP-Class1: Chỉ có INVALID LOW (< 0)")
    public void testEP_Class1_OnlyInvalidLow() {
        List<Double> scores = Arrays.asList(-1.0, -5.0, -10.0, -100.0);
        assertAll("Lớp Invalid Low",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Toàn số âm -> count = 0"),
                () -> assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001,
                        "Toàn số âm -> average = 0.0")
        );
    }

    @Test
    @DisplayName("EP-Class2: Chỉ có VALID NORMAL (0.0 <= x < 8.0)")
    public void testEP_Class2_OnlyValidNormal() {
        List<Double> scores = Arrays.asList(0.0, 3.5, 5.0, 7.5, 7.99);
        assertAll("Lớp Valid Normal",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Không ai >= 8.0 -> count = 0"),
                () -> assertEquals(4.798, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (0+3.5+5+7.5+7.99)/5 = 4.798")
        );
    }

    @Test
    @DisplayName("EP-Class3: Chỉ có VALID EXCELLENT (8.0 <= x <= 10.0)")
    public void testEP_Class3_OnlyValidExcellent() {
        List<Double> scores = Arrays.asList(8.0, 8.5, 9.0, 9.5, 10.0);
        assertAll("Lớp Valid Excellent",
                () -> assertEquals(5, analyzer.countExcellentStudents(scores),
                        "Tất cả >= 8.0 -> count = 5"),
                () -> assertEquals(9.0, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (8+8.5+9+9.5+10)/5 = 9.0")
        );
    }

    @Test
    @DisplayName("EP-Class4: Chỉ có INVALID HIGH (> 10.0)")
    public void testEP_Class4_OnlyInvalidHigh() {
        List<Double> scores = Arrays.asList(10.1, 15.0, 20.0, 100.0);
        assertAll("Lớp Invalid High",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores),
                        "Toàn số >10 -> count = 0"),
                () -> assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001,
                        "Toàn số >10 -> average = 0.0")
        );
    }

    // --- 3.2: Test KẾT HỢP 2 lớp ---

    @Test
    @DisplayName("EP-Combo1: Class1 (Invalid Low) + Class2 (Valid Normal)")
    public void testEP_Combo1_InvalidLow_ValidNormal() {
        List<Double> scores = Arrays.asList(-5.0, 3.0, -2.0, 6.0);
        assertAll("Kết hợp Invalid Low + Valid Normal",
                () -> assertEquals(0, analyzer.countExcellentStudents(scores)),
                () -> assertEquals(4.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Chỉ tính 3.0 và 6.0 -> (3+6)/2 = 4.5")
        );
    }

    @Test
    @DisplayName("EP-Combo2: Class2 (Valid Normal) + Class3 (Valid Excellent)")
    public void testEP_Combo2_ValidNormal_ValidExcellent() {
        List<Double> scores = Arrays.asList(5.0, 8.5, 7.0, 9.5);
        assertAll("Kết hợp Valid Normal + Valid Excellent",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "Có 2 người giỏi: 8.5 và 9.5"),
                () -> assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (5+8.5+7+9.5)/4 = 7.5")
        );
    }

    @Test
    @DisplayName("EP-Combo3: Class3 (Valid Excellent) + Class4 (Invalid High)")
    public void testEP_Combo3_ValidExcellent_InvalidHigh() {
        List<Double> scores = Arrays.asList(9.0, 15.0, 8.0, 20.0);
        assertAll("Kết hợp Valid Excellent + Invalid High",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores)),
                () -> assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Chỉ tính 9.0 và 8.0 -> (9+8)/2 = 8.5")
        );
    }

    // --- 3.3: Test EDGE CASES đặc biệt ---

    @Test
    @DisplayName("EP-Edge1: Giá trị NaN (Not a Number)")
    public void testEP_Edge1_NaN() {
        List<Double> scores = Arrays.asList(8.5, Double.NaN, 9.0);
        assertAll("Xử lý NaN",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "NaN nên bị lọc, chỉ tính 8.5 và 9.0"),
                () -> assertEquals(8.75, analyzer.calculateValidAverage(scores), 0.001,
                        "NaN bị lọc -> (8.5+9)/2 = 8.75")
        );
    }

    @Test
    @DisplayName("EP-Edge2: Giá trị Infinity")
    public void testEP_Edge2_Infinity() {
        List<Double> scores = Arrays.asList(8.0, Double.POSITIVE_INFINITY,
                Double.NEGATIVE_INFINITY, 9.0);
        assertAll("Xử lý Infinity",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "Infinity bị lọc, chỉ tính 8.0 và 9.0"),
                () -> assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Infinity bị lọc -> (8+9)/2 = 8.5")
        );
    }

    @Test
    @DisplayName("EP-Mixed: Tất cả 4 lớp + Edge cases trong 1 test")
    public void testEP_MixedAllClassesAndEdges() {
        List<Double> scores = Arrays.asList(
                -10.0,              // EC1: Invalid Low
                5.0, 7.0,           // EC2: Valid Normal
                8.5, 9.5,           // EC3: Valid Excellent
                20.0,               // EC4: Invalid High
                Double.NaN,         // Edge: NaN
                Double.POSITIVE_INFINITY  // Edge: Infinity
        );

        assertAll("Test tổng hợp tất cả trường hợp",
                () -> assertEquals(2, analyzer.countExcellentStudents(scores),
                        "Chỉ có 8.5 và 9.5 là giỏi"),
                () -> assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001,
                        "Average = (5+7+8.5+9.5)/4 = 7.5")
        );
    }

    // ============================================================================
    // PHẦN 4: INTEGRATION & STRESS TESTS (BONUS)
    // ============================================================================

    @Test
    @DisplayName("BONUS: Test tính nhất quán giữa 2 methods")
    public void testBonus_ConsistencyBetweenMethods() {
        List<Double> scores = Arrays.asList(5.0, 8.0, 9.0, 10.0, 3.0);

        int excellentCount = analyzer.countExcellentStudents(scores);
        double average = analyzer.calculateValidAverage(scores);

        assertAll("Kiểm tra logic nhất quán",
                () -> assertEquals(3, excellentCount, "Có 3 người giỏi"),
                () -> assertEquals(7.0, average, 0.001, "Average = 7.0"),
                () -> assertTrue(excellentCount > 0,
                        "Nếu avg >= 8 thì phải có ít nhất 1 người giỏi (logic nghiệp vụ)")
        );
    }

    @Test
    @DisplayName("BONUS: Stress test với giá trị thập phân rất dài")
    public void testBonus_LongDecimalPrecision() {
        List<Double> scores = Arrays.asList(
                7.999999999999999,  // Không giỏi (sát biên)
                8.000000000000001,  // Giỏi (vượt biên tí)
                9.123456789012345   // Giỏi
        );

        assertEquals(2, analyzer.countExcellentStudents(scores),
                "Phải xử lý chính xác độ chính xác thập phân");
    }
}
