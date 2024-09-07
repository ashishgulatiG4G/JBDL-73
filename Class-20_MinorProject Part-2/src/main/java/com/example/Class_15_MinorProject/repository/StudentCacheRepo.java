package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentCacheRepo {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public Student getStudent(Integer studentId) {
        Object result = this.redisTemplate.opsForValue().get(getKey(studentId));
        return (Student) result;
    }

    public void setStudent(Student student) {
        this.redisTemplate.opsForValue().set(getKey(student.getId()), student,
                                            Constants.STUDENT_CACHE_EXPIRY,
                                            TimeUnit.MINUTES);
    }

    public String getKey(Integer studentId) {
        return Constants.STUDENT_KEY_PREFIX + studentId;
    }
}



/*

std::1 -> student details
book::1 ->


 */