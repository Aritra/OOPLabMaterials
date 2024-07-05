public class Address {
    private String addressLine;
    private String pinCode;
    private String district;
    private String state;   
    public Address(String adL, String pC, String dst, String st){
        this.addressLine = adL;
        this.pinCode = pC;
        this.district = dst;
        this.state = st;
    }
    public void setAddressLine(String adL){
        this.addressLine = adL;
    }
    public String getAddressLine(){
        return this.addressLine;
    }

    public void setPinCode(String pC){
        this.pinCode = pC;
    }
    public String getPinCode(){
        return this.pinCode;
    }

    public void setDistrict(String dst){
        this.district = dst;
    }
    public String getDistrict(){
        return this.district;
    }

    public void setState(String st){
        this.state = st;
    }
    public String getState(){
        return this.state;
    }
}
