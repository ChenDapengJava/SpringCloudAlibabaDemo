package cn.chendapeng.springcloud.userservice.vo;

import lombok.Data;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，做事要善始善终！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-08-22 15:26
 */
@Data
public class UserVO {

    private String userName;

    private Integer age;

    private String nickName;

    public UserVO() {
    }

    public UserVO(String userName, Integer age, String nickName) {
        this.userName = userName;
        this.age = age;
        this.nickName = nickName;
    }
}
