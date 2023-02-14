package com.letelumiere.twitterreverse.domain.api.model.userData;

import java.util.ArrayList;

public class UserData {

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
