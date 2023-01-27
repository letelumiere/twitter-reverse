package com.letelumiere.twitterreverse.domain.api.model.userData;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Origin;

@Entity
public class UserData extends Origin{
    
    @Column
    private ArrayList<Block> block;
    
    @Column
    private ArrayList<Bookmark> bookMark;
    
    @Column
    private ArrayList<Circle> circle;
    
    @Column
    private ArrayList<List> list;

    @Column
    private ArrayList<Favorite> favorite;
    
    @Column
    private ArrayList<Report> report;
    
    @Column
    private ArrayList<Mute> mute;
}
