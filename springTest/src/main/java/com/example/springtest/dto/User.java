package com.example.springtest.dto;

import com.example.springtest.annotation.YearMonth;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @NotBlank // null, "", " " 불가
    @Size(min = 1, max = 100)
    private String name;

    @Min(value = 1) @Max(value = 90) // 최소 최대 값
    @NotNull
    private Integer age;

    @Email
    private String email;

    // 정규식 적용
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;

//    @Size(min = 6, max = 6)
    @YearMonth
//    private String reqYearMonth; // yyyyMMdd

//    @AssertTrue(message = "날짜 형식이 맞지 않습니다.")
//    public boolean isReqYearMonthValidation() { // AssertTrue 어노테이션이 실행되기 위해서는 메서드명을 is로 시작해야함
//        try {
//            LocalDate.parse(this.reqYearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }

//    @Valid // Car DTO의 Validation을 실행하고 싶으면 @Valid를 써야함
//    private List<Car> cars;

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", reqYearMonth='" + reqYearMonth + '\'' +
//                ", cars=" + cars +
//                '}';
//    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", reqYearMonth='" + reqYearMonth + '\'' +
//                '}';
//    }

    @Builder
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
