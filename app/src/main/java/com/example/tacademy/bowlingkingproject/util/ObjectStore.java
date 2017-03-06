package com.example.tacademy.bowlingkingproject.util;

import com.example.tacademy.bowlingkingproject.model.user.UserInfoVo;

/**
 * 앱상에서 전역적으로 객체에 무관하게 고유한 하나의 정보들을 저장하는 싱글톤
 */
public class ObjectStore {
    private static ObjectStore ourInstance = new ObjectStore();

    public static ObjectStore getInstance() {
        return ourInstance;
    }

    private ObjectStore() {
    }

    //회원가입 정보(유저정보)
    private UserInfoVo joinInfo; //private을 선언하면 접근할수 있게 getter setter를 만들어줘야함

    public UserInfoVo getJoinInfo() { //set을 필요없으니 get만
        if( joinInfo == null ) joinInfo = new UserInfoVo(); //info 코딩 계속 나오니까 익숙하지 않아 귀찮은 구조니까 계속intent로 실어주고 받고 셋팅하고 반복해야되므로 쉽게 가기 위해서
        return joinInfo;
    }

}