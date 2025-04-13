package ex7;

public class DiscountRate {
    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold = 0.15;
    private static double serviceDiscountSilver = 0.1;
    private static double productDiscountPremium = 0.1;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSilver = 0.1;
//equalsIgnoreCase hàm so sánh không phân biệt chữa Hoa với chữ Thường
    public static double getServiceDiscountRate(String type) {
        if (type.equalsIgnoreCase("Premium")) {
            return serviceDiscountPremium;
        } else if (type.equalsIgnoreCase("Gold")) {
            return serviceDiscountGold;
        } else {
            return serviceDiscountSilver;
        }
    }

    public static double getProductDiscountRate(String type) {
        if (type.equalsIgnoreCase("Premium")) {
            return productDiscountPremium;
        } else if (type.equalsIgnoreCase("Gold")) {
            return productDiscountGold;
        } else {
            return productDiscountSilver;
        }
    }
}
