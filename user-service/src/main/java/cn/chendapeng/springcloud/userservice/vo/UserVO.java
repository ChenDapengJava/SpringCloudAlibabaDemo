package cn.chendapeng.springcloud.userservice.vo;

import lombok.Data;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索。
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

    /**
     * 测试负载均衡
     */
    private String serverPort;

    public UserVO() {
    }

    public UserVO(String userName, Integer age, String nickName) {
        this.userName = userName;
        this.age = age;
        this.nickName = nickName;
    }
}
