package org.example.dao.entities;

import java.time.LocalDate;
import java.util.Objects;


public class User {

    private Integer id;

    private String firstName;

    private String secondName;

    private String thirdName;

    private String sex;

    private LocalDate birthDate;

    private String job;

    private UserRoles userRoles;

    private UserContactInfo userContactInfo;

    public User() {
    }

    public User(Integer id, String firstName, String secondName,
                String thirdName, String sex, LocalDate birthDate,
                String job,
                UserRoles userRoles,
                UserContactInfo userContactInfo) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.job = job;
        this.userRoles = userRoles;
        this.userContactInfo = userContactInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public UserContactInfo getUserContactInfo() {
        return userContactInfo;
    }

    public void setUserContactInfo(UserContactInfo userContactInfo) {
        this.userContactInfo = userContactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(thirdName, user.thirdName) && Objects.equals(sex, user.sex) && Objects.equals(birthDate, user.birthDate) && Objects.equals(job, user.job) && userRoles == user.userRoles && Objects.equals(userContactInfo, user.userContactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, thirdName, sex, birthDate, job, userRoles, userContactInfo);
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", thirdName='" + thirdName + '\'' +
               ", sex='" + sex + '\'' +
               ", birthDate=" + birthDate +
               ", job='" + job + '\'' +
               ", userRoles=" + userRoles +
               ", userContactInfo=" + userContactInfo +
               '}';
    }

    public static final class UserBuilder {
        private Integer id;
        private String firstName;
        private String secondName;
        private String thirdName;
        private String sex;
        private LocalDate birthDate;
        private String job;
        private UserRoles userRoles;
        private UserContactInfo userContactInfo;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder withThirdName(String thirdName) {
            this.thirdName = thirdName;
            return this;
        }

        public UserBuilder withSex(String sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder withJob(String job) {
            this.job = job;
            return this;
        }

        public UserBuilder withUserRoles(UserRoles userRoles) {
            this.userRoles = userRoles;
            return this;
        }

        public UserBuilder withUserContactInfo(UserContactInfo userContactInfo) {
            this.userContactInfo = userContactInfo;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setThirdName(thirdName);
            user.setSex(sex);
            user.setBirthDate(birthDate);
            user.setJob(job);
            user.setUserRoles(userRoles);
            user.setUserContactInfo(userContactInfo);
            return user;
        }
    }
}
