package org.example.dao.entities;

public class UserContactInfo {

    private Integer userId;
    private String address;

    private Long telephone;

    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserContactInfo() {
    }

    public UserContactInfo(Integer userId, String address, Long telephone, String email) {
        this.userId = userId;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserContactInfo{" +
               "userId=" + userId +
               ", address='" + address + '\'' +
               ", telephone=" + telephone +
               ", email='" + email + '\'' +
               '}';
    }


    public static final class UserContactInfoBuilder {
        private Integer userId;
        private String address;
        private Long telephone;
        private String email;

        private UserContactInfoBuilder() {
        }

        public static UserContactInfoBuilder anUserContactInfo() {
            return new UserContactInfoBuilder();
        }

        public UserContactInfoBuilder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public UserContactInfoBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserContactInfoBuilder withTelephone(Long telephone) {
            this.telephone = telephone;
            return this;
        }

        public UserContactInfoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserContactInfo build() {
            UserContactInfo userContactInfo = new UserContactInfo();
            userContactInfo.setUserId(userId);
            userContactInfo.setAddress(address);
            userContactInfo.setTelephone(telephone);
            userContactInfo.setEmail(email);
            return userContactInfo;
        }
    }
}
