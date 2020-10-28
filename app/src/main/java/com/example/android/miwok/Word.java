package com.example.android.miwok;

public class Word {
    private final String mDefaultTranslation;
    private final String mMiwokTranslation;
    private  int mimageResourceId = NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED = -1;
    private  int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mimageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mimageResourceId;
    }

    public boolean hasImage(){
        return  mimageResourceId != NO_IMAGE_PROVIDED;
    }
    public  int getAudioResourceId(){
        return mAudioResourceId;
    }
}


