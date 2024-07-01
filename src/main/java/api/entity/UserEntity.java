package api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserEntity implements Serializable {

    private String userId;
    private String username;
    private String userAddress;

    public UserEntity() {
    }

    public UserEntity(String userId){
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
