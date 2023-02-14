package com.letelumiere.twitterreverse.domain.api.model.userData;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserData {

    @Id
    @Column(name = "id")
    private Long id;

    public class Block {
        long originId;
        long blockId; 
        String blockedTime;
    }

    public class Bookmark {
        long id;
        long twitId;
        String markedTime;
    }

    public class Mute {    
        long originId;
        long muteId;
    }

    public class List {
        long id;
        long originId;
        ArrayList<Long> member;
        String title;
        boolean open;
    }

    public class Circle {
        long originId;
        ArrayList<Long> memberId;
    }

    public class MemberList {
        long id;
        long originId;
        ArrayList<Long> member;
        String title;
        boolean open;
    }

    public class Report {
        long id;
        String category;
    }
}
