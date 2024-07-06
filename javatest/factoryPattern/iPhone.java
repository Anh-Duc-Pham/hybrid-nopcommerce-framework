package factoryPattern;

public class iPhone extends PhoneFactory {
    @Override
    protected void setPhoneName(String phoneName) {
        super.phoneName = phoneName;
    }

    @Override
    protected String getPhoneName() {
        return "iphone is picked: " + phoneName;
    }
}
