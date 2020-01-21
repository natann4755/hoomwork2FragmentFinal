package com.example.myhoomrececfragment;

import android.os.Parcel;
import android.os.Parcelable;

public class Moovei implements Parcelable {
    private String titel,text,url;
    private int imeg;

    public Moovei(String titel, String text, int imeg, String url) {
        this.titel = titel;
        this.text = text;
        this.url = url;
        this.imeg = imeg;
    }

    protected Moovei(Parcel in) {
        titel = in.readString();
        text = in.readString();
        url = in.readString();
        imeg = in.readInt();
    }

    public static final Creator<Moovei> CREATOR = new Creator<Moovei>() {
        @Override
        public Moovei createFromParcel(Parcel in) {
            return new Moovei(in);
        }

        @Override
        public Moovei[] newArray(int size) {
            return new Moovei[size];
        }
    };

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImeg() {
        return imeg;
    }

    public void setImeg(int imeg) {
        this.imeg = imeg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titel);
        dest.writeString(text);
        dest.writeString(url);
        dest.writeInt(imeg);
    }
}
