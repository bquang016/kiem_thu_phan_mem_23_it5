describe('Login Test', () => {
    // Chạy trước mỗi test case để tránh lặp lại code
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
    });

    // Kịch bản 1: Đăng nhập thành công
    it('Should login successfully with valid credentials', () => {
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // Assertion (Kiểm tra kết quả)
        cy.url().should('include', '/inventory.html');
    });

    // Kịch bản 2: Đăng nhập thất bại
    it('Should show error message with invalid credentials', () => {
        cy.get('#user-name').type('invalid_user');
        cy.get('#password').type('wrong_password');
        cy.get('#login-button').click();

        // Assertion thông báo lỗi
        cy.get('.error-message-container').should('contain', 'Username and password do not match');
    });
});