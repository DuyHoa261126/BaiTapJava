package ex7;

import java.util.Date;

public class TestTheDiscountSystem {
    public static void main(String[] args) {
        // Tạo khách hàng không phải thành viên
        Customer customer1 = new Customer("Nguyen Van A");
        System.out.println(customer1); // Kiểm tra thông tin khách hàng

        // Tạo khách hàng thành viên
        Customer customer2 = new Customer("Tran Thi B");
        customer2.setMember(true);
        customer2.setMemberType("Gold");
        System.out.println(customer2); // Kiểm tra thông tin khách hàng

        // Kiểm tra Visit cho khách hàng không phải thành viên
        Visit visit1 = new Visit("Nguyen Van A", new Date());
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);
        System.out.println(visit1); // Tổng chi phí không giảm giá

        // Kiểm tra Visit cho khách hàng thành viên
        Visit visit2 = new Visit("Tran Thi B", new Date());
        visit2.setServiceExpense(200);
        visit2.setProductExpense(100);
        customer2.setMember(true);
        customer2.setMemberType("Gold");
        System.out.println(visit2); // Tổng chi phí sau giảm giá

        // Kiểm tra mức giảm giá từ DiscountRate
        System.out.println("Giảm giá dịch vụ cho Gold: " + DiscountRate.getServiceDiscountRate("Gold"));
        System.out.println("Giảm giá sản phẩm cho Gold: " + DiscountRate.getProductDiscountRate("Gold"));

        // Kiểm tra khách hàng có nhập loại thành viên sai
        try {
            customer1.setMemberType("Diamond"); // Lỗi vì "Diamond" không hợp lệ
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
