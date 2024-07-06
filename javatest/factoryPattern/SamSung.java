package factoryPattern;

public class SamSung extends PhoneFactory {
    @Override
    protected void setPhoneName(String phoneName) {
        super.phoneName = phoneName;
    }

    @Override
    protected String getPhoneName() {
        return "Samsung is picked: " + phoneName;
    }
}
