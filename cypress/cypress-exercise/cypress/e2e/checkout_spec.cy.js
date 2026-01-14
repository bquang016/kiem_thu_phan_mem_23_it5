describe('Checkout Process Test', () => {
    it('Should complete the checkout flow up to step two', () => {
        // 1. Đăng nhập
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // 2. Thêm sản phẩm vào giỏ
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // 3. Đi đến trang giỏ hàng
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html'); // Kiểm tra chắc chắn đã vào giỏ hàng

        // 4. Nhấn nút Checkout
        cy.get('#checkout').click();
        cy.url().should('include', '/checkout-step-one.html');

        // 5. Điền thông tin (First Name, Last Name, Zip)
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');

        // 6. Nhấn Continue
        cy.get('#continue').click();

        // 7. Xác minh chuyển hướng đến trang xác nhận (Step Two)
        cy.url().should('include', '/checkout-step-two.html');

        // (Optional) Kiểm tra tiêu đề trang là "Checkout: Overview"
        cy.get('.title').should('have.text', 'Checkout: Overview');
    });
});