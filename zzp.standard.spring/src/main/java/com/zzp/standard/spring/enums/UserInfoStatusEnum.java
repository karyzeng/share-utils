package com.zzp.standard.spring.enums;

/**
 * @Description 用户信息状态枚举
 * @Author zzp
 * @since 2021.07.14
 **/
public enum UserInfoStatusEnum {

    DISABLE(0, "禁用"),
    ENABLE(1, "启用");

    public final Integer id;
    public final String name;

    private UserInfoStatusEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserInfoStatusEnum getById(Integer id) {
        for (UserInfoStatusEnum e : UserInfoStatusEnum.values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
