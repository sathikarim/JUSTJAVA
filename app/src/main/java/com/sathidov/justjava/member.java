package com.sathidov.justjava;

import android.os.Parcel;
import android.os.Parcelable;

public class member  implements Parcelable{
    private String sEmail;
    private String sUesrname;
    private String sPassword;
    public member(String email,String username,String pasword){
        sEmail=email;
        sUesrname=username;
        sPassword=pasword;
    }

    protected member(Parcel in) {
        sEmail = in.readString();
        sUesrname = in.readString();
        sPassword = in.readString();
    }

    public static final Creator<member> CREATOR = new Creator<member>() {
        @Override
        public member createFromParcel(Parcel in) {
            return new member(in);
        }

        @Override
        public member[] newArray(int size) {
            return new member[size];
        }
    };

    public String getemail(){
        return sEmail;
        }
    public String getUesrname(){
        return sUesrname;
    }
    public String getPasword(){
        return sPassword;
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sEmail);
        dest.writeString(sUesrname);
        dest.writeString(sPassword);
    }
}
