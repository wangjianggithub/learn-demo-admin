package api.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author young
 * @date 2022/8/19 21:36
 * @description: 响应结果枚举类
 */

@AllArgsConstructor
@Getter
public enum ResponseEnum {
    /**响应成功**/
    SUCCESS(200, "操作成功"),
    /**操作失败*/
    FAIL(201,"获取数据失败"),
    /**错误请求**/
    ERROR(400,"错误请求"),
    /**页面未找到**/
    NOT_FOUND(404,"页面未找到"),
    /**系统异常**/
    SYS_ERROR(-1,"系统异常"),
    /*信息已存在*/
    MSG_ERROR(409,"信息已存在");
    /**响应码**/
    private final Integer code;

    /** 结果 **/
    private  final String  resultMessage;

    public static ResponseEnum getResultCode(Integer code){
        for (ResponseEnum value : ResponseEnum.values()) {
            if (code.equals(value.getCode())){
                return value;
            }
        }
        return ResponseEnum.ERROR;
    }
    /*
    简单测试一下
     */
    public static void main(String[] args) {
        ResponseEnum resultCode = ResponseEnum.getResultCode(100);
        System.out.println(resultCode);
    }
}
