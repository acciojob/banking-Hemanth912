package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, double minBalance, String tradeLicenseId) {
        super(name, balance, minBalance);
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance<5000)
            throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean valid = true;
        int n=tradeLicenseId.length();
        for(int i=0;i<n-1;i++)
        {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1))
            {
                valid=false;
                break;
            }
        }
        if(valid)
            return;

        char[] charInLicense = tradeLicenseId.toCharArray();
        Arrays.sort(charInLicense);

        for(int i=1;i<charInLicense.length;i++)
        {
            if(charInLicense[i]==charInLicense[i-1])
            {
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}
