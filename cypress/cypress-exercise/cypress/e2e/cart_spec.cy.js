describe('Cart & Sorting Test', () => {
    // Đăng nhập trước mỗi bài test
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    // Kịch bản 3: Thêm sản phẩm
    it('Should add a product to the cart', () => {
        // Click nút Add to cart của sản phẩm đầu tiên
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        // Kiểm tra badge giỏ hàng hiện số 1
        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    // Kịch bản 4: Sắp xếp sản phẩm
    it('Should sort products by price low to high', () => {
        cy.get('.product_sort_container').select('lohi'); // lohi = Low to High
        // Kiểm tra giá sản phẩm đầu tiên là $7.99
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });

    // --- YÊU CẦU BỔ SUNG 1: Xóa sản phẩm khỏi giỏ hàng ---
    it('Should remove a product from the cart', () => {
        // 1. Thêm sản phẩm vào trước
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('exist'); // Đảm bảo đã thêm

        // 2. Nhấn nút "Remove" (Nút Add đổi thành Remove sau khi click)
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // 3. Xác minh biểu tượng số lượng không còn tồn tại
        cy.get('.shopping_cart_badge').should('not.exist');
    });
});