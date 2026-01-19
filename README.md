# HỌC PHẦN: KIỂM THỬ PHẦN MỀM

## Giảng viên hướng dẫn
- Trương Anh Hoàng

## Thông tin sinh viên
- **Họ và tên:** Bùi Đăng Quang  
- **MSSV:** BIT230345
- **Lớp:** SOFT5
- **Email cá nhân:** buidangquangmtp@gmail.com

---

## TUẦN 1

### Bài tập 1: Can't Unsee (https://cantunsee.space)
- **Ngày nộp:** 05/01/2026  
- **Trạng thái:** Hoàn thành  
- **Số điểm:** 6420  

#### Minh chứng kết quả
<img width="1919" height="1079" alt="Kết quả bài tập Cantusee" src="https://github.com/user-attachments/assets/da5e5d49-13ab-4234-a986-af4955a29453" />

---

### Bài tập 2: StudentAnalyzer
- **Ngày nộp:** 07/01/2026  
- **Trạng thái:** Hoàn thành  

#### Công nghệ sử dụng
- **Ngôn ngữ lập trình:** Java  
- **Công cụ xây dựng dự án:** Maven  
- **Thư viện kiểm thử:** JUnit  

#### Quy trình thực hiện
1. Sử dụng Java và Maven để khai báo và thêm thư viện JUnit.
2. Xây dựng lớp `StudentAnalyzer` để xử lý dữ liệu.
3. Tạo lớp kiểm thử `StudentAnalyzerTest`.
4. Xây dựng các ca kiểm thử cho từng phương thức trong lớp kiểm thử.
5. Thực thi các ca kiểm thử và kiểm tra kết quả.
6. Đẩy toàn bộ mã nguồn lên GitHub để quản lý phiên bản.

#### Hướng dẫn chạy dự án:
### Yêu cầu môi trường:
Để chạy và kiểm thử dự án, cần đảm bảo môi trường đáp ứng các yêu cầu sau:
- Java JDK phiên bản 17 trở lên
- Maven đã được cài đặt và cấu hình
- IDE hỗ trợ Java (Visual Studio Code, IntelliJ IDEA hoặc Eclipse)

### Cách sử dụng và chạy kiểm thử
1. Clone repository từ GitHub về máy:
 ``` git clone https://github.com/bquang016/kiem_thu_phan_mem_23_it5  ```
2. Mở thư mục dự án bằng IDE hoặc terminal.
3. Kiểm tra và đảm bảo Maven đã tải đầy đủ các thư viện phụ thuộc.
4. Thực thi các ca kiểm thử bằng một trong các cách sau:
- Chạy trực tiếp lớp `StudentAnalyzerTest` trong IDE.
- Hoặc chạy bằng Maven với lệnh:
  ```
  mvn test
  ```
5. Quan sát kết quả kiểm thử hiển thị trên cửa sổ Test của IDE hoặc trên terminal.

### Kết quả mong đợi
- Tất cả các ca kiểm thử được thực thi thành công.
- Các phương thức trong lớp `StudentAnalyzer` hoạt động đúng theo yêu cầu đề bài.
- Không xuất hiện lỗi logic hoặc lỗi kiểm thử trong quá trình chạy.


---


## TUẦN 2

### Bài tập 3: Thực hành kiểm thử tự động End-to-End với Cypress
- **Ngày nộp:** 14/01/2026  
- **Trạng thái:** Hoàn thành  

#### Công nghệ sử dụng
- **Ngôn ngữ lập trình:** JavaScript (Node.js)  
- **Framework kiểm thử:** Cypress  
- **Website đối tượng:** [SauceDemo](https://www.saucedemo.com)  
- **Công cụ soạn thảo:** IntelliJ IDE 

#### Quy trình thực hiện
1. Khởi tạo dự án Node.js và cài đặt thư viện Cypress.
2. Cấu hình môi trường và tạo cấu trúc thư mục E2E (`cypress/e2e`).
3. Xây dựng các kịch bản kiểm thử (Test Scripts):
   - **Login Test:** Kiểm tra đăng nhập thành công và xử lý lỗi khi sai thông tin.
   - **Cart & Sort Test:** Kiểm tra thêm/xóa sản phẩm vào giỏ hàng và chức năng sắp xếp giá.
   - **Checkout Test:** Kiểm tra luồng thanh toán từ giỏ hàng đến trang xác nhận.
4. Thực thi kiểm thử trên trình duyệt (Chrome) và xác minh kết quả.

#### Hướng dẫn chạy kiểm thử
### Yêu cầu môi trường:
- Node.js (phiên bản 14 trở lên)
- Trình duyệt Chrome hoặc Edge

### Cách sử dụng và chạy:
1. Mở terminal tại thư mục chứa bài tập Cypress (`cypress-exercise`):
   ```bash
   cd cypress-exercise
2. Cài đặt các thư viện phụ thuộc (nếu clone về máy mới):
   ```bash
   npm install
3. Mở giao diện Cypress Runner:
   ```bash
   npx cypress open
4. Chọn E2E Testing -> Chọn trình duyệt -> Chọn file kịch bản (login_spec.cy.js, cart_spec.cy.js, hoặc checkout_spec.cy.js) để chạy.

### Minh chứng kết quả
### cart_spec.cy.js:
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/9ae18f09-b6f0-4c45-aa6f-e3a010c16209" />

### checkout_spec.cy.js:
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/0249266a-6865-458f-98fb-291b25fe5380" />

### login_spec.cy.js:
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/c84d2ab8-c19c-4629-8a1e-876cd81a857e" />

### Mô tả ngắn gọn về các ca kiểm thử tự động bằng Cypress đã làm:
- login_spec.cy.js: Kiểm thử chức năng xác thực người dùng, bao gồm trường hợp đăng nhập thành công (chuyển hướng đúng trang) và đăng nhập thất bại (hiển thị thông báo lỗi khi sai thông tin).

- cart_spec.cy.js: Kiểm thử các thao tác với danh sách sản phẩm, bao gồm thêm/xóa sản phẩm trong giỏ hàng và chức năng sắp xếp (Sort) sản phẩm theo giá từ thấp đến cao.

- checkout_spec.cy.js: Kiểm thử luồng thanh toán End-to-End, mô phỏng hành trình người dùng từ lúc chọn hàng, điền thông tin cá nhân đến khi chuyển sang trang xác nhận đơn hàng.


---
## TUẦN 3
### Bài tập 4: Áp dụng các kỹ thuật kiểm thử hộp đen (Black-box Testing) và đo độ bao phủ kiểm thử bằng công cụ JaCoCo.
- **Ngày nộp:** 19/01/2026
- **Trạng thái:** Hoàn thành
#### Công nghệ sử dụng
- **Ngôn ngữ lập trình:** Java
- **Framework:** JUnit 5
- **Công cụ đo độ bao phủ:** JaCoCo (Java Code Coverage)
- **Công cụ xây dựng dự án:** Maven
#### Quy trình thực hiện
**Nâng cấp bộ kiểm thử cho StudentAnalyzer áp dụng 3 kỹ thuật chuyên sâu:**
1. DT với JUnit (Decision Table Testing):
- Tự kiểm tra thừa/thiếu ca kiểm thử với kỹ thuật bảng quyết định.
- Đã xây dựng 10 Test Cases bao phủ toàn bộ các luật (Rules) nghiệp vụ.
- Xử lý các tổ hợp điều kiện: Null list, Empty list, List chứa valid/invalid/excellent scores.
2. BVA với JUnit (Boundary Value Analysis):
- Tự kiểm tra thừa/thiếu ca kiểm thử với kỹ thuật giá trị biên.
- Biên dữ liệu (Data Boundary): Kiểm tra các giá trị tại ngưỡng (7.999..., 8.0, 8.000...1), biên Max/Min (0.0, 10.0).
- Biên cấu trúc (Structural Boundary): Kiểm tra size = 0, size = 1, và size lớn (1000 phần tử).
3. EP với JUnit (Equivalence Partitioning):
- Tự kiểm tra thừa/thiếu ca kiểm thử với kỹ thuật phân hoạch lớp tương đương.
- Chia miền dữ liệu thành các lớp: Invalid Low (<0), Valid Normal (0-7.9), Valid Excellent (8-10), Invalid High (>10).
- Bổ sung các Edge cases đặc biệt: NaN, Infinity.

### Kết quả đo độ bao phủ kiểm thử với JaCoCo:
- Câu lệnh thực thi: ``` mvn clean test jacoco:report ```
- Độ bao phủ dòng lệnh (Line Coverage): 100%
- Branch Coverage: Đảm bảo mọi nhánh rẽ if/else đều được kiểm tra cả 2 chiều (True/False).
#### Minh chứng kết quả
##### Báo cáo độ bao phủ Code (JaCoCo Report):
<img width="1084" height="178" alt="image" src="https://github.com/user-attachments/assets/1e80e41b-7c58-4dba-9d21-9f95fb26df0a" />
