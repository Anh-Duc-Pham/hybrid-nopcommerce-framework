package factoryPattern;

public class User {
    public static void main(String[] args) {
        PhoneFactory phone;
        phone = getPhone("lenovo");
        phone.setPhoneName("lenovo x5");
        System.out.println(phone.getPhoneName());
    }

    public static PhoneFactory getPhone(String phoneType) {
        PhoneFactory phoneFactory;
        if(phoneType.equalsIgnoreCase("iphone")){
            phoneFactory = new iPhone();
        } else if (phoneType.equalsIgnoreCase("samsung")){
            phoneFactory = new SamSung();
        } else {
            throw new RuntimeException("your pick is not available");
        }

        return phoneFactory;
    }
}
